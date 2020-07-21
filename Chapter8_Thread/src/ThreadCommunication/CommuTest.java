package ThreadCommunication;

/**
 * 线程通信：  两个线程交替打印 0 - 100
 * wait():      执行后，此线程进入阻塞状态，并释放同步监视器
 * notify():    执行后，就会唤醒被 wait() 的一个线程。如果有多个线程被 wait ，就会唤醒优先级高的那个
 * notifyAll(): 执行后，就会唤醒被 wait() 的所有线程
 *
 * Note:
 * 1. 只能出现在同步代码块、同步方法中。
 * 2. 调用者必须是同步代码块、同步方法中的同步监视器，否则会出现IllegalMonitorStateException异常
 * 3. 三个方法都定义在java.lang.Object类中
 *
 * sleep() vs. wait()
 * 相同点：
 *          一旦执行，就会使得当前线程进入阻塞状态
 * 不同点：
 *          1. 两个方法声明位置不同： Thread类中声明sleep() ，Object类中声明wait()
 *          2. 调用的要求不同： sleep() 可以在任何需要的场景调用， wait()只能用在同步代码块、同步方法中
 *          3. 关于是否释放同步监视器： sleep() 不会释放锁， wait() 释放锁
 *
 * @author Jialu Hu
 * @create 2020-07-19
 */
public class CommuTest {
    public static void main(String[] args) {
        Number n = new Number();

        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.setName("线程一：");
        t2.setName("线程二：");

        t1.start();
        t2.start();
    }
}

class Number implements Runnable{
    private int num = 1;

    @Override
    public void run() {
        while(true){
            synchronized (this) {

                //this.notifyAll();
                notifyAll();

                if(num < 100){
                    System.out.println(Thread.currentThread().getName()+":"+num);
                    num++;

                    //使得调用的线程进入阻塞状态
                    try {
                        wait(); //释放同步锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    break;
                }
            }
        }
    }
}