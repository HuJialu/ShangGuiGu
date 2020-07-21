package extendsThread;

/**
 * 同步方法 处理 Thread
 *
 * @author Jialu Hu
 * @create 2020-07-18
 */
public class Window_Thread_SYNMethod {
    public static void main(String[] args) {
        Window_Method w1 = new Window_Method();
        Window_Method w2 = new Window_Method();
        Window_Method w3 = new Window_Method();

        w1.setName("窗口一：");
        w2.setName("窗口二：");
        w3.setName("窗口三：");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window_Method extends Thread{
    public static int tickets = 100;

    @Override
    public void run() {
        while(getTickets());
    }

    private static synchronized Boolean getTickets(){
        if(tickets > 0){
            System.out.println(Thread.currentThread().getName()+tickets);
            tickets--;
            return true;
        }
        else
            return false;
    }
}
