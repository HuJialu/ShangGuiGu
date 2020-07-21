package String;

import org.junit.Test;

/**
 * String类常用方法二
 * @author Jialu Hu
 * @create 2020-07-21
 */
public class StringMethodTest2 {
    @Test
    public void test0(){
        String s1 = "abcdef";
        System.out.println(s1.endsWith("def"));

        System.out.println(s1.startsWith("ab"));

        //offset
        System.out.println(s1.startsWith("de",3));
    }

    /*
        什么时候indexOf(str) 和 lastIndexOf(str) 返回值一样
            str只出现过一次、没有出现过
     */
    @Test
    public void test1(){
        String s1 = "abcdefabc";
        System.out.println(s1.contains("cde"));

        //首次出现的索引
        System.out.println(s1.indexOf('a'));

        //未找到返回-1

        System.out.println(s1.indexOf('a',4));
    }
}
