package String;

import java.util.Arrays;

/**
 * 五道课后题
 *
 * @author Jialu Hu
 * @create 2020-07-22
 */
public class StringExcercise {
    public static void main(String[] args) {
        StringExcercise ex = new StringExcercise();

        System.out.println(ex.question1("   aaa "));
        System.out.println(ex.question1("    "));
        System.out.println(ex.question1("   a       "));

        //abcd efg hij
        System.out.println(ex.question2(4,7,"abcdefghij"));

        System.out.println(ex.question3("cdabkkcadkabkebfkabkskab","ab"));

        System.out.println(ex.question4("abcwerthelloyuiodef","cvhellobnm"));

        System.out.println(ex.question5("abcwerthelloyuiodef"));

    }

    /*
        模拟一个trim()，去除字符串两端的空格
     */
    public String question1(String str){
        //偶数个0时出问题
//        if(str == null)
//            return null;
//
//        int num = str.length();
//        if(str.charAt(0) != ' ' && str.charAt(num-1) != ' ')
//            return str;
//        else if(str.charAt(0) == ' ' && str.charAt(num-1) != ' ')
//            return question1(str.substring(1,num));
//        else if(str.charAt(0) != ' ' && str.charAt(num-1) == ' ')
//            return question1(str.substring(0,num));
//        else //str.charAt(0) != ' ' && str.charAt(num-1) != ' '
//            return question1(str.substring(1,num-1));

        if (str != null) {
            int start = 0;// 用于记录从前往后首次索引位置不是空格的位置的索引
            int end = str.length() - 1;// 用于记录从后往前首次索引位置不是空格的位置的索引

            while (start < end && str.charAt(start) == ' ') {
                start++;
            }

            while (start < end && str.charAt(end) == ' ') {
                end--;
            }
            if (str.charAt(start) == ' ') {
                return "";
            }

            return str.substring(start, end + 1);
        }
        return null;
    }


    /*
        2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
     */
    public String question2(int startIndex, int endIndex,String str){
        StringBuilder s = new StringBuilder(str.length());

        s.append(str.substring(0,startIndex));

        for (int i = endIndex-1 ; i >= startIndex ; i--) {
            s.append(str.charAt(i));
        }

        s.append(str.substring(endIndex,str.length()));

        return s.toString();
    }

    /*
        3.获取一个字符串在另一个字符串中出现的次数。
            比如：获取“ab”在 “cdabkkcadkabkebfkabkskab” 中出现的次数
     */
    public int question3(String str,String obj){
        if (str.length() >= obj.length()) {
            int count = 0;
            int index = 0;

            while ((index = str.indexOf(obj, index)) != -1) {
                index += obj.length();
                count++;
            }

            return count;
        } else {
            return 0;
        }
    }

    /*
        4.获取两个字符串中最大相同子串。比如：
            str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"//10
            提示：将短的那个串进行长度依次递减的子串与较长的串比较。
     */
    public String question4(String str1,String str2){
        String maxStr = (str1.length() >= str2.length())? str1:str2;
        String minStr = (str1.length() < str2.length())? str1:str2;

        int len = minStr.length();
        for (int i = 0; i < len; i++) {
            for(int s = 0, e=len-i ; e<=len ; s++,e++){
                if(maxStr.contains(minStr.substring(s,e)))
                    return minStr.substring(s,e);
            }
        }
        return null;
    }

    /*
        5.对字符串中字符进行自然顺序排序。"abcwerthelloyuiodef"
            提示：
            1）字符串变成字符数组。
            2）对数组排序，选择，冒泡，Arrays.sort(str.toCharArray());
            3）将排序后的数组变成字符串。

     */
    public String question5(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}


