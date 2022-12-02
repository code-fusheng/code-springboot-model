package xyz.fusheng.code.springboot.model.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc ApplicationContextHolder
 * @date 2022-12-02 10:15:30
 */

@Slf4j
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}

