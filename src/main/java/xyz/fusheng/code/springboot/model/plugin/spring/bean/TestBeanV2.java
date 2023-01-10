package xyz.fusheng.code.springboot.model.plugin.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc TestBeanV2
 * @date 2022-12-23 17:24:09
 */

public class TestBeanV2 implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void testAware() {
        TestBean testBean = (TestBean) beanFactory.getBean("testBean");
        testBean.say();
    }

}

