package com.queen_cash.util;

import java.util.HashMap;
import java.util.Map;

public class WebUtil {
    public static Map responseMap(String message) {
        Map resp = new HashMap();
        resp.put("status", "success");
        resp.put("message", message);
        return resp;
    }
}
