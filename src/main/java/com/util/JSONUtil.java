package com.util;

import com.google.gson.Gson;

/**
 * Created by yingmeng on 2017/7/9 0009.
 */
public class JSONUtil {
    static Gson gson = new Gson();

    public static String toJson(Object object){
        return gson.toJson(object);
    }


}
