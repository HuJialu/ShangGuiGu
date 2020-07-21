package ThreadCommunication;

/**
 * 线程通信的应用
 * 生产者/消费者问题
 *
 * @author Jialu Hu
 * @create 2020-07-19
 */
public class ProducerAndCustomer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("Producer: ");

        Customer c1 = new Customer(clerk);
        c1.setName("Customer: ");

        p1.start();
        c1.start();
    }
}

class Clerk{
    private int num = 0;

    //同步监视器： clerk
    public synchronized void consume(){
        if(num > 0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"start consuming No. "+ num);
            num--;

            //消费一个产品 -> 唤醒
            notify();
        }
        else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //同步监视器： clerk
    public synchronized void produce() {
        if(num < 20){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"start producing No. "+ num);

            notify();
        }
        else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"start producing......");
        while(true){
            clerk.produce();
        }
    }
}

class Customer extends Thread{
    private Clerk clerk;

    public Customer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"start consuming......");
        while(true){
            clerk.consume();
        }
    }
}