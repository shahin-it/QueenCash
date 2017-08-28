package com.queen_cash.util;

public class StringUtil {
    public static String toUnderScoreCase(String source) {
        if(source == null) {
            return null;
        }
        String regex = "([a-z])([A-Z]+)", replacement = "$1_$2";
        return source.replaceAll(regex, replacement).toLowerCase();
    }
}
