package xyz.fusheng.code.springboot.model.learn.高级.java8;

import cn.hutool.core.io.LineHandler;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc java8 Consumer 消费型接口
 * @date 2022-12-23 12:44:22
 */

public class ConsumerTest {

    public void sum(String a1) {
        System.out.println(a1);
    }

    public void testConsumer() {
        Consumer<String> stringConsumer = (s) -> System.out.println(s.length());
        Arrays.asList("ab", "abc", "a", "abcd").stream().forEach(stringConsumer);
    }

    public static void main(String[] args) {
        Consumer<String> consumer = a1 -> System.out.println(a1);
    }

}

