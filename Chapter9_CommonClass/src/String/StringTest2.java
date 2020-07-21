package String;

/**
 * @author Jialu Hu
 * @create 2020-07-21
 */
public class StringTest2 {
    String str = new String("good");//堆
    char[] ch = {'t','e','s','t'};

    //！！！！基本数据类型传递值，引用数据类型传递地址值！！！！
    public void change(String str,char ch[]){
        str = "test ok";//常量池
        ch[0] = 'b';
    }
    public void change1(String str,char ch[]){
        str = new String("test ok");
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest2 ex = new StringTest2();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str); //good
        System.out.println(ex.ch);  //best

        ex.change1(ex.str,ex.ch);
        System.out.println(ex.str); //good
        System.out.println(ex.ch);  //best
    }
}
