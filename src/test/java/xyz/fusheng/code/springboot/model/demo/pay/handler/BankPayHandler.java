package xyz.fusheng.code.springboot.model.demo.pay.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import xyz.fusheng.code.springboot.model.demo.pay.PayChannelEnum;
import xyz.fusheng.code.springboot.model.demo.pay.PayHandler;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc BankPayHandler
 * @date 2022-12-21 20:40:42
 */

@Slf4j
@Component
public class BankPayHandler implements PayHandler {
    @Override
    public PayChannelEnum getChannel() {
        return PayChannelEnum.BANK_PAY;
    }

    @Override
    public void dealPay() {
        log.info("银行卡支付逻辑...");
    }
}

