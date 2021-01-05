package kuang;

public class Test01 {
    static {
        System.out.println("main类被加载");
    }

    public static void main(String[] args) {
        // 调用子类的父类静态变量，不会初始化子类
        // System.out.println("Son.a = " + Son.a);

        // 数组定义类引用，不会触发初始化，因为只分配了空间而已
        // Son[] array = new Son[5];

        // 常量在链接阶段已经存在，因此不会触发父类或者子类的初始化
        // System.out.println("Son.M = " + Son.M);

        System.out.println("Father.s = " + Father.s);
        System.out.println("Son.s = " + Son.s);

        Father instance01 = new Father();
        System.out.println("instance01.str = " + instance01.str);

        Son instance02 = new Son();
        System.out.println("instance02.str = " + instance02.str);

        new Thread(() ->{

        },"myThread").start();
    }
}

class Father{
    public static int a = 1;
    public static String s = "father";
    public String str = "father";
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    public static int b  = 0;
    public static final int M = 111;
    public static String s = "son";
    public String  str = "son";
    static {
        System.out.println("子类被加载");
    }
}
