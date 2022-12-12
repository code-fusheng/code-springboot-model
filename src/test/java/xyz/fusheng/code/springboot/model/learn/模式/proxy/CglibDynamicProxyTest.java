package xyz.fusheng.code.springboot.model.learn.模式.proxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc Cglib 动态代理测试
 * @date 2022-12-11 10:40:06
 */

public class CglibDynamicProxyTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        // 设置 enhancer 的回调对象
        enhancer.setCallback(new CglibProxyHandler<>());
        // 设置 enhancer 对象的父类
        enhancer.setSuperclass(User.class);
        // 创建代理对象，实际为 User 的子类
        User user = (User) enhancer.create();
        // 通过代理对象调用目标方法
        String hello = user.sayHello("test");
        System.out.println(hello);
    }

}

