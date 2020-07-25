package Enum;

/**
 * 枚举类
 *
 * 一、枚举类的使用
 * 1. 类的对象只有有限个，确定的
 * 2. 当需要定义一组常量时，强烈建议使用枚举类
 * 3. 如果枚举类中只有一个对象，则可以作为单例模式的实现方式
 *
 * 二、如何定义
 * 1. JDK5.0之前，自定义枚举类
 * 2. JDK5.0之后，使用enum关键字定义
 *
 * @author Jialu Hu
 * @create 2020-07-24
 */
public class EnumExample1 {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println("spring = " + spring);

    }
}

class Season{
    private final String seasonName;
    private final String seasonDesc;

    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","烈日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Enum.Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
