package com.queen_cash.util;

import com.queen_cash.models.admin.Administrator;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class AppUtil {
    public static Date currentDateTime() {
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Dhaka");
        Calendar calendar = Calendar.getInstance(timeZone);
        return calendar.getTime();
    }

    public static Administrator loggedAdministrator() {
        return null;
    }
}
