package xyz.fusheng.code.springboot.model.learn.模式.proxy;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc UserProxy
 * @date 2022-12-06 21:12:23
 */
class UserProxy implements UserInterface {
    private UserInterface target;

    public UserProxy(UserInterface target) {
        this.target = target;
    }

    @Override
    public String sayHello(String name) {
        System.out.println("pre words");
        target.sayHello(name);
        System.out.println("post words");
        return name;
    }

}

