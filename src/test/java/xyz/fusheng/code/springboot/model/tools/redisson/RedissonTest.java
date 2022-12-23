package xyz.fusheng.code.springboot.model.tools.redisson;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc Redisson 测试类
 * @date 2022-12-20 10:48:17
 * 公平锁（Fair Lock）
 * 联锁（MultiLock）
 * 红锁（RedLock）
 * 读写锁（ReadWriteLock）
 * 可过期性信号量（PermitExpirableSemaphore）
 * 闭锁（CountDownLatch）
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedissonTest {

    @Autowired
    private RedissonClient redisson;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void TestRedisson() {
        System.out.println(redisson);
    }

    /**
     * 分布式锁
     */
    @Test
    public void TestLock1() {
        System.out.println("test lock-1 start");
        // 1. 获取锁，只要锁名字一样，获取到的就是同一把锁
        RLock lock = redisson.getLock("test-lock-1");
        // 2. 加锁
        // lock.lock(8, TimeUnit.SECONDS);  手动释放锁时间不能低于业务执行时间 - 会报错
        lock.lock();
        try {
            System.out.println("加锁成功 ==> 线程ID:" + Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // 3. 解锁
            lock.unlock();
            System.out.println("Finally 释放锁成功 ==> 线程ID:" + Thread.currentThread().getName());
        }
        System.out.println("test lock-1 end");
    }

    @Test
    public void testLockPro() {
        ExecutorService threadPool = Executors.newFixedThreadPool(1,
                new ThreadFactoryBuilder().setNameFormat("test-lock" + "%d")
                        .build());
        IntStream.rangeClosed(1, 10).forEach(i -> {
            threadPool.execute(() -> {
                RLock lock = redisson.getLock("test-lock");
                lock.lock();
                System.out.println(Thread.currentThread().getName() + ":" + lock.isLocked());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            });
        });
    }

    @Test
    public void TestLock2() throws InterruptedException {

        // 这里如果加锁的是 main 线程，后续的子线程都能重入；但是如果这里加锁的是 thread 线程，后续的子线程不一定能重入；
        new Thread(() -> {
            RLock lock1 = redisson.getLock("test-lock-2");
            lock1.lock();
            System.out.println(Thread.currentThread().getName() + ":" + lock1.isLocked());
        }).start();

        // 启动其他线程获取锁
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                RLock lock = redisson.getLock("test-lock-2");
                System.out.println(Thread.currentThread().getName() + ":" + lock.isLocked());
                lock.lock();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }).start();
        }
    }

    @Test
    public void testTryLock() {
        RLock lock = redisson.getLock("try-lock-0");
        try {
            boolean lockRes = lock.tryLock(6, 12, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getId() + ":" + lockRes);
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 分布式读写锁
     * 写锁 是一个排他锁（互斥锁）
     * 读锁 是一个共享锁
     * 读锁 + 读锁：等于没加锁，可以并发读
     * 读锁 + 写锁：写锁需要等待读锁释放锁
     * 写锁 + 写锁：互斥，需要等待写对方释放锁
     * 写锁 + 读锁：读锁需要等待写锁释放
     */
    @Test
    public void TestReadWriteLock() throws InterruptedException {
        RReadWriteLock rwLock = redisson.getReadWriteLock("any-rw-Lock-1");
        // 最常见的使用方法
        rwLock.readLock().lock();
        rwLock.writeLock().lock();

        // 10s 以后自动解锁 无需调用 unlock 方法手动解锁
        rwLock.readLock().lock(10, TimeUnit.SECONDS);
        // &
        rwLock.writeLock().lock(10, TimeUnit.SECONDS);

        boolean readRes = rwLock.readLock().tryLock(100, 10, TimeUnit.SECONDS);
        // &
        boolean writeRes = rwLock.writeLock().tryLock(100, 10, TimeUnit.SECONDS);

    }

    /**
     * 分布式信号量
     * @throws InterruptedException
     */
    @Test
    public void testSemaphore() throws InterruptedException {
        redisTemplate.opsForValue().set("count", 100);
        RSemaphore count = redisson.getSemaphore("count");
        // 获取信号
        count.acquire();
        Thread.sleep(10000);
        // 释放信号 多次执行释放信号量操作，剩余信号量会一直增加，而不是到 3 后就封顶了
        count.release();
    }

}

