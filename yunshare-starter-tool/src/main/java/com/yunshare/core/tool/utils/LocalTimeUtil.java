package com.yunshare.core.tool.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * LocalTime时间工具类
 *
 * @author lzx@yuyuda.com
 * @version 1.0
 * @since 2021/5/21 下午2:54
 **/
public class LocalTimeUtil {
    /**
     * localDateTime格式
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * localDate格式
     */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * yyyy-MM格式
     */
    private static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");

    /**
     * LocalDate转LocalDateTime
     *
     * @param localDate localDate
     * @return java.time.LocalDateTime
     * @author lzx
     * @since 2021/5/21 下午3:02
     */
    public static LocalDateTime localDateToLocalDateTime(LocalDate localDate) {
        return localDate.atStartOfDay();
    }

    /**
     * LocalDate转成字符串
     *
     * @param localDate localDate
     * @return java.lang.String
     * @author lzx
     * @since 2021/5/21 下午3:38
     */
    public static String localDateToStr(LocalDate localDate) {
        return DATE_FORMATTER.format(localDate);
    }

    /**
     * <p>返回格式化的时间</p>
     *
     * @param localDateTime localDateTime
     * @param format        格式
     * @return java.lang.String
     * @author lzx@yuyuda.com
     * @since 2021/9/15 上午11:52
     */
    public static String localDateTimeFormat(LocalDateTime localDateTime, String format) {
        return DateTimeFormatter.ofPattern(format).format(localDateTime);
    }

    /**
     * <p>localDate返回格式化时间</p>
     *
     * @param localDate localDate
     * @param format    format
     * @return java.lang.String
     * @author lzx@yuyuda.com
     * @since 2021/12/17 下午3:04
     */
    public static String localDateFormat(LocalDate localDate, String format) {
        return DateTimeFormatter.ofPattern(format).format(localDate);
    }

    /**
     * 字符串日期转localDate
     *
     * @param localDate localDate
     * @return java.time.LocalDate
     * @author lzx
     * @since 2021/7/22 上午11:59
     */
    public static LocalDate localDateStrToLocalDate(String localDate) {
        return LocalDate.parse(localDate, DATE_FORMATTER);
    }

    /**
     * <p>字符串年月日时分钞转LocalDateTime</p>
     *
     * @param localDateTime localDateTime
     * @return java.time.LocalDateTime
     * @author lzx@yuyuda.com
     * @since 2021/12/17 下午5:08
     */
    public static LocalDateTime localDateTimeStrToLocalDateTime(String localDateTime) {
        return LocalDateTime.parse(localDateTime, DATE_TIME_FORMATTER);
    }

    /**
     * LocalDateTime转成字符串2021-05-21
     *
     * @param localDateTime localDateTime
     * @return java.lang.String
     * @author lzx
     * @since 2021/5/21 下午3:39
     */
    public static String localDateTimeToStr(LocalDateTime localDateTime) {
        return DATE_FORMATTER.format(localDateTime);
    }

    /**
     * LocalDateTime转成字符串2021-05-21 00:00:00
     *
     * @param localDateTime localDateTime
     * @return java.lang.String
     * @author lzx
     * @since 2021/5/21 下午3:47
     */
    public static String localDateTimeToTimeStr(LocalDateTime localDateTime) {
        return DATE_TIME_FORMATTER.format(localDateTime);
    }

    /**
     * LocalDateTime转成字符串2021-05
     *
     * @param localDateTime localDateTime
     * @return java.lang.String
     * @author lzx
     * @since 2021/5/26 下午5:08
     */
    public static String localDateTimeToMonthStr(LocalDateTime localDateTime) {
        return MONTH_FORMATTER.format(localDateTime);
    }

    /**
     * 字符串年月转成YearMonth
     *
     * @param yearMonth 字符串年月
     * @return java.time.YearMonth
     * @author lzx
     * @since 2021/7/22 下午3:46
     */
    public static YearMonth yearMonthStrToYearMonth(String yearMonth) {
        return YearMonth.parse(yearMonth, MONTH_FORMATTER);
    }

    /**
     * 求两个日期间的天数
     *
     * @param end   结束时间
     * @param start 开始时间
     * @return int
     * @author lzx
     * @since 2021/5/26 下午4:47
     */
    public static int diffDays(LocalDateTime end, LocalDateTime start) {
        return (int) (end.toLocalDate().toEpochDay() - start.toLocalDate().toEpochDay());
    }

    /**
     * 将LocalDateTime转成时间戳
     *
     * @param localDateTime LocalDateTime
     * @return long
     * @author lzx
     * @since 2021/6/21 上午10:43
     */
    public static long timestamp(LocalDateTime localDateTime) {
        return localDateTime.toEpochSecond(ZoneOffset.of("+8"));
    }

    /**
     * 获取上个月的第一天或最后一天
     *
     * @param localDate localDate
     * @param isStart   true-第一天，false-最后一天
     * @return java.time.LocalDate
     * @author lzx@yuyuda.com
     * @since 2021/8/21 上午9:43
     */
    public static LocalDate prevMonthDay(LocalDate localDate, boolean isStart) {
        LocalDate day;
        if (localDate.getMonthValue() == IntPool.ONE) {
            LocalDate prevMonth = LocalDate.of(localDate.getYear() - 1, 12, 1);
            day = isStart
                    ? prevMonth.with(TemporalAdjusters.firstDayOfMonth())
                    : prevMonth.with(TemporalAdjusters.lastDayOfMonth());
        } else {
            LocalDate prevMonth = LocalDate.of(localDate.getYear(), localDate.getMonthValue() - 1, 1);
            day = isStart
                    ? prevMonth.with(TemporalAdjusters.firstDayOfMonth())
                    : prevMonth.with(TemporalAdjusters.lastDayOfMonth());
        }
        return day;
    }

    /**
     * 获取两个日期相隔多少月的最后一天
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return java.util.List<java.time.LocalDate>
     * @author lzx@yuyuda.com
     * @since 2021/8/22 上午12:11
     */
    public static List<LocalDate> diffLastDay(LocalDate start, LocalDate end) {
        List<LocalDate> list = new LinkedList<>();
        long distance = ChronoUnit.MONTHS.between(start, end);
        Stream.iterate(start, d -> d.plusMonths(1))
                .limit(distance + 1)
                .forEach(f -> list.add(f.with(TemporalAdjusters.lastDayOfMonth())));
        return list;
    }

    /**
     * <p>将LocalDate转变为月份字符串</p>
     *
     * @param localDate localDate
     * @return java.lang.String
     * @author lzx@yuyuda.com
     * @since 2021/12/21 上午9:44
     */
    public static String localDateToMonthStr(LocalDate localDate) {
        return MONTH_FORMATTER.format(localDate);
    }

    /**
     * <p>获取两个时间间相差的月份数</p>
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return int
     * @author lzx@yuyuda.com
     * @since 2022/1/12 上午10:39
     */
    public static int diffMonth(LocalDateTime start, LocalDateTime end) {
        //获取第一个时间点的月份
        int month1 = start.getMonthValue();
        //获取第一个时间点的年份
        int year1 = start.getYear();
        //获取第一个时间点的月份
        int month2 = end.getMonthValue();
        //获取第一个时间点的年份
        int year2 = end.getYear();
        //返回两个时间点的月数差
        return (year2 - year1) * 12 + (month2 - month1);
    }

}
