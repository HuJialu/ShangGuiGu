package String;

import org.junit.Test;

/**
 * String类
 * final类，代表不可变的字符序列
 * 存储在value[]中 (final)
 *
 *
 * @author Jialu Hu
 * @create 2020-07-20
 */
public class StringTest {
    /*
        String:
        1. String声明为final，不能被继承
        2. String实现了Serializable接口：表示字符串支持序列化的。
                 实现了Comparable接口：表示String可以比较大小
        3. String内部定义了final char[] value用于存储字符串数据
        4. String：代表不可变得字符串序列。不可变性
              体现： 1) 当对字符串重新赋值时。需要重新指定内存区域赋值，不能使用原有的value进行赋值
                    2) 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
                    3) 当调用String类的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
        5. 通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中
        6. 字符串常量池中通常是不会存储相同内容的字符串的
     */
    @Test
    public void test1(){
        String s1 = "abc"; //字面量的定义方式
        String s2 = "abc";

        s1 = "hello";
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("***********");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);

        System.out.println("***********");

        String s4 = "abc";
        String s5 = s4.replace('a','d');
        System.out.println("s4 = " + s4);
        System.out.println("s5 = " + s5);

    }

    /*
        String s3 = new String("abc"); 该方式在内存中创建了几个对象？
        两个：一个是堆空间中new结构，一个是char[]对应的常亮池中的数据
     */
    @Test
    public void test2(){
        //字符串的创建

        //存储在方法区常量池中，目的是共享
        String s1 = "abc";
        String s2 = "abc";

        //存储在堆中
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2);// true
        System.out.println(s1 == s3);// false
        System.out.println(s1 == s4);// false
        System.out.println(s3 == s4);// false

        System.out.println("***********");
        Person p1 = new Person("Tom",18);
        Person p2 = new Person("Tom",18);

        System.out.println(p1.name.equals(p2.name));    //true
        System.out.println(p1.name == p2.name);         //true

        p2.name = "Jack";
        System.out.println(p1.name);    //Tom
    }

    /*
        结论：
        1. 常量与常量的拼接结果在常量池。且常量池中不会存在相同的常量内容。
        2. 只要有一个是变量，结果就在堆空间中
     */
    @Test
    public void test3(){
        String s1 = "abc";
        String s2 = "def";

        String s3 = "abcdef";
        String s4 = "abc" + "def";
        String s5 = s1 + "def";
        String s6 = "abc" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true

        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false

        //返回值得到的s8实用的常量池中已经存在的"abcdef"
        String s8 = s5.intern();
        System.out.println(s3 == s8);//true
    }
}
