package com.tydic.base.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

public class DateUtils {

    public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";

    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATETIME_DEFAULT_FORMAT_SMALL = "yyyy-MM-dd HH:mm:ss:SSS";

    public static final String TIME_DEFAULT_FORMAT = "HH:mm:ss";

    private static DateFormat dateFormat = null;

    private static DateFormat dateTimeFormat = null;

    private static DateFormat timeFormat = null;

    // private static Calendar gregorianCalendar = null;

    static {
        dateFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
        dateTimeFormat = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
        timeFormat = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
        // gregorianCalendar = new GregorianCalendar();
    }

    /**
     * 日期格式化yyyy-MM-dd
     * 
     * @param date
     * @return
     */
    public static Date formatDate(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期格式化yyyy-MM-dd
     * 
     * @param date
     * @return
     */
    public static String getDateFormat(Date date) {
        return dateFormat.format(date);
    }

    /**
     * 日期格式化yyyy-MM-dd HH:mm:ss
     * 
     * @param date
     * @return
     */
    public static String getDateTimeFormat(Date date) {
        return dateTimeFormat.format(date);
    }

    /**
     * 时间格式化
     * 
     * @param date
     * @return HH:mm:ss
     */
    public static String getTimeFormat(Date date) {
        return timeFormat.format(date);
    }

    /**
     * 日期格式化
     * 
     * @param date
     * @param 格式类型
     * @return
     */
    public static String getDateFormat(Date date, String formatStr) {
        if (!StringUtils.isEmpty(formatStr)) {
            return new SimpleDateFormat(formatStr).format(date);
        }
        return null;
    }

    /**
     * 日期格式化
     * 
     * @param date
     * @return
     */
    public static Date getDateFormat(String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 时间格式化
     * 
     * @param date
     * @return
     */
    public static Date getDateTimeFormat(String date) {
        try {
            return dateTimeFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前日期(yyyy-MM-dd)
     * 
     * @param date
     * @return
     */
    public static Date getNowDate() {
        return DateUtils.getDateFormat(dateFormat.format(new Date()));
    }

    /**
     * 获取当前日期(yyyy-MM-dd HH:mm:ss)
     * 
     * @param date
     * @return
     */
    public static Date getNowDateTime() {
        return DateUtils.getDateTimeFormat(dateTimeFormat.format(new Date()));
    }

    /**
     * 
     * @param date
     * @return
     */
    public static String getDateFormatOther(Date date, String formatOther) {
        DateFormat dateFormatOther = new SimpleDateFormat(formatOther);
        return dateFormatOther.format(date);
    }

    public static BigDecimal getHourBetwen(String startDateStr, String endDateStr, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        long startTime = 0;
        long endTime = 0;
        try {
            startTime = simpleDateFormat.parse(startDateStr).getTime();
            endTime = simpleDateFormat.parse(endDateStr).getTime();
        } catch (ParseException e) {
             e.printStackTrace();
        }
        BigDecimal b3 = new BigDecimal(Double.toString(startTime));
        BigDecimal b4 = new BigDecimal(Double.toString(endTime));
        return (b4.subtract(b3)).divide(new BigDecimal("3600000"), 8, BigDecimal.ROUND_HALF_UP);
    }
    
    public static String getFirstDayOfCurentMounth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return dateFormat.format(calendar.getTime());
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.getDateFormat(new Date()));
    }

}
