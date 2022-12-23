package xyz.fusheng.code.springboot.model.demo.pay.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import xyz.fusheng.code.springboot.model.demo.pay.PayChannelEnum;
import xyz.fusheng.code.springboot.model.demo.pay.PayHandler;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 微信支付处理器
 * @date 2022-12-21 20:28:28
 */

@Slf4j
@Component
public class WechatPayHandler implements PayHandler {

    @Override
    public PayChannelEnum getChannel() {
        return PayChannelEnum.WECHAT_PAY;
    }

    @Override
    public void dealPay() {
        log.info("微信支付逻辑...");
    }
}

