package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 多线程方式4： 线程池
 *
 * 好处：
 * 1. 提高响应速度
 * 2. 降低资源消耗
 * 3. 便于线程管理
 *          corePoolSize    核心线程池的大小
 *          maximumPoolSize 最大线程数
 *          keepAliveTime   线程没有任务时最多保持多长时间后会终止
 *
 * @author Jialu Hu
 * @create 2020-07-20
 */
public class Thread4 {
    public static void main(String[] args) {
        //1. 提供指定线程数量的线程池
        /*
            ExecutorService 为接口
            ThreadPoolExecutor 为实现类
        */
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        //设置线程池的属性
        //service1.setCorePoolSize(15);
        //service1.setKeepAliveTime();

        //2. 执行指定线程的操作
        //适用于Runnable
        service.execute(new Thread0());
        service.execute(new Thread1());

        //适用于Callable
        //service.submit();

        //关闭连接池
        service.shutdown();
    }
}

class Thread0 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2 == 0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}

class Thread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2 != 0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}
