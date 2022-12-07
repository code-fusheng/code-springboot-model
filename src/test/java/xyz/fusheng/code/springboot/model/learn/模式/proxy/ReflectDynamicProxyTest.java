package xyz.fusheng.code.springboot.model.learn.模式.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 基于反射的动态代理测试
 * @date 2022-12-06 21:11:17
 *
 * 对于基于反射的动态代理而言，有一个必需的条件：被代理的对象必须有一个父接口。
 */

public class ReflectDynamicProxyTest {

    public static void main(String[] args) {

        // 创建被代理对象
        User user = new User();
        // 初始化一个 ProxyHandler
        ProxyHandler proxyHandler = new ProxyHandler(user);
        // 使用 Proxy 类的静态方法生成代理对象 userProxy
        UserInterface userProxy = (UserInterface) Proxy.newProxyInstance(User.class.getClassLoader(), new Class[]{UserInterface.class}, proxyHandler);
        userProxy.sayHello("code-fusheng");

    }

}

class ProxyHandler<T> implements InvocationHandler {

    private T target;

    public ProxyHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("pre handler");
        Object ans = method.invoke(target, args);
        System.out.println("post handler");
        return ans;
    }

}

