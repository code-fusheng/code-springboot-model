package xyz.fusheng.code.springboot.model.plugin.bank.bocd.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc PrePayOrderDto
 * @date 2023-09-04 6:41 PM:26
 */

@Data
public class PrePayOrderDto {

    /**
     * 编码方式(默认: UTF-8)
     */
    private String encoding;

    /**
     * 签名方式(01: RSA)
     */
    private String signMethod;

    /**
     * (SDK & API编号)
     */
    private String sdkAppId;

    /**
     * 证书ID
     * 通过证书接入的填写证书编号
     * 通过API插件自动获取
     * 通过秘钥接入填写商户号
     */
    private String certId;

    /**
     * 签名
     */
    private String signAture;

    /**
     * 交易类型(如: 1000)
     */
    private String txnType;

    /**
     * 交易子类型(如: 100000)
     */
    private String txnSubType;

    /**
     * 接入方式(如: 01)
     */
    private String aesWay;

    /**
     * 商户编号 - 普通商户或一级商户的商户号
     */
    private String merId;

    /**
     * 商户名称 - 一级商户下的二级商户交易时必送
     */
    private String merName;

    /**
     * 二级商户号
     */
    private String secMerId;

    /**
     * 二级商户公众号ID - 微信APP支付必送
     */
    private String secMerAppId;

    /**
     * 前台通知地址 - 前台返回商户结果时使用，前台类交易需上送
     */
    private String fromEndUrl;

    /**
     * 后台通知地址 - 后台返回商户结果时使用，如上送，则发送商户后台交易结果通知
     */
    private String backEndUrl;

    /**
     * 商户订单号 - 商户系统内部的订单号 32个字符内、可包含字母, 确保在商户系统唯一
     */
    private String txnOrderId;

    /**
     * 商户订单发送时间 - 商户发送交易时间，格式[yyyyMMddHHmmss] ; 商户端生成
     */
    private String txnOrderTime;

    /**
     * 商户自订单信息数据域
     */
    private JSONObject txnSecOrderInfoList;

    /**
     * 客户端地址 - 前台交易，有IP防钓鱼要求的商户上送
     */
    private String txnCustmerIP;

    /**
     * 用户编号 - 商户或渠道用户绑定信息查询条件（最少8位）
     */
    private String txnUserId;

    /**
     * 银行编号
     * String(8)
     */
    private String bankCode;

    /**
     * 支付订单描述 - 商品或支付单简要描述
     */
    private String txnOrderBody;

    /**
     * 支付金额(分/整数) 订单总金额
     */
    private String txnAmt;

    /**
     * 币种(默认:156 人民币)
     */
    private String txnCcyType;

    /**
     * 商户产品号(微信支付必送)
     */
    private String txnProductId;

    /**
     * 支付 url 类型(00 返回收银台 url / 01 返回订单二维码 url)
     */
    private String urlType;

    /**
     * 商户拓展信息域(如:门店、设备号)
     */
    private String merExtInfo;

    /**
     * 订单失效时间(格式: yyyyMMddHHmmss / 1~60分钟)
     */
    private String txnOrderTimeEnd;

}

