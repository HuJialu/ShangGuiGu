package implementsCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程方式三： 实现Callable 接口   JDK5.0
 *
 * 如何理解实现Callable接口比实现Runnable接口更强大
 * 1. call()可以有返回值
 * 2. call()可以抛出异常，被外面的操作捕获
 * 3. Callable支持泛型的
 *
 * @author Jialu Hu
 * @create 2020-07-20
 */
public class Thread3 {
    public static void main(String[] args) {
        //3. 创建callable接口实现类的对象
        NumThread num = new NumThread();

        //4. 将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask<>(num);

        //5. 将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {
            //6. get获取返回值
            //get() 返回值为FutureTask 构造器参数Callable 实现类重写的call
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


//1. 创建一个实现callable的实现类
class NumThread implements Callable{
    //实现call方法，将此线程需要执行的操作声明在call中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100;i++) {
            if(i%2 == 0 ){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}
