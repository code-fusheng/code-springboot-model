package xyz.fusheng.code.springboot.model.learn.模式.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyHandler<T> implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib : before");
        Object ans = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib : after");
        return ans;
    }
}