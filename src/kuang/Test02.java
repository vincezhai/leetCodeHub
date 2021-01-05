package kuang;

public class Test02 {
    public static void main(String[] args) {
        long max = Runtime.getRuntime().maxMemory();
        long total = Runtime.getRuntime().totalMemory();
        System.out.println("max = " + max/(double)1024/1024 + "MB");
        System.out.println("total = " + total/(double)1024/1024 + "MB");
    }
}
