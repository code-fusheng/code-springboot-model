package xyz.fusheng.code.springboot.model.demo.pay.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xyz.fusheng.code.springboot.model.demo.pay.PayChannelEnum;
import xyz.fusheng.code.springboot.model.demo.pay.PayHandler;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 支付宝支付处理器
 * @date 2022-12-21 20:39:09
 */

@Slf4j
@Component
public class AliPayHandler implements PayHandler {

    @Override
    public PayChannelEnum getChannel() {
        return PayChannelEnum.ALI_PAY;
    }

    @Override
    public void dealPay() {
        log.info("支付宝支付逻辑...");
    }
}

