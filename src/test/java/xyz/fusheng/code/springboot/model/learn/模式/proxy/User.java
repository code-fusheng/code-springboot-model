package xyz.fusheng.code.springboot.model.learn.模式.proxy;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc User
 * @date 2022-12-06 21:12:10
 */ // 被代理类
class User implements UserInterface {
    @Override
    public String sayHello(String name) {
        System.out.println("hello: " + name);
        return "OK";
    }
}

