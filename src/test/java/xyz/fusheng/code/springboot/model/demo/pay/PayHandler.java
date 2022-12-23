package xyz.fusheng.code.springboot.model.demo.pay;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 支付渠道抽象接口
 * @date 2022-12-21 20:26:02
 */

public interface PayHandler {

    // 支付渠道类型标识
    PayChannelEnum getChannel();

    // 支付处理实现逻辑
    void dealPay();

}