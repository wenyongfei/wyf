package com.wyf.hello.utils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期处理组件用以下开源的工具包
 * 1、org.apache.commons.lang3.time.DateFormatUtils 工具类
 * 2、org.apache.commons.lang3.time.DateUtils 工具类
 */
public class DateHelper {

    public static final String DATE_PATTERN_I = "yyyy-MM-dd";

    public static final String DATE_PATTERN_II = "yyyy-MM-dd HH:mm";

    public static final String DATE_PATTERN_III = "yyyy-MM-dd HH:mm:ss";


    public static String getCurrentTime(){
        return  DateFormatUtils.format(getCurrentDate(), DATE_PATTERN_III);
    }
    /**
     * 获取当前日期
     *
     * @return
     */
    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }


    public static String formatUTC(Date date, String pattern) {
        return   DateFormatUtils.formatUTC(date, pattern);
    }

    public static Date parseDate(String str, String parsePattern) throws ParseException {
        return DateUtils.parseDate(str, parsePattern);
    }


    public static long getFragmentInSeconds(Date date, int fragment) {
        return DateUtils.getFragmentInSeconds(date, fragment);
    }


    /**
     * <p>
     * 获取本月第一天日期（格式如YYYYMMDD）,如果当前日为当月1日,则返回上月第一日
     * </p>
     *
     * @return
     */
    public static String getMonthFirstDay() {
        Calendar calendar = new GregorianCalendar();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = 0;
        if (day == 1)// 当月第一日
        {
            calendar.add(Calendar.MONTH, -1);
        }
        month = calendar.get(Calendar.MONTH);
        if (month < 10) {
            return "" + calendar.get(Calendar.YEAR) + "0" + (month + 1) + "01";
        } else {
            return "" + calendar.get(Calendar.YEAR) + (month + 1) + "01";
        }
    }


    /**
     * 判断一个日期字符串是否合法
     *
     * @param date
     * @param format
     * @return
     *
     */
    public static boolean isDateStringCorrect(String date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * <P>
     * 将字符串类型的日期格式 转换为 符合要求的日期格式
     * </P>
     *
     * @param date
     * @param format
     * @return
     */
    public static String getStrDate4String(String date, String format) {
        if (date == null || date.trim().equals("")) {
            return "";
        } else {
            SimpleDateFormat df = new SimpleDateFormat(format);
            try {
                Date d = df.parse(date);
                return df.format(d);
            } catch (ParseException e) {
                System.out.println(e);
                return "";
            }
        }
    }

    /**
     *
     * <P>
     * 将Date类型的日期格式 转换为 符合要求的 String日期格式
     * </P>
     *
     * @param date
     * @param format
     * @return
     */
    public static String getStrDate4Date(Date date, String format) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        }
    }

    /**
     *
     * <P>
     * 将字符串类型的日期格式 转换为 符合要求的 Date类型的日期格式
     * </P>
     *
     * @param date
     * @param format
     * @return
     */
    public static Date getDate4StrDate(String date, String format) {
        if (date == null || date.trim().equals("")) {
            return null;
        } else {
            SimpleDateFormat df = new SimpleDateFormat(format);
            try {
                return df.parse(date);
            } catch (ParseException e) {
                return null;
            }
        }
    }


    /**
     * <p>比较两个日期的大小,精确到秒</p>
     *
     * @param d1
     * @param d2
     * @return 返回一个long类型的整数，若大于0表示第一个日期晚于第二个日期，小于0表示第一个日期早于第二个日期，否则相等
     */
    public static long compareEachOther(Date d1, Date d2){
        if(d1 == null || d2 == null)
            return -1;
        String d1Str = d1.getTime() + "";
        String d2Str = d2.getTime() + "";
        int l1 = d1Str.length();
        int l2 = d2Str.length();
        d1Str = d1Str.substring(0, l1 - 3) + "000";
        d2Str = d2Str.substring(0, l2 - 3) + "000";
        long long1 = Long.parseLong(d1Str);
        long long2 = Long.parseLong(d2Str);
        return long1 - long2;
    }
}
