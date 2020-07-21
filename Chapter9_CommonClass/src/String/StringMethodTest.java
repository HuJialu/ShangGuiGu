package String;

import org.junit.Test;

/**
 * String类常用方法一
 * @author Jialu Hu
 * @create 2020-07-21
 */
public class StringMethodTest {
    @Test
    public void test1(){
        String s1 = "HelloWorld";

        System.out.println(s1.length());

        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));

        System.out.println(s1.isEmpty());

        System.out.println(s1.toLowerCase());//s1本身没有修改，不可变
        System.out.println(s1.toUpperCase());//s1本身没有修改，不可变
        System.out.println(s1);

        String s3 = "   Hel  loWor  ld   ";
        //去除空格 （注册）
        String s4 = s3.trim();
        System.out.println("---"+s3+"---");
        System.out.println("---"+s4+"---");
    }

    @Test
    public void test2(){
        String s1 = "abc";
        String s2 = new String("abe");

        // compareTo() 正-> 前大； 负-> 后大
        // 涉及到字符串排序
        System.out.println(s1.compareTo(s2)); // s1-s2 = -2

        String s3 = "abcdefg";
        String s4 = s3.substring(2);

        System.out.println("s3 = " + s3);
        System.out.println("s4 = " + s4);

        // [2，4] // [2,5) 不含5 左闭右开
        String s5 = s3.substring(2,5);//头，尾
        System.out.println("s5 = " + s5);

    }
}
