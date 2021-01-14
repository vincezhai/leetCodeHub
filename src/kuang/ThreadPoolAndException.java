package kuang;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolAndException {
    public static void main(String[] args) {

        threadPoolWithReturn();

    }

    private static void threadPoolWithReturn() {


        try {
            // 盛放结果
            List<String> res = new ArrayList<>();
            // 自定义线程池
            ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,10L, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<Runnable>(10) );


            for (int i = 0; i < 2; i++) {
                Callable thread = new Mytask(i);
                Future<String> future = executor.submit(thread);
                try {
                    res.add(future.get());
                } catch (InterruptedException e) {
                    System.out.println("catched 01");
                } catch (ExecutionException e) {
                    System.out.println("catched 02");
                }
            }
            executor.shutdown();

            // 输出展示
            res.stream().forEach(o-> System.out.println(o));
        } catch (Exception e){
            System.out.println("catched");
        }

    }
}

class Mytask implements Callable{
    int num;

    public Mytask(int num) {
        this.num = num;
    }

    @Override
    public String call() throws Exception {
        String str = null;
        str.length();
        for (int i = 0; i <= num; i++) {
            str += i;
        }
        return str;
    }
}
