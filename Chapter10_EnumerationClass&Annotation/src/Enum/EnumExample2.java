package Enum;

/**
 * 枚举类：使用 enum 关键字
 * Note:
 *      定义的枚举类默认继承于class java.lang.Enum
 *
 * Enum类中的常用方法
 * 1. values()
 * 2. valueOf(String str)
 * 3. toString()
 *
 * 使用 enum 关键字实现接口的情况一：实现接口、在enum类中实现抽象方法
 *
 * @author Jialu Hu
 * @create 2020-07-25
 */
public class EnumExample2 {
    public static void main(String[] args) {
        Season1 s1 = Season1.SUMMER;
        System.out.println("s1 = " + s1);

        //class java.lang.Enum
        System.out.println("Enum.Season1.class.getSuperclass() = " + Season1.class.getSuperclass());

        //values()
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println("values[" + i + "] = " + values[i]);
        }

        System.out.println();

        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println("values1[" + i + "] = " + values1[i]);

        }

        System.out.println();

        //valueOf(String str)
        //若没有相应的对象，则抛出异常
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println("winter = " + winter);

        winter.show();
    }
}

enum Season1 implements Info{
    //提供当前枚举类的对象，多个对象之间用"," 末尾对象用";"
     SPRING ("春天","春暖花开"),
     SUMMER ("夏天","烈日炎炎"),
     AUTUMN ("秋天","秋高气爽"),
     WINTER ("冬天","冰天雪地");
    
    private final String Season1Name;
    private final String Season1Desc;

    private Season1(String Season1Name, String Season1Desc) {
        this.Season1Name = Season1Name;
        this.Season1Desc = Season1Desc;
    }

    

    public String getSeason1Name() {
        return Season1Name;
    }

    public String getSeason1Desc() {
        return Season1Desc;
    }

//    @Override
//    public String toString() {
//        return "Enum.Season1{" +
//                "Season1Name='" + Season1Name + '\'' +
//                ", Season1Desc='" + Season1Desc + '\'' +
//                '}';
//    }


    @Override
    public void show() {
        System.out.println("现在是" + this.Season1Name + "！");
    }
}

interface Info{
    void show();
}
