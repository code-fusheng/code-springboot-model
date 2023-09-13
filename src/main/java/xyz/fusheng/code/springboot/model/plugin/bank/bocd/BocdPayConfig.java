package xyz.fusheng.code.springboot.model.plugin.bank.bocd;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc BocdConfig
 * @date 2023-09-04 6:10 PM:10
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "bocd.pay")
public class BocdPayConfig {

    private String baseUrl;

    // 商户私钥
    private String privateKey;

    // 银行公钥
    private String bocdPublicKey;

}

