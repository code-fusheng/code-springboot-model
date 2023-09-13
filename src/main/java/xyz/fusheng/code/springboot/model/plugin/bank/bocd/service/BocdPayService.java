package xyz.fusheng.code.springboot.model.plugin.bank.bocd.service;

import org.springframework.stereotype.Service;
import xyz.fusheng.code.springboot.model.plugin.bank.bocd.BocdPayConfig;

import javax.annotation.Resource;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc BocdPayService
 * @date 2023-09-04 6:09 PM:52
 */

@Service
public class BocdPayService {

    @Resource
    private BocdPayConfig bocdPayConfig;

    /**
     * 预支付订单
     */
    public void prePayOrder() {

    }

}

