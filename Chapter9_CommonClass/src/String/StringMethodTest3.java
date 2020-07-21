package String;

import org.junit.Test;

/**
 * String类常用方法三
 * @author Jialu Hu
 * @create 2020-07-21
 */
public class StringMethodTest3 {
    /*
        .replace(Char,Char)
        .replace(CharSequence,CharSequence) (String)
        .replaceAll     正则表达式
        .matches        正则表达式
        .split
     */
    @Test
    public void test0(){
        String s1 = "abcdefabc";
        String s2 = s1.replace("abc","ABC");
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        String s3 = "12This34is45a78test90";
        //1. 数字 -> ,
        //2. 收尾去掉 ,
        System.out.println(s3.replaceAll("\\d+",",").replaceAll("^,|.$",""));

        String s4 = "12345";
        //纯数字，+表示多个
        System.out.println(s4.matches("\\d+"));

        s4 = "0123-45678";
        // { , } 判断长度
        System.out.println(s4.matches("0123-\\d{4,5}"));

        System.out.println("*************");
        String s5 = "abc|def|ghi";
        String[] s6 = s5.split("\\|");
        for (int i = 0; i < s6.length; i++) {
            System.out.println(s6[i]);
        }
    }
}
