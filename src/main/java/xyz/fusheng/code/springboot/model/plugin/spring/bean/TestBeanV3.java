package xyz.fusheng.code.springboot.model.plugin.spring.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc TestBeanV3
 * @date 2022-12-23 17:35:52
 */

@Slf4j
public class TestBeanV3 implements InitializingBean, DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("test bean 的销毁!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("test bean 的初始化后置属性赋值!");
    }
}

