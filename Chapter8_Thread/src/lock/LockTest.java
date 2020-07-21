package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全 Lock(锁)  JDK5.0
 *
 * Lock接口是控制多个线程对共享资源进行访问的工具
 *
 * synchronized && lock
 * 相同点： 解决线程安全问题
 * 不同点： synchronized 机制在执行完相应的同步代码之后，自动释放同步监视器
 *         lock 需要手动地启动同步，同时结束同步也需要手动的实现
 *
 * 解决线程安全问题：
 * 1. 同步代码块
 * 2. 同步方法
 * 3. lock
 * @author Jialu Hu
 * @create 2020-07-19
 */
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

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

class Window implements Runnable{
    private int tickets = 100;

    //1. 实例化
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            try{
                //2. 调用锁定方法lock()
                lock.lock();

                if(tickets > 0){
                    System.out.println(Thread.currentThread().getName()+tickets);
                    tickets--;
                }
                else
                    break;
            }finally {
                //3. 调用解锁方法
                lock.unlock();
            }

        }
    }
}
