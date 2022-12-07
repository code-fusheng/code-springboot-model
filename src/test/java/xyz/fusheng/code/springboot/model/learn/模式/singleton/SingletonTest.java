package xyz.fusheng.code.springboot.model.learn.模式.singleton;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc SingletonTest
 * @date 2022-12-06 19:56:39
 * 单例模式测试类
 */

public class SingletonTest {

    // 存储唯一的对象
    private static final SingletonTest INSTANCE = new SingletonTest();

    // 防止外部创建对象的类
    private SingletonTest() {};

    // 获取该类的唯一方式
    public static SingletonTest getInstance() {
        return INSTANCE;
    }

}

