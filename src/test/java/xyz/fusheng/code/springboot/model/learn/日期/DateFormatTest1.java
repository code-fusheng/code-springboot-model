package xyz.fusheng.code.springboot.model.learn.日期;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @FileName: DateFormatTest1
 * @Author: code-fusheng
 * @Date: 2021/8/9 上午11:50
 * @Version: 1.0
 * @Description:
 * 纯数字字符串时间格式化处理 2021 07 29 14 30 20 parse()
 */

public class DateFormatTest1 {

    public static final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(() ->
            new SimpleDateFormat("yyyyMMddHHmmss"));

    public static void main(String[] args) throws ParseException {

        String timeStr = "20210729143020";

        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = f.parse(timeStr);
        System.out.println(date);

        System.out.println(new Date());

        System.out.println(f.format(new Date()));
        System.out.println(f1.format(new Date()));

        Time time = new Time(1684234534908L);
        System.out.println(f1.format(time));


        int rannum = (int) (new Random().nextDouble() * (99999 - 10000 + 1)) + 10000;
        String payNo = f.format(new Date()) + rannum;
        System.out.println(payNo);
    }

}
