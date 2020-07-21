package implementsRunable;

/**
 * 同步代码块 处理 Runnable
 * @author Jialu Hu
 * @create 2020-07-18
 */
public class window_Runnable_SYNBlock {
    public static void main(String[] args) {
        Window_Block w = new Window_Block();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一：");
        t2.setName("窗口二：");
        t3.setName("窗口三：");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window_Block implements Runnable{
    public int tickets = 100;

    @Override
    public void run() {
        while(true){
            synchronized (this){
                if(tickets > 0){
                    System.out.println(Thread.currentThread().getName()+tickets);
                    tickets--;
                }
                else
                    break;
            }
        }
    }
}




