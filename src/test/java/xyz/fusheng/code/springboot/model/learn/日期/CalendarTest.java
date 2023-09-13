package xyz.fusheng.code.springboot.model.learn.日期;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc CalendarTest
 * @date 2023-08-09 9:49 AM:28
 */

public class CalendarTest {

    public static void main(String[] args) {

        // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //
        // List<String> dateRange = new ArrayList<>();



        // Date startDate = new Date();
        // Date endDate = new Date();
        //
        // Calendar calendar = Calendar.getInstance();
        // calendar.setTime(startDate);
        //
        // while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
        //     String formatDate = format.format(calendar.getTime());
        //     dateRange.add(formatDate);
        //     calendar.add(Calendar.DATE, 1);
        // }
        // System.out.println(dateRange);

        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate startDate = LocalDate.parse("2023-07-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(startDate);
    }

}

