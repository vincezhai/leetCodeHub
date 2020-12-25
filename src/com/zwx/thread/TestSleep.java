package com.zwx.thread;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class TestSleep {
    public static void main(String[] args) {
        try {
            countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10 ; i++) {
            try {
                Date date = new Date(System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println( new SimpleDateFormat("HH:mm:ss").format(date));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void countDown() throws InterruptedException {
        for (int i = 2; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
    }


}
