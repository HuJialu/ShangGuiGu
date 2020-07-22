import org.junit.Test;

import java.util.Date;

/**
 * JDK8之前日期时间API
 *
 * @author Jialu Hu
 * @create 2020-07-21
 */
public class OldTimeAPI {

    @Test
    public void test0(){
        //返回当前时间与1970年1月1日0时0秒之间以毫秒为单位的时间差 == 时间戳
        long time = System.currentTimeMillis();
        System.out.println("time = " + time);
    }

    /*
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
}
