package com.zwx.thread;

public class TestYield implements Runnable {
    public static void main(String[] args) {
        TestYield testYield = new TestYield();
        Thread thread1 = new Thread(testYield,"one");
        Thread thread2 = new Thread(testYield,"two");
        thread1.start();
        thread2.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(" thread run at : " + Thread.currentThread().getName());
            Thread.yield();
        }
    }
}
