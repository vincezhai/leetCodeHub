package com.zwx.leetcode.exam;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        testOne();
        testTwo();
    }

    public static void testOne(){
        MemoSystem ms = new MemoSystem();
        // one
        System.out.println(" one :"+ ms.addEvent(2, "eat a burger", 2, 3));
        ms.getMap();

        // two
        String[] todo = ms.queryTodo(0, 5);
        List<String> list = Arrays.asList(todo);
        System.out.println(" two : "  + list);
        ms.getMap();

        // three
        System.out.println(" Three : " + ms.finishEvent(2, "eat a burger"));
        ms.getMap();

        // four
        System.out.println(" Four : " +ms.removeEvent(2, "eat a burger"));
        ms.getMap();
    }

    public static void testTwo(){
        MemoSystem ms = new MemoSystem();

        // one
        System.out.println(" 1 :"+ ms.addEvent(2, "save files", 1, 1));
        ms.getMap();

        // two
        System.out.println(" 2 :"+ ms.addEvent(2, "eat a burger", 1, 1));
        ms.getMap();

        // three
        System.out.println(" 3 : " +ms.removeEvent(2, "drink water"));
        ms.getMap();

        // four
        System.out.println(" 4 : " + ms.finishEvent(1, "drink water"));
        ms.getMap();

        // five
        System.out.println(" 5 :"+ ms.addEvent(0, "eat a burger", 5, 2));
        ms.getMap();

        // six
        System.out.println(" 6 :"+ ms.addEvent(2, "save files", 1, 1));
        ms.getMap();

        // seven
        String[] todo = ms.queryTodo(0, 4);
        List<String> list = Arrays.asList(todo);
        System.out.println(" 7 : "  + list);
        ms.getMap();

        // eight
        String[] todo1 = ms.queryTodo(10, 11);
        List<String> list1 = Arrays.asList(todo1);
        System.out.println(" 8 : "  + list1);
        ms.getMap();

        // nine
        System.out.println(" 9 : " + ms.finishEvent(2, "eat a burger"));
        ms.getMap();

        // ten
        System.out.println(" 10 :"+ ms.addEvent(2, "eat a burger", 1, 1));
        ms.getMap();

    }
}
