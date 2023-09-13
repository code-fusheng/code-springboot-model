package xyz.fusheng.code.springboot.model.controller;

import io.lettuce.core.ScriptOutputType;
import io.swagger.annotations.Api;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fusheng.code.springboot.core.annotaion.NoBodyAdvice;
import xyz.fusheng.code.springboot.core.entity.ResultVo;
import xyz.fusheng.code.springboot.core.exception.BusinessException;
import xyz.fusheng.code.springboot.model.core.mapper.ModelMapper;
import xyz.fusheng.code.springboot.model.model.entity.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc TestController
 * @date 2022-12-01 09:18:54
 */

@RestController
@RequestMapping("/test")
@Api(tags = "测试模块")
public class TestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/testPort")
    public String testPort() {
        return port;
    }

    @Resource
    private ModelMapper modelMapper;

    @PostMapping("/rt0")
    public List<Model> rt0() {
        return modelMapper.selectList(null);
    }

    @PostMapping("/rt1")
    public ResultVo<List<Model>> rt1() {
        return ResultVo.success(modelMapper.selectList(null));
    }

    @PostMapping("/rt2")
    @NoBodyAdvice
    public List<Model> rt2() {
        return modelMapper.selectList(null);
    }

    @PostMapping("/rt3")
    public void rt3() {

    }

    @PostMapping("/exp0")
    public String exp0() {
        throw new BusinessException("测试异常");
    }

    @PostMapping("/exp1")
    public void exp1() {
        throw new BusinessException("测试异常");
    }

    @PostMapping("/exp2")
    public void exp2() {
        throw new RuntimeException("测试");
    }

    @Autowired(required = false)
    private RedissonClient redisson;

    @GetMapping("/lock")
    public void lock() {
        System.out.println("test lock-1 start ==> 线程ID:" + Thread.currentThread().getName());
        // 1. 获取锁，只要锁名字一样，获取到的就是同一把锁
        System.out.println("尝试获取锁 ==> 线程ID:" + Thread.currentThread().getName());
        RLock lock = redisson.getLock("test-lock-1");
        System.out.println("获取锁成功 ==> 线程ID:" + Thread.currentThread().getName());
        // 2. 加锁
        // lock.lock(8, TimeUnit.SECONDS);  自动释放锁时间不能低于业务执行时间 - 会报错
        lock.lock();
        try {
            System.out.println("加锁成功 ==> 线程ID:" + Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // 3. 解锁
            lock.unlock();
            System.out.println("释放锁成功 ==> 线程ID:" + Thread.currentThread().getName());
        }
        System.out.println("test lock-1 end ==> 线程ID:" + Thread.currentThread().getName());
    }
    
}

