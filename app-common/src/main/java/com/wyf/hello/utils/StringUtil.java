package com.wyf.hello.utils;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private static Pattern linePattern = Pattern.compile("_(\\w)");
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    public static final Iterable<String> split(String input){
        Iterable<String> result =  Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split(input);

        return  result;
    }

    public static boolean isAnyBlank(String... strs) {
        return  StringUtils.isAnyBlank(strs);
    }

    public static boolean isBlank(String s) {
        return  StringUtils.isBlank(s);
    }

    public static boolean isEmpty(String... strs) {
        return StringUtils.isAnyEmpty(strs);
    }
    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    /**
     * 下划线转驼峰
     * @param str
     * @return
     */
    public static String lineToHump(String str) {
        if (null == str || "".equals(str)) {
            return str;
        }
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);

        str = sb.toString();
        str = str.substring(0, 1).toUpperCase() + str.substring(1);

        return str;
    }
}
