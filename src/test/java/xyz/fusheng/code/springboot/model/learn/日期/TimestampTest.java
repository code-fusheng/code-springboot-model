package xyz.fusheng.code.springboot.model.learn.日期;

import com.alibaba.fastjson.JSONObject;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc TimestampTest
 * @date 2023-07-12 5:27 PM:40
 */

public class TimestampTest {

    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        jsonObject.put("timestamp", timestamp);
        Timestamp timestamp1 = jsonObject.getTimestamp("timestamp");
        System.out.println(Objects.equals(timestamp, timestamp1));

    }

}

