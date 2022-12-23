package xyz.fusheng.code.springboot.model;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author code-fusheng
 */
@SpringBootApplication
@ComponentScan(basePackages = "xyz.fusheng.code")
@NacosPropertySource(dataId = "code-spring-boot-model-dev.yaml", autoRefreshed = true)
public class ModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelApplication.class, args);
    }

}
