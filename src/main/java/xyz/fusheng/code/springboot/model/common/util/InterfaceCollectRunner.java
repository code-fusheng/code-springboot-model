package xyz.fusheng.code.springboot.model.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc InterfaceCollectRunner
 * @date 2022-12-02 09:23:27
 */

@Slf4j
//@Component
//@Order(value = 1)
public class InterfaceCollectRunner implements ApplicationContextAware, CommandLineRunner {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        this.applicationContext = arg0;
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String, Object> controllers = applicationContext.getBeansWithAnnotation(RestController.class);
        for (Map.Entry<String, Object> entry : controllers.entrySet()) {
            Object value = entry.getValue();
            log.info("controller:{} - value:{}", entry.getKey(), value);
            Class<?> aClass = AopUtils.getTargetClass(value);
            log.info("class:{}", aClass);
            RequestMapping requestMapping = aClass.getAnnotation(RequestMapping.class);
            log.info("value:{}", requestMapping.value());
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                Annotation[] annotations = method.getAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof PostMapping) {
                        log.info("post:{}", ((PostMapping) annotation).value());
                    }
                    if (annotation instanceof GetMapping) {
                        log.info("get:{}", ((GetMapping) annotation).value());
                    }
                }
            }
        }
    }

}

