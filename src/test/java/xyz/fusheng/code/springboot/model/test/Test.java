package xyz.fusheng.code.springboot.model.test;

import org.apache.commons.lang3.RandomUtils;

import java.util.Optional;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc Test
 * @date 2023-04-19 13:52:43
 */

public class Test {

    public static void main(String[] args) {

        // parkNavigationFloorSpaceCount.getLeftCount()==null? 0:parkNavigationFloorSpaceCount.getLeftCount()+ 1

        Integer count = null;

        System.out.println(count == null ? 0 : count + 1);

        System.out.println(Optional.ofNullable(count).orElse(0) + 1);

        int i = RandomUtils.nextInt(1, 8);
        System.out.println(i);

    }

}

