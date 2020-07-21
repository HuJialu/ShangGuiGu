package implementsRunable;

/**
 * 多线程创建 方法二：实现 Runnable 接口
 * 1. 创建一个实现了 Runnable 接口的类
 * 2. 实现类去实现 Runnable 接口的抽象方法 run()
 * 3. 创建此类的对象
 * 4. 将此对象作为参数传递到 Thread 类的构造器中，创建 Thread 类的对象
 * 5. 通过此对象调用 start()
 *
 * 对比 方法一 & 方法二：
 * 开发中： 优先选择实现的方式
 * 1. 没有类的单继承性的局限性
 * 2. 适合处理多个线程有共享数据的情况
 *
 * 联系：   public class Thread implements Runnable
 * 相同点： 都需要重写 run()
 *         将线程需要执行的逻辑声明在 run() 中
 *
 * 同步方法处理 Runnable
 *
 * @author Jialu Hu
 * @create 2020-07-18
 */
public class Window_Runnable_SYNMethod {
    public static void main(String[] args) {
        Window_Method w = new Window_Method();
        
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

class Window_Method implements Runnable{
    public int tickets = 100;
    
    @Override
    public void run() {
        while(getTickets());
    }

    private synchronized Boolean getTickets(){
        if(tickets > 0){
            System.out.println(Thread.currentThread().getName()+tickets);
            tickets--;
            return true;
        }
        else
            return false;
    }
}

class GOOD{

}
