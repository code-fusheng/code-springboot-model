package xyz.fusheng.code.springboot.model.learn.θε;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: Test
 * @Author: code-fusheng
 * @Date: 2022/1/7 5:16 δΈε
 * @Version: 1.0
 * @Description:
 */

public class Test {

    public static void main(String[] args) {
        List<JSONObject> users = new ArrayList<>();
        JSONObject object = new JSONObject() {{
            put("xx", "xxx");
        }};
        users.add(object);
        List<JSONObject> users1 = subList(users);
        System.out.println(users1);
    }

    private static <T> List<T> subList(List<T> list) {
        return list;
    }

}
