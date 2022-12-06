package xyz.fusheng.code.springboot.model.utils;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc RandomUtil
 * @date 2022-11-30 10:02:56
 */

public class RandomUtil {

    public static void main(String[] args) {

        for (;;) {
            System.out.println(RandomUtils.nextLong(1, 200));
        }

    }
    
}

