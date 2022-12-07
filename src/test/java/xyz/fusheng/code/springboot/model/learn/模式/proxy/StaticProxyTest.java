package xyz.fusheng.code.springboot.model.learn.模式.proxy;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 静态代理测试类
 * @date 2022-12-06 20:05:06
 */

public class StaticProxyTest {

    public static void main(String[] args) {

        // 生成被代理对象
        User user = new User();
        // 生成代理，顺便告诉代理它要代理谁
        UserProxy userProxy = new UserProxy(user);
        // 触发代理方法
        userProxy.sayHello("Test");

    }

}

