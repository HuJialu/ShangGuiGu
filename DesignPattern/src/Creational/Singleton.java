package Creational;

/**
 * 单例设计模式
 *
 * 只能存在一个对象实例
 * 构造器权限为private
 * 只能调用该类的静态方法返回类内部创建的对象
 * 指向该类对象的变量为 static
 *
 * @author Jialu Hu
 * @create 2020-07-18
 */
public class Singleton {
    public static void main(String[] args) {
        Singleton_Lazy sl = Singleton_Lazy.getSingletonLazy();
        Singleton_Early se = Singleton_Early.getSingletoneEarly();
    }
}

/**
 * 懒汉式
 *
 * (线程安全)
 */
class Singleton_Lazy{
    private static Singleton_Lazy sl = null;

    private Singleton_Lazy(){}

    public static Singleton_Lazy getSingletonLazy(){
        if(sl == null){
            synchronized (Singleton_Lazy.class){
                if(sl == null){
                    sl = new Singleton_Lazy();
                }
            }
        }
        return sl;
    }
}

/**
 * 饿汉式
 */
class Singleton_Early{
    private static Singleton_Early se = new Singleton_Early();

    private Singleton_Early(){}

    public static Singleton_Early getSingletoneEarly(){
        return se;
    }
}