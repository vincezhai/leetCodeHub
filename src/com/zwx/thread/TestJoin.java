package com.zwx.thread;

public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println( Thread.currentThread().getName()  + " : " + i );
            }
        });
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread : " + i);
            if(i == 20){
                thread.join();
            }
        }
    }


}
