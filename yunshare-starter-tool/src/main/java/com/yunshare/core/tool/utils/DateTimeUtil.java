
package com.yunshare.core.tool.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @description: DateTime 工具类
 * @author: lzx@yuyuda.com
 * @date: 2022/3/30 14:30
 */
public class DateTimeUtil {
    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATETIME);
    public static final DateTimeFormatter DATETIME_UTC_FORMAT = DateTimeFormatter.ofPattern(DateUtil.PATTERN_UTC_DATETIME);
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATE);
    public static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern(DateUtil.PATTERN_TIME);
    public static final DateTimeFormatter CUSTOM_DATE_FORMAT;
    public static final DateTimeFormatter CUSTOM_DATE_FORMAT_SLASH;
    public static final DateTimeFormatter MULTIPLE_FORMAT;

    static {
        //自定义日期
        CUSTOM_DATE_FORMAT = new DateTimeFormatterBuilder()
                .appendPattern(DateUtil.PATTERN_CUSTOM_DATE)
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .parseDefaulting(ChronoField.MILLI_OF_SECOND, 0)
                .toFormatter();
        //自定义日期
        CUSTOM_DATE_FORMAT_SLASH = new DateTimeFormatterBuilder()
                .appendPattern(DateUtil.PATTERN_CUSTOM_DATE_SLASH)
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .parseDefaulting(ChronoField.MILLI_OF_SECOND, 0)
                .toFormatter();

        //多元日期格式化
        MULTIPLE_FORMAT = new DateTimeFormatterBuilder()
                .appendOptional(DATETIME_UTC_FORMAT)
                .appendOptional(DATETIME_FORMAT)
                .appendOptional(CUSTOM_DATE_FORMAT)
                .appendOptional(CUSTOM_DATE_FORMAT_SLASH)
                .toFormatter();

    }


    /**
     * 日期时间格式化
     *
     * @param temporal 时间
     * @return 格式化后的时间
     */
    public static String formatDateTime(TemporalAccessor temporal) {
        return DATETIME_FORMAT.format(temporal);
    }

    /**
     * 日期时间格式化
     *
     * @param temporal 时间
     * @return 格式化后的时间
     */
    public static String formatDate(TemporalAccessor temporal) {
        return DATE_FORMAT.format(temporal);
    }

    /**
     * 时间格式化
     *
     * @param temporal 时间
     * @return 格式化后的时间
     */
    public static String formatTime(TemporalAccessor temporal) {
        return TIME_FORMAT.format(temporal);
    }

    /**
     * 日期格式化
     *
     * @param temporal 时间
     * @param pattern  表达式
     * @return 格式化后的时间
     */
    public static String format(TemporalAccessor temporal, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(temporal);
    }

    /**
     * 将字符串转换为时间
     *
     * @param dateStr 时间字符串
     * @param pattern 表达式
     * @return 时间
     */
    public static LocalDateTime parseDateTime(String dateStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return DateTimeUtil.parseDateTime(dateStr, formatter);
    }

    /**
     * 将字符串转换为时间
     *
     * @param dateStr   时间字符串
     * @param formatter DateTimeFormatter
     * @return 时间
     */
    public static LocalDateTime parseDateTime(String dateStr, DateTimeFormatter formatter) {
        return LocalDateTime.parse(dateStr, formatter);
    }

    /**
     * 将字符串转换为时间
     *
     * @param dateStr 时间字符串
     * @return 时间
     */
    public static LocalDateTime parseDateTime(String dateStr) {
        return DateTimeUtil.parseDateTime(dateStr, DateTimeUtil.DATETIME_FORMAT);
    }

    /**
     * 将字符串转换为时间
     *
     * @param dateStr 时间字符串
     * @param pattern 表达式
     * @return 时间
     */
    public static LocalDate parseDate(String dateStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return DateTimeUtil.parseDate(dateStr, formatter);
    }

    /**
     * 将字符串转换为时间
     *
     * @param dateStr   时间字符串
     * @param formatter DateTimeFormatter
     * @return 时间
     */
    public static LocalDate parseDate(String dateStr, DateTimeFormatter formatter) {
        return LocalDate.parse(dateStr, formatter);
    }

    /**
     * 将字符串转换为日期
     *
     * @param dateStr 时间字符串
     * @return 时间
     */
    public static LocalDate parseDate(String dateStr) {
        return DateTimeUtil.parseDate(dateStr, DateTimeUtil.DATE_FORMAT);
    }

    /**
     * 将字符串转换为时间
     *
     * @param dateStr 时间字符串
     * @param pattern 时间正则
     * @return 时间
     */
    public static LocalTime parseTime(String dateStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return DateTimeUtil.parseTime(dateStr, formatter);
    }

    /**
     * 将字符串转换为时间
     *
     * @param dateStr   时间字符串
     * @param formatter DateTimeFormatter
     * @return 时间
     */
    public static LocalTime parseTime(String dateStr, DateTimeFormatter formatter) {
        return LocalTime.parse(dateStr, formatter);
    }

    /**
     * 将字符串转换为时间
     *
     * @param dateStr 时间字符串
     * @return 时间
     */
    public static LocalTime parseTime(String dateStr) {
        return DateTimeUtil.parseTime(dateStr, DateTimeUtil.TIME_FORMAT);
    }

    /**
     * 时间转 Instant
     *
     * @param dateTime 时间
     * @return Instant
     */
    public static Instant toInstant(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant();
    }

    /**
     * Instant 转 时间
     *
     * @param instant Instant
     * @return Instant
     */
    public static LocalDateTime toDateTime(Instant instant) {
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * 转换成 date
     *
     * @param dateTime LocalDateTime
     * @return Date
     */
    public static Date toDate(LocalDateTime dateTime) {
        return Date.from(DateTimeUtil.toInstant(dateTime));
    }

    /**
     * 比较2个时间差，跨度比较小
     *
     * @param startInclusive 开始时间
     * @param endExclusive   结束时间
     * @return 时间间隔
     */
    public static Duration between(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive);
    }

    /**
     * 比较2个时间差，跨度比较大，年月日为单位
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 时间间隔
     */
    public static Period between(LocalDate startDate, LocalDate endDate) {
        return Period.between(startDate, endDate);
    }
}
