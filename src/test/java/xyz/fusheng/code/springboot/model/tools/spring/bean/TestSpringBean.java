package xyz.fusheng.code.springboot.model.tools.spring.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.Element;
import xyz.fusheng.code.springboot.model.plugin.spring.bean.TestBean;
import xyz.fusheng.code.springboot.model.plugin.spring.bean.TestBeanV2;
import xyz.fusheng.code.springboot.model.plugin.spring.bean.TestBeanV3;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc BeanFactoryTest
 * @date 2022-12-22 15:41:12
 *
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSpringBean {

    /**
     * 功能分析
     * 1. 读取配置文件 applicationContext.xml;
     * 2. 根据配置文件找到对应类的配置，并实例化;
     * 3. 调用实例化后的实例。
     */
    @Test
    public void testSimpleBeanLoad() {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-learn.xml"));
        TestBean testBean = (TestBean) beanFactory.getBean("testBean");
        System.out.println(testBean.getTestStr());
    }

    /**
     *  * 1. 获取对 XML 文件的验证模式
     *  * 2. 加载 XML 文件，并得到对应的 Document
     *  * 3. 根据返回的 Document 注册 Bean 信息
     */

    /**
     * 默认标签的解析
     * {@link DefaultBeanDefinitionDocumentReader#parseDefaultElement(Element, BeanDefinitionParserDelegate)}
     */

    /**
     * Bean 定义属性清单
     * {@link AbstractBeanDefinition}
     */


    /**
     * ClassPathXmlApplicationContext
     * 解析以及功能实现在 org.springframework.context.support.AbstractApplicationContext#refresh() 中
     * 1. 初始化前的准备工作，例如对系统属性或者环境变量进行准备及验证；
     * 2. 初始化 BeanFactory，并进行 XML 文件读取；
     * 3. 对 BeanFactory 进行各种功能填充；
     * 4. 子类覆盖方法做额外的处理；
     * 5. 激活各种 BeanFactory 处理器；
     * 6. 注册拦截 Bean 创建的 Bean 处理器，这里只做注册，真正的调用是在 getBean 时候；
     * 7. 为上下文初始化 Message 源，即对不同语言的消息体进行国际化处理；
     * 8. 初始化应用消息广播器，并放入 `applicationEventMulticaster` bean 中；
     * 9. 留给子类来初始化其他的 Bean；
     * 10. 在所有注册的 Bean 中查找 listener bean，注册到消息广播器中；
     * 11. 初始化剩下的非惰性单实例；
     * 12. 完成刷新过程，通知生命周期处理器 lifecycleProcessor 刷新过程，通知发出 ContextRefreshEvent 通知别人。
     */
    @Test
    public void testApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-learn.xml");
        TestBean testBean = (TestBean) context.getBean("testBean");
        System.out.println(testBean.getTestStr());
    }

    @Test
    public void testBeanAware() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-learn.xml");
        TestBeanV2 beanV2 = (TestBeanV2) context.getBean("testBeanV2");
        beanV2.testAware();
    }

    @Test
    public void testBeanExtend() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-learn.xml");
        TestBeanV3 beanV3 = (TestBeanV3) context.getBean("testBeanV3");
    }

}

