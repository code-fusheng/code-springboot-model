package xyz.fusheng.code.springboot.model.tools.spring.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.Element;
import xyz.fusheng.code.springboot.model.plugin.spring.bean.TestBean;

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
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
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

}

