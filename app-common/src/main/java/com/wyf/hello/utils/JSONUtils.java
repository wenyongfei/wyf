package com.wyf.hello.utils;

/**
 * json转换统一用fastJSON
 */
public class JSONUtils {

    public  static Object parseObject(String str, Class<?> className){
        return com.alibaba.fastjson.JSON.parseObject(str, className);
    }



}
