import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * JDK8之前日期时间API
 *
 * @author Jialu Hu
 * @create 2020-07-21
 */
public class OldTimeAPI {
    /*
        一、
        System.currentTimeMillis()
     */
    @Test
    public void test0(){
        //返回当前时间与1970年1月1日0时0秒之间以毫秒为单位的时间差 == 时间戳
        long time = System.currentTimeMillis();
        System.out.println("time = " + time);
    }


    /*
        二、
        java.util.Date类 (!= java.sql.Date)
        1. 两个构造器的使用
            new Date()： 创建一个对应当前时间的Date对象
            new Date(long)： 创建一个指定毫秒数的Date对象

        2. 两个方法的使用
            toString()： 显示当前的年、月、日、时、分、秒
            getTime()：  获取当前Date对象的时间戳

        3. java.sql.Date对应数据库中的日期变量类型

     */
    @Test
    public void test1(){
        Date date1 = new Date();
        System.out.println("date1.toString() = " + date1.toString());//Wed Jul 22 04:17:20 CST 2020
        System.out.println("date1.getTime() = " + date1.getTime());

        Date date2 = new Date(1595362640052L);
        System.out.println("date2.toString() = " + date2.toString());

        //将 java.util.Date 转换为 java.sql.Date
        java.sql.Date d3 = new java.sql.Date(date2.getTime());
    }


    /*
        三、
        java.text.SimpleDateFormat类
        对日期Date类的格式化和解析     日期 <-> 文本
        1. 两个操作：
            1）格式化：                  日期 --> 字符串
            2）解析：   格式化的逆过程     字符串 --> 日期
        2. SimpleDateFormat实例化
     */
    @Test
    public void test2() throws ParseException {
        //实例化
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化
        Date date = new Date();
        System.out.println("date = " + date);

        String format = sdf.format(date);
        System.out.println("format = " + format);

        //解析
        String str = "2020/7/22 下午10:59";   //默认
        Date date2 = sdf.parse(str);
        System.out.println("date2 = " + date2);

        //按照指定方式格式化！！！
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str2 = sdf2.format(date);
        System.out.println("str2 = " + str2);

        //解析 -- 要求格式符合要求 否则抛出异常
        Date date3 = sdf2.parse("2020-07-22 11:07:11");
        System.out.println("date3 = " + date3);

    }

    /*
        三、练习一
        字符串"2020-07-22" 转换为 java.sql.Date
     */
    @Test
    public void test2Ex1() throws ParseException {
        String birth = "2020-07-22";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birth);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println("birthDate = " + birthDate);
    }

    /*
        三、练习二
        计算两个日期之间的天数：
        1) (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) +1
     */



    /*
        四、
        Calendar日历类的使用   abstract
        Note:
            一月0，二月1...
            周一1，周二2...
     */
    @Test
    public void test3(){
        //1. 实例化
        //方式一：创建其子类： GregorianCalendar 的对象
        //方式二：调用其静态方法 Calendar.getInstance();   返回GregorianCalendar
        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar.getClass() = " + calendar.getClass());

        //2. 常用方法
        //get
//        System.out.println("calendar.get(Calendar.DAY_OF_MONTH) = " + calendar.get(Calendar.DAY_OF_MONTH));
//        System.out.println("calendar.get(Calendar.DAY_OF_YEAR) = " + calendar.get(Calendar.DAY_OF_YEAR));

        //set
        calendar.set(Calendar.DAY_OF_MONTH,24);
        System.out.println("calendar.get(Calendar.DAY_OF_MONTH) = " + calendar.get(Calendar.DAY_OF_MONTH));

        //add
        calendar.add(Calendar.DAY_OF_MONTH,3);
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        System.out.println("calendar.get(Calendar.DAY_OF_MONTH) = " + calendar.get(Calendar.DAY_OF_MONTH));

        //getTime
        Date date = calendar.getTime();
        System.out.println("date = " + date);

        //setTime
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println("calendar.get(Calendar.DAY_OF_MONTH) = " + calendar.get(Calendar.DAY_OF_MONTH));

    }
}
