package String.StringBufferStringBuilder;

import org.junit.Test;

/**
 * null的特殊情况
 *
 * @author Jialu Hu
 * @create 2020-07-22
 */
public class StringNull {
    @Test
    public void DebugDemo(){
        String s = null;
        StringBuilder str = new StringBuilder();
        str.append(s);

        System.out.println(str.length());   //4
        System.out.println("str = " + str); //null

        StringBuilder str2 = new StringBuilder(s);  //NullPointerException
        System.out.println("str2 = " + str2);       //未运行
    }
}
