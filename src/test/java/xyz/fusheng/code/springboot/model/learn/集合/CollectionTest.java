package xyz.fusheng.code.springboot.model.learn.集合;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @FileName: CollectionTest
 * @Author: code-fusheng
 * @Date: 2022/6/8 15:05
 * @Version: 1.0
 * @Description:
 */

public class CollectionTest {

    private static void testJoining() {
        List<String> licenseList = new ArrayList<>();
        //licenseList.add("a");
        //licenseList.add("b");
        String collect = licenseList.stream().distinct().collect(Collectors.joining(","));
        System.out.println(collect);
    }

    private static void testTemp() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<Date, String> financeRoundList = new HashMap<>();
        financeRoundList.put(format.parse("2022-01-01"), "B");
        financeRoundList.put(format.parse("2021-01-01"), "A");
        financeRoundList.put(new Date(), "C");

        Object[] dateKeys = financeRoundList.keySet().toArray();
        Arrays.sort(dateKeys);
        String round = financeRoundList.get(dateKeys[dateKeys.length - 1]);
        System.out.println(round);
    }

    private static void testSort() {
        List<Test1> test1s = new ArrayList<>();
        test1s.add(new Test1(1, "A"));
        test1s.add(new Test1(3, "C"));
        test1s.add(new Test1(2, "B"));
        Collections.sort(test1s, (o1, o2) -> o1.getKey() - o2.getKey());
        System.out.println(JSON.toJSONString(test1s));
        // 为空测试
        List<Test1> test2s = new ArrayList<>();
        Collections.sort(test2s, (o1, o2) -> o1.getKey() - o2.getKey());
        System.out.println(JSON.toJSONString(test2s));
    }

    private static void testCollection() {
        List emptyList = Collections.emptyList();
        System.out.println(emptyList);
        System.out.println(emptyList.stream().distinct().collect(Collectors.joining("|")));
    }

    public static void main(String[] args) throws ParseException {
        //testTemp();
        //testSort();
        //System.out.println(new ArrayList<>());
        //testJoining();
        testCollection();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Test1 {
        private Integer key;
        private String value;
    }

}
