package com.yizhu.java8.localdate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * LocalDate使用方法实践
 *
 * @date 2020/1/3
 */
public class LocalDatePractice {

    public static void main(String[] args) {
        final LocalDateTime now = LocalDateTime.now();

        now();

        plus(now);

        minus(now);

        Date nowDate = transferToDate(now);

        LocalDateTime nowDateTime = transferToLocalDateTime(new Date());

        format(now);

        string();

        compare();

        others(now);
    }

    /**
     * 比较
     */
    private static void compare() {
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime oneDayAfter = now.plusDays(1);

        System.out.println(now+"在"+oneDayAfter+"之前吗：" + now.isBefore(oneDayAfter));
        System.out.println(oneDayAfter+"在"+now+"之后吗：" + oneDayAfter.isAfter(now));
        System.out.println(now+"和"+now+"相等吗：" + now.equals(now));
    }

    /**
     * string相关
     */
    private static void string() {
        System.out.println("2020-01-03 20:30:00转换为LocalDateTime：" + LocalDateTime.parse("2020-01-03T20:30:00"));

        System.out.println("2020-01-03转换为LocalDate：" + LocalDate.parse("2020-01-03"));

        System.out.println("20:30:00转换为LocalTime：" + LocalTime.parse("20:30:00"));
    }

    /**
     * 获取当前时间或日期
     */
    private static void now() {
        System.out.println("当前时间：" + LocalDateTime.now());
        System.out.println("当前时间：" + LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));

        System.out.println("当前日期：" + LocalDate.now());

        System.out.println("当前时分秒：" + LocalTime.now());
        System.out.println("当前时分秒：" + LocalTime.now(Clock.systemDefaultZone()));

        System.out.println("今年是这个纪元第几年：" + LocalDateTime.now().get(ChronoField.YEAR_OF_ERA));
        System.out.println("今天是今年第几天：" + LocalDateTime.now().get(ChronoField.DAY_OF_YEAR));
        System.out.println("今天是今年第几天：" + LocalDateTime.now().getDayOfYear());
        System.out.println("今天是这个月第几天：" + LocalDateTime.now().get(ChronoField.DAY_OF_MONTH));
        System.out.println("今天是这个月第几天：" + LocalDateTime.now().getDayOfMonth());
        System.out.println("今天是这周第几天：" + LocalDateTime.now().get(ChronoField.DAY_OF_WEEK));
        System.out.println("今天是这周第几天：" + LocalDateTime.now().getDayOfWeek());
        System.out.println("获取月份：" + LocalDateTime.now().getMonth());
        System.out.println("获取月份：" + LocalDateTime.now().getMonthValue());
        System.out.println("获取小时：" + LocalDateTime.now().getHour());
        System.out.println("获取分钟：" + LocalDateTime.now().getMinute());
        System.out.println("获取秒：" + LocalDateTime.now().getSecond());
        System.out.println("获取纳秒：" + LocalDateTime.now().getNano());

    }

    /**
     * 格式化日期
     * @param now
     */
    private static void format(LocalDateTime now) {
        System.out.println("当前日期按yyyy-MM-dd HH:mm:ss格式输出：" + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    private static void others(LocalDateTime now) {
        final Instant start = Instant.now();
        System.out.println("今天开始时刻：" + now.toLocalDate().atStartOfDay(ZoneId.systemDefault()));
        System.out.println("今天开始时刻：" + now.toLocalDate().atStartOfDay());
        System.out.println("今天结束时刻：" + now.toLocalDate().atTime(23, 59, 59, 999999999));

        System.out.println("当前时间整点：" + LocalTime.of(LocalTime.now().getHour(), 0, 0));

        System.out.println("今年是否为闰年：" + LocalDate.now().isLeapYear());

        System.out.println("others方法消耗的时间：" + Duration.between(start, Instant.now()).getNano() + "ms");

    }

    /**
     * Date转为LocalDateTime
     * @param date
     * @return
     */
    private static LocalDateTime transferToLocalDateTime(Date date){
        final ZoneId zoneId = ZoneId.systemDefault();
        return date.toInstant().atZone(zoneId).toLocalDateTime();
    }

    /**
     * LocalDateTime转换为Date
     * @param now
     * @return
     */
    private static Date transferToDate(LocalDateTime now) {
        // 获取时区id
        final ZoneId zoneId = ZoneId.systemDefault();
        // 获取时区所对应的时间
        final ZonedDateTime zonedDateTime = now.atZone(zoneId);
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 加法操作
     * @param now
     */
    private static void plus(LocalDateTime now) {
        System.out.println("当前时间：" + now);
        System.out.println("当前时间加一年：" + now.plus(1, ChronoUnit.YEARS));
        System.out.println("当前时间加一年：" + now.plusYears(1));
        System.out.println("当前时间加一个月：" + now.plusMonths(1));
        System.out.println("当前时间加一周：" + now.plusWeeks(1));
        System.out.println("当前时间加一天：" + now.plus(Duration.ofDays(1)));
        System.out.println("当前时间加一天：" + now.plusDays(1));
        System.out.println("当前时间加一小时：" + now.plusHours(1));
        System.out.println("当前时间加一分钟：" + now.plusMinutes(1));
        System.out.println("当前时间加一秒钟：" + now.plusSeconds(1));
        System.out.println("当前时间加一纳秒：" + now.plusNanos(1));
    }

    /**
     * 减法操作
     * @param now
     */
    private static void minus(LocalDateTime now) {
        System.out.println("当前时间：" + now);
        System.out.println("当前时间减一年：" + now.minus(1, ChronoUnit.YEARS));
        System.out.println("当前时间减一年：" + now.minusYears(1));
        System.out.println("当前时间减一个月：" + now.minusMonths(1));
        System.out.println("当前时间减一周：" + now.minusWeeks(1));
        System.out.println("当前时间减一天：" + now.minusDays(1));
        System.out.println("当前时间减一天：" + now.minus(Duration.ofDays(1)));
        System.out.println("当前时间减一小时：" + now.minusHours(1));
        System.out.println("当前时间减一分钟：" + now.minusMinutes(1));
        System.out.println("当前时间减一秒钟：" + now.minusSeconds(1));
        System.out.println("当前时间减一纳秒：" + now.minusNanos(1));
    }

}
