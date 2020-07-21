package extendsThread;

import java.awt.*;

/**
 * 多线程创建 方法一：继承于 Thread 类
 * 1. 创建一个继承于 Thread 类的子类
 * 2. 重写 Thread 类的 run()
 * 3. 创建 Thread 类的子类对象
 * 4. 通过此对象调用 start()
 *
 * (线程安全)
 *
 * 同步代码块 处理 Thread
 *
 * @author Jialu Hu
 * @create 2020-07-18
 */
public class Window_Thread_SYNBlock {
    public static void main(String[] args) {
        Window_Block w1 = new Window_Block();
        Window_Block w2 = new Window_Block();
        Window_Block w3 = new Window_Block();

        w1.setName("窗口一：");
        w2.setName("窗口二：");
        w3.setName("窗口三：");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window_Block extends Thread{
    private static int tickets = 100;

    @Override
    public void run() {
        while(true){
            synchronized (Window.class){
                if(tickets > 0){
                    System.out.println(this.getName()+tickets);
                    tickets--;
                }
                else
                    break;
            }
        }
    }
}

class GOOD{

}
