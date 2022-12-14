package xyz.fusheng.code.springboot.model.learn.并发.Executors;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @FileName: SingleThreadExecutorTest
 * @Author: code-fusheng
 * @Date: 2022/2/8 8:12 下午
 * @Version: 1.0
 * @Description: 固定线程-线程池
 */

public class FixedThreadPoolTest {

    static class TargetTask implements Runnable {
        static AtomicInteger taskNo = new AtomicInteger(1);
        private String taskName;
        public TargetTask() {
            taskName = "task-" + taskNo.get();
            taskNo.incrementAndGet();
        }
        @SneakyThrows
        @Override
        public void run() {
            System.out.println("任务:" + taskName + "开始运行");
            Thread.sleep(1000);
            System.out.println("任务:" + taskName + "结束运行");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 50; i++) {
            threadPool.execute(new TargetTask());
            Thread.sleep(1000);
            // threadPool.submit(new TargetTask());
        }
        Thread.sleep(100000);
        threadPool.shutdown();

    }

}
