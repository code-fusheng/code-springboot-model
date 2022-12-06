package xyz.fusheng.code.springboot.model.learn.线程;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @FileName: GuavaThreadPoolLearn
 * @Author: code-fusheng
 * @Date: 2022/10/17 17:23
 * @Version: 1.0
 * @Description: Guava 线程池 Learn
 */

public class GuavaThreadPoolLearn {

    /**
     * 测试创建 Guava 线程池
     */
    public static void testCreate() {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ListeningExecutorService gPool = MoreExecutors.listeningDecorator(threadPool);
    }

    public static void main(String[] args) {
        testCreate();
    }

}
