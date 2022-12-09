package xyz.fusheng.code.springboot.model.learn.枚举;

import xyz.fusheng.code.springboot.core.enums.EnabledStatusEnum;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc EnumTest
 * @date 2022-12-08 15:49:31
 */

public class EnumTest {

    public static void main(String[] args) {

        System.out.println(EnabledStatusEnum.ENABLED.equals("ENABLED"));
        System.out.println(EnabledStatusEnum.ENABLED.equals(1));

    }

}

