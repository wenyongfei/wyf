//<editor-fold>
package com.wyf.hello.utils;

import java.sql.Timestamp;
import java.util.Date;


public class Convert {

    public static String toString(Object o) {
        if (o == null)
            return "";

        if (o instanceof String)
            return (String) o;

        return o.toString();
    }

    public static int toInt(Object o) {
        if (null == o)
            return 0;

        if (o instanceof Integer)
            return ((Integer) o).intValue();

        if (o instanceof Number)
            return ((Number) o).intValue();

        String s = o.toString().trim();

        if (s.equals(""))
            return 0;

        if (!s.contains("."))
            return parseInt(s);

        return (int) parseDouble(s);
    }

    public static long toLong(Object o) {
        if (null == o)
            return 0L;

        if (o instanceof Long)
            return ((Long) o).longValue();

        if (o instanceof Number)
            return ((Number) o).longValue();

        String s = o.toString().trim();

        if (s.equals(""))
            return 0L;

        if (!s.contains("."))
            return parseLong(s);

        return (long) parseDouble(s);
    }

    public static float toFloat(Object o) {
        if (o == null)
            return 0F;

        if (o instanceof Float)
            return ((Float) o).floatValue();

        try {
            return Float.parseFloat(o.toString());
        } catch (Exception e) {
            return 0F;
        }
    }

    private static Date minDateValue = new Date(0L);//update 2013-08-29 Fred,old code default return new Date()
    public static Date toDate(Object o) {
        if (o == null)
            return minDateValue;

        if (o instanceof Date)
            return (Date) o;

        try {
            return Timestamp.valueOf(o.toString());
        } catch (Exception e) {
            return minDateValue;
        }
    }

    public static boolean toBool(Object o) {
        if (o == null)
            return false;

        if (o instanceof Boolean)
            return ((Boolean) o).booleanValue();

        return o.toString().trim().equalsIgnoreCase("true");
    }

    private static int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }

    private static long parseLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (Exception e) {
            return 0;
        }
    }

    private static double parseDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return 0D;
        }
    }
}
    //</editor-fold>