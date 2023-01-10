package xyz.fusheng.code.springboot.model.learn.模式.template_method;

import java.math.BigDecimal;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc TestTemplateMethod
 * @date 2022-12-23 12:34:58
 */

public class TestTemplateMethod {

    public static void testV1() {
        SaveMoneyHandler handler = new SaveMoneyHandler();
        handler.execute();
    }

    public static void testV2() {
        BankBusinessHandler handler = new BankBusinessHandler();
        handler.save(new BigDecimal("1000"));
    }

    public static void main(String[] args) {
        testV2();
    }

}

