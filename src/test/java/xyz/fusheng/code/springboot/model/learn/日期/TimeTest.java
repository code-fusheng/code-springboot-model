package xyz.fusheng.code.springboot.model.learn.日期;

import cn.hutool.core.date.DateTime;
import com.alibaba.druid.sql.visitor.functions.Lcase;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.Getter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc TimeTest
 * @date 2023-04-14 14:33:21
 */

public class TimeTest {

    public static void main(String[] args) {
        long time = DateTime.now().getTime();
        System.out.println(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String format = sdf.format(new Date(Long.parseLong(String.valueOf(time))));
        System.out.println(format);
        Test test = new Test();
        test.setEventTime(Timestamp.valueOf(format));
        System.out.println(test);

        double time_v2 = 1681465048.744336;
        double time_v3 = Double.parseDouble("1.681873094982E9");
        String format1 = sdf.format(new Date((long) (time_v3 * 1000L)));
        System.out.println(format1);
        // String[] split = time_v2.split(".");
        // Instant instant = Instant.ofEpochSecond(Long.parseLong(split[0]), Long.parseLong(split[1]) * 1000);
        // LocalDateTime localTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        // System.out.println(localTime);

    }

}

@Data
@Getter
class Test {
    private Timestamp eventTime;
}

