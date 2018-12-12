package com.example.peach.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Administrator on 2018/11/25.
 */

public class DateUtil {

    /**
     *  
     *   将时间字符串转换为Date类型 
     *   @param dateStr 
     *  @return Date 
     *      
     */
    public static Date toDate(String dateStr) {
        Date date = null;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern("yyyy-MM-dd");
        try {
            date = formater.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     *  
     * 按照提供的格式将字符串转换成Date类型 
     *  @param dateStr 
     *  @param formaterString 
     *  @return 
     *      
     */
    public static Date toDate(String dateStr, String formaterString) {
        Date date = null;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern(formaterString);
        try {
            date = formater.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     *  
     *  将Date类型时间转换为字符串 
     *  @param date 
     *  @return 
     *      
     */
    public static String toString(Date date) {

        String time;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern("yyyy-MM-dd");
        time = formater.format(date);
        return time;
    }

    /**
     *  
     *  按照参数提供的格式将Date类型时间转换为字符串 
     *  @param date 
     *  @param formaterString 
     *  @return 
     *      
     */
    public static String toString(Date date, String formaterString) {
        String time;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern(formaterString);
        time = formater.format(date);
        return time;
    }

    /**
     *  
     *  method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp） 
     *  @param dateString 
     *  需要转换为timestamp的字符串 
     *  @return dataTime timestamp 
     *      
     */
    public final static java.sql.Timestamp string2Time(String dateString)
            throws java.text.ParseException {
        DateFormat dateFormat;
//      dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS",  
//              Locale.ENGLISH);// 设定格式  
        dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm");
        dateFormat.setLenient(false);
        java.util.Date timeDate = dateFormat.parse(dateString);// util类型  
        java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型  
        return dateTime;
    }

    /**
     *  
     *  method 将字符串类型的日期按照转换为一个timestamp（时间戳记java.sql.Timestamp）   
     *  @param dateString 需要转换为timestamp的字符串 
     *  @param formaterString dateString字符串的解析格式 
     *  @return 
     *  @throws java.text.ParseException      
     */
    public final static java.sql.Timestamp string2Time(String dateString,
                                                       String formaterString) throws java.text.ParseException {
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat(formaterString);// 设定格式  
// dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");  
        dateFormat.setLenient(false);
        java.util.Date timeDate = dateFormat.parse(dateString);// util类型  
        java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型  
        return dateTime;
    }

    public static void main(String[] args) throws ParseException {
        String t = DateUtil.toString(new Date());
        System.out.println(t);
        Date date = DateUtil.toDate("2010-06-17");
        System.out.println(date);

//      String sToTimestamp = "2005-8-18 14:21:12.123";// 用于转换成java.sql.Timestamp的字符串  
        String sToTimestamp = "2005-8-18 14:21";// 用于转换成java.sql.Timestamp的字符串  
        Timestamp Timestamp = string2Time(sToTimestamp);
        System.out.println(Timestamp);

    }


}
