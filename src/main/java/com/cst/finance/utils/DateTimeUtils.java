package com.cst.finance.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {

    public static String getDateNow1(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String DateTimeNow=df.format(new Date());// new Date()为获取当前系统时间
        return DateTimeNow;
    }

    public static String getDateNow(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String DateTimeNow=df.format(new Date());// new Date()为获取当前系统时间
        return DateTimeNow;
    }

    public static String getDateTimeNow(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String DateTimeNow=df.format(new Date());// new Date()为获取当前系统时间
        return DateTimeNow;
    }

    public static Date addDateMinut(Date date, int hour){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("front:" + format.format(date)); //显示输入的日期
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        date = cal.getTime();
        System.out.println("after:" + format.format(date));  //显示更新后的日期
        cal = null;
        return date;
    }
}
