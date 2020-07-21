package String.StringBufferStringBuilder;

import org.junit.Test;

import java.sql.SQLOutput;

/**
 *  关于StringBuffer的使用
 *
 * @author Jialu Hu
 * @create 2020-07-22
 */
public class StringBufferBuilderTest {
    /*
        String / StringBuffer / StringBuilder
        String:         不可变的字符序列                                底层使用final char[]存储
        StringBuffer:   可变的字符序列     线程安全    效率低             底层使用char[]存储
        StringBuilder:  可变的字符序列     线程不安全  效率高  JDK5.0      底层使用char[]存储

        源码分析：
        String s1 = new String();       //char[] value = new char[0];
        String s2 = new String("abc");  //char[] value = new char[]{'a','b','c'};

        StringBuffer sb1 = new StringBuffer();  //char[] value = new char[16];
        System.out.println(sb1.length());       // 0 !!!!
        sb1.append('a');                        //value[0] = 'a';
        sb1.append('b');                        //value[1] = 'b';

        StringBuffer sb2 = new StringBuffer("abc"); //char[] value = new char["abc".length() + 16];
        //Question 1: sb2.length() == 3
        //Question 2: 扩容问题： 底层数组存不下了，需要扩容底层数组
                        默认情况下，扩容为原来容量的2倍(<<1 ： 位运算符)+2，同时将原有数组中的元素复制到新数组中。
                        特殊情况下，用新字符串长度作为数组大小...也判断扩容后数组大小是否为负
            指导意义：开发中建议使用： StringBuffer(int capacity) 或 StringBuilder(int capacity)
     */

    @Test
    public void test0(){
        StringBuffer sb1 = new StringBuffer("abc");
        //直接修改
        sb1.setCharAt(0,'d');
        System.out.println("sb1 = " + sb1);
    }

    /*
        常用方法： 以StringBuffer为例， StringBuilder类似（线程不安全）
        增：append(str)
        删：delete(int start,int end)
        改：setCharAt(int n,char ch)  /   replace(int start,int end,String str)
        查：charAt(int n)
        插：insert(int offset,xxx)
        长度：length()
        *遍历：for + charAt()  /   toString
     */
    @Test
    public void test1(){
        StringBuffer s1 = new StringBuffer("abcdef");
        s1.append(1);   // s+= 1;
        s1.append("1");
        System.out.println("s1 = " + s1);

        //s1.delete(2,6); //左闭右开 [2,6)
        //s1.replace(2,6,"**");
        //s1.insert(2,'C');
        s1.reverse();
        System.out.println("s1 = " + s1);
    }

    /*
        三者效率测试：StringBuilder > StringBuffer > String
     */
    @Test
    public void test2(){
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String 的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer 的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder 的执行时间：" + (endTime - startTime));
    }
}

