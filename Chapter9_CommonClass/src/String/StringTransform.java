package String;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 *
 * @author Jialu Hu
 * @create 2020-07-21
 */
public class StringTransform {

    /*
        String 与基本数据类型、包装类之间的转换
        String --> 基本数据类型、包装类 : 调用包装类的静态方法 Xxx.parseXxx(str)
        基本数据类型、包装类 --> String : 调用String重载的valueOf()
     */
    @Test
    public void test0(){
        String s1 = "123";
        int num = Integer.parseInt(s1);

        String s2 = String.valueOf(num);
        String s3 = num + "";           //有变量参与 -> 在堆中
        // s1 != s3
    }

    /*
        String 与 char[]
            String -> char[] : .toCharArray()
            char[] -> String : 调用String的构造器
     */
    @Test
    public void test1(){
        String s1 = "abc123";

        char[] chars = s1.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            System.out.println("chars["+ i+ "] = " + chars[i]);
        }

        char[] ch = new char[]{'h','e','l','l','o'};
        String s = new String(ch);
        System.out.println(s);
    }

    /*
        String \ byte[]
            String -> byte[] : 编码： 调用String的getBytes()
            byte[] -> String : 解码： 调用String的构造器
        编码与解码的字符集要求一致，否则会出现乱码
     */
    @Test
    public void test2() throws UnsupportedEncodingException {
        String s1 = "abc123";

        //ascii
        byte[] bytes = s1.getBytes();//使用默认的字符集，进行转换，UTF-8
        System.out.println(Arrays.toString(bytes));

        String s2 = "abc123北京";
        byte[] b0 = s2.getBytes();
        System.out.println(Arrays.toString(b0));

        byte[] b1 = b1 = s2.getBytes("gbk");//使用gbk;
        System.out.println(Arrays.toString(b1));

        System.out.println("解码");
        String s3 = new String(b0);
        System.out.println("s3 = " + s3);

        String s4 = new String(b1); //乱码 gbk & UTF-8
        System.out.println("s4 = " + s4);

        String s5 = new String(b1,"gbk");
        System.out.println("s5 = " + s5);
    }
}
