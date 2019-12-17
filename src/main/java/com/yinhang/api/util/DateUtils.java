package com.yinhang.api.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    public static String formatDate(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
    /**
     * 返回当前时间的是当天的第几秒
     * @param time LocalDateTime
     * @return int
     */
    public static int getDaySecond(LocalDateTime time) {
        if (null == time) {
            return 0;
        }
        return time.getHour() * 3600 + time.getMinute() * 60 + time.getSecond();
    }

    /**
     * 获取当前是一周中的第几天
     * 1->周一 ... 7->周日
     * @param time LocalDateTime
     * @return int
     */
    public static int getDayOfWeek(LocalDateTime time) {
        if (null == time) {
            return 0;
        }
        return time.getDayOfWeek().getValue();
    }


    public static LocalDateTime DateToLocalDateTime(Date date){
        if (date == null){
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }



}
