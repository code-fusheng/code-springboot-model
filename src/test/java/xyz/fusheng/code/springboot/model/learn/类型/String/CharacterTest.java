package xyz.fusheng.code.springboot.model.learn.类型.String;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @FileName: CharacterTest
 * @Author: code-fusheng
 * @Date: 2022/8/3 10:08
 * @Version: 1.0
 * @Description:
 */


public class CharacterTest {

    public static void main(String[] args) {

        String s = "(";
        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        System.out.println("ASCII Numeric Value: " + bytes[0]);

        String s2 = "（";
        byte[] bytes2 = s2.getBytes(StandardCharsets.US_ASCII);
        System.out.println("ASCII Numeric Value: " + bytes2[0]);

        String stringValue = "(building）";
        List<Integer> listOfIntegers = stringValue.chars()
                .boxed()
                .collect(Collectors.toList());

        for (int i : listOfIntegers) {
            System.out.println("ASCII value " + i);
        }

    }

}
