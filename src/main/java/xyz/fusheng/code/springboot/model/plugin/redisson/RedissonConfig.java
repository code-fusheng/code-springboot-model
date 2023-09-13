package xyz.fusheng.code.springboot.model.plugin.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc Redisson 配置类
 * @date 2022-12-20 10:39:39
 */

@Configuration
public class RedissonConfig {

    /**
     * 对 Redisson 的使用都是通过 RedissonClient 对象
     * 服务停止后调用 shutdown 方法
     * @return
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() {
        // 1. 创建配置
        Config config = new Config();
        // 2. 单机模式
        config.useSingleServer()
                .setAddress("redis://47.111.158.6:16390")
                .setPassword("Xcode-redis?")
                .setDatabase(0);
        return Redisson.create(config);
    }

}

