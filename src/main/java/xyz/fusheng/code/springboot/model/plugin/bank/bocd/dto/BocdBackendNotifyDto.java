package xyz.fusheng.code.springboot.model.plugin.bank.bocd.dto;

import lombok.Data;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc BocdBackendNotifyDto
 * @date 2023-09-05 4:42 PM:48
 */

@Data
public class BocdBackendNotifyDto {

    /**
     * 响应码
     */
    private String respCode;

    /**
     * 应答信息
     */
    private String respMsg;

    /**
     * 签名方法
     */
    private String signMethod;

    /**
     * 证书ID
     */
    private String certId;

    /**
     * 签名
     */
    private String signAture;

    /**
     * 商户订单号
     */
    private String txnOrderId;

    /**
     * 商户订单发送时间
     */
    private String txnOrderTime;

    /**
     * 平台交易流水号
     */
    private String respTxnSsn;

    /**
     * 平台受理时间
     */
    private String respTxnTime;

    /**
     * 清算金额
     */
    private String settleAmt;

    /**
     * 清算币种类型
     */
    private String settleCcyType;

    /**
     * 清算日期
     */
    private String settleDate;

}

