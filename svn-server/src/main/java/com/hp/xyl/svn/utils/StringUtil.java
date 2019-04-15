package com.hp.xyl.svn.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Author:xyl
 * Date:2018/12/21 15:15
 * Description: 字符串工具类
 */
public class StringUtil {
    private StringUtil() {
    }

    /**
     * 判断字符串是否为空
     *
     * @param str 需要判断的字符串
     * @return 返回判断结果，true为空，反之不为空
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    /**
     * 将指定字符串首字母转换成大写字母
     *
     * @param str 指定字符串
     * @return 返回首字母大写的字符串
     */
    public static String firstCharUpperCase(String str) {
        StringBuilder buffer = new StringBuilder(str);
        if (buffer.length() > 0) {
            char c = buffer.charAt(0);
            buffer.setCharAt(0, Character.toUpperCase(c));
        }
        return buffer.toString();
    }

    /**
     * 拆分字符串
     *
     * @param str   待拆分的字符串
     * @param regex 拆分的规则
     * @return 拆分后的字符串
     */
    public static String[] split(String str, String regex) {
        return (isEmpty(str) || isEmpty(regex)) ? null : str.split(regex);
    }

    /**
     * 将指定对象转换成字符串
     *
     * @param obj 指定对象
     * @return 转换后的字符串
     */
    public static String toString(Object obj) {
        StringBuffer buffer = new StringBuffer();
        if (obj != null) {
            buffer.append(obj);
        }
        return buffer.toString();
    }

    /**
     * 校验字符串
     *
     * @param str   需要校验的字符串
     * @param regex 正则表达式
     * @return 校验结果
     */
    public static boolean checkString(String str, String regex) {
        if (isEmpty(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }

    /**
     * 关键字查询
     *
     * @param str 关键字
     * @return 条件
     */
    public static String sqlLike(String str) {
        if (!isEmpty(str)) {
            str = str.replace("%", "\\%");
            return "%" + str + "%";
        }
        return "%";
    }

    /**
     * 字符转换Long
     *
     * @param obj
     * @return
     */
    public static Long transferLong(String obj) {
        if (isEmpty(obj)) {
            return 0L;
        }
        return Long.parseLong(obj);
    }

    /**
     * BigInteger转Long
     */
    public static List<Long> big2Long(List<BigInteger> ids) {
        List<Long> newIds = new ArrayList<>();
        for (BigInteger id : ids) {
            newIds.add(id.longValue());
        }
        return newIds;
    }

    public static String join(String split, String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(split).append(string);
        }
        return stringBuilder.toString();
    }

}
