package xyz.fusheng.code.springboot.model.learn.模式.adapter;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 适配器模式测试
 * @date 2022-12-06 20:50:05
 * 适配器模式（Adapter Pattern）是一种结构型模式，基于该模式设计的类能够在两个或者多个不兼容的类之间起到沟通桥梁的作用
 */

public class AdapterTest {

}

interface Target {
    public void sayHi();
}

// 非标准接口目标类
class Adaptee {
    public void sayHello() {
        System.out.println("Hello");
    }
}

class Adapter implements Target {

    // 目标类的对象
    private Adaptee adaptee;

    // 初始化适配器时可以指定目标类对象
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void sayHi() {
        adaptee.sayHello();
    }
}