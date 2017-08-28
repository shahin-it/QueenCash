package com.queen_cash.util;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class AppUtil {
    public static Date getCurrentDateTime() {
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Dhaka");
        Calendar calendar = Calendar.getInstance(timeZone);
        return calendar.getTime();
    }
}
