package Enum;

/**
 * 使用 enum 关键字实现接口的情况二
 * 让枚举类的对象分别实现接口中的抽样方法
 *
 * @author Jialu Hu
 * @create 2020-07-25
 */
public class EnumExample3 {
    public static void main(String[] args) {
        Season2[] values = Season2.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println("values[" + i + "] = " + values[i]);
            values[i].show();
        }
    }
}

enum Season2 implements Info {
    //提供当前枚举类的对象，多个对象之间用"," 末尾对象用";"
    SPRING ("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天");
        }
    },
    SUMMER ("夏天","烈日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天");
        }
    },
    AUTUMN ("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天");
        }
    },
    WINTER ("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("冬天");
        }
    };

    private final String Season2Name;
    private final String Season2Desc;

    private Season2(String Season2Name, String Season2Desc) {
        this.Season2Name = Season2Name;
        this.Season2Desc = Season2Desc;
    }



    public String getSeason2Name() {
        return Season2Name;
    }

    public String getSeason2Desc() {
        return Season2Desc;
    }

//    @Override
//    public String toString() {
//        return "Enum.Season2{" +
//                "Season2Name='" + Season2Name + '\'' +
//                ", Season2Desc='" + Season2Desc + '\'' +
//                '}';
//    }


//    @Override
//    public void show() {
//        System.out.println("现在是" + this.Season2Name + "！");
//    }
}



