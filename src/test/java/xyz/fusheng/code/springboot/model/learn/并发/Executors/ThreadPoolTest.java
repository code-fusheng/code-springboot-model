package xyz.fusheng.code.springboot.model.learn.并发.Executors;

/**
 * @FileName: ThreadPoolTest
 * @Author: code-fusheng
 * @Date: 2022/2/8 9:25 下午
 * @Version: 1.0
 * @Description: 标准线程池构建测试
 */

public class ThreadPoolTest {

    public static final ThreadLocal<String> THREAD_LOCAL = ThreadLocal.withInitial(() ->
            new String("test"));

    public static void main(String[] args) {



    }

}
