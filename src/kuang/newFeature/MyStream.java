package kuang.newFeature;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MyStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(){{
            add(4);
            add(41);
            add(5);
            add(10);
        }};
        int res = 0;

        // 进行累加操作，a，b是先后顺序
        res = list.stream().reduce((a,b)->a+b).get();
        System.out.println("res = " + res); // 60

        // 增加了初始值
        res = list.stream().reduce(100,(a,b)->a+b);
        System.out.println("res = " + res); // 160

        // 弥补1、2不足，摆脱了返回值类型的限制
        // 第1个方法，返回的是optional类型，所以需要 get 取出
        // 第2个方法，有了初始值，所以不会出 null ，因此可以直接取出
        // 第三个可以指定返回类型
        long resLong = list.stream().reduce(100L,(a,b)->a+b,(a,b)->0L);
        System.out.println("res = " + resLong); // 160

        // eg2
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6);
        ArrayList<String> result = numList.stream().reduce(new ArrayList<String>(), (a, b) -> {
            a.add("element-" + Integer.toString(b));
            return a;
        }, (a, b) -> null);
        System.out.println(result);


    }

}