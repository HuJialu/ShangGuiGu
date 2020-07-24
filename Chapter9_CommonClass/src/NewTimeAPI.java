import org.junit.Test;

import java.time.*;

/**
 * JDK8之后 新日期API
 *
 * Calendar存在的问题
 * 1. 可变性：像日期和时间这样的类应该是不可变的
 * 2. 偏移性： Date中的年份是从1900开始的，而月份都是从0开始
 * 3. 格式化： 格式化只对Date有用，Calendar则不行
 * 4. 线程不安全
 * 5. 不能处理闰秒
 *
 * 新API java.time   (Joda-Time)
 *
 * @author Jialu Hu
 * @create 2020-07-21
 */
public class NewTimeAPI {
    /*
        LocalDate / LocalTime / LocalDateTime 的使用
        Note：
            LocalDateTime相较于另外两个类，使用频率较高
            类似于Calendar
     */
    @Test
    public void Test0(){
        //now() 获取当前日期、时间、日期+时间
        LocalDate date0 = LocalDate.now();
        LocalTime date1 = LocalTime.now();
        LocalDateTime date2 = LocalDateTime.now();

        System.out.println("date0 = " + date0);
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);

        //of() 设置指定的年、月、日、时、分、秒，无偏移量
        //实例化方法2
        LocalDateTime localDateTime1 = LocalDateTime.of(2020,7,24,8,40,0);
        System.out.println("localDateTime1 = " + localDateTime1);

        //getXxx()
        System.out.println("******** get ********");
        System.out.println("date2.getMinute() = " + date2.getMinute());
        System.out.println("date2.getMonth() = " + date2.getMonth());
        System.out.println("date2.getMonthValue() = " + date2.getMonthValue());
        System.out.println("date2.getDayOfWeek() = " + date2.getDayOfWeek());
        System.out.println("date2.getDayOfMonth() = " + date2.getDayOfMonth());
        System.out.println("date2.getDayOfYear() = " + date2.getDayOfYear());

        //withXxx() 设置相关的属性
        System.out.println("******** with ********");
        //date2不变：不可变性
        LocalDateTime date3 = date2.withDayOfMonth(25);
        System.out.println("date2 = " + date2);
        System.out.println("date3 = " + date3);

        //加减
        System.out.println("******** plus ********");
        LocalDateTime date4 = date2.plusDays(3);
        System.out.println("date4 = " + date4);

        System.out.println("******** minus ********");
        LocalDateTime date5 = date2.minusDays(5);
        System.out.println("date5 = " + date5);

    }

    /*
        Instant 类
        提供一个机器视图，不处理人类意义上的时间单位
        类似java.util.Date类

     */
    @Test
    public void test1(){
        //伦敦时间
        Instant instant = Instant.now();
        System.out.println("instant = " + instant);

        //时区偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime = " + offsetDateTime);

        //获取毫秒数
        System.out.println("instant.toEpochMilli() = " + instant.toEpochMilli());

        //通过毫秒数获取对象
        Instant instant1 = Instant.ofEpochMilli(1595554120282L);
        System.out.println("instant1 = " + instant1);
    }

    /*
        java.time.format.DateTimeFormat类
     */

    /*
        Others:
            ZoneId
            ZoneDateTime
            Clock
                Duration
                Period
            TemporalAdjuster
            TemporalAdjusters
     */
}
