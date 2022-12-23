package xyz.fusheng.code.springboot.model.demo.pay;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import xyz.fusheng.code.springboot.core.enums.BaseEnum;
import xyz.fusheng.code.springboot.core.enums.EnabledStatusEnum;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 支付渠道枚举
 * @date 2022-12-21 20:18:02
 */

@Getter
public enum PayChannelEnum implements BaseEnum<String> {

    WECHAT_PAY("wechat_pay", "微信支付"),
    ALI_PAY("ali_pay", "支付宝支付"),
    BANK_PAY("bank_pay", "银行卡支付"),
    ;

    @EnumValue
    @JsonValue
    private String code;
    private String value;

    PayChannelEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PayChannelEnum of(String code) {
        return BaseEnum.of(PayChannelEnum.class, code);
    }

}