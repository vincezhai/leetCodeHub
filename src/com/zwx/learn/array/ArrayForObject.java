package com.zwx.learn.array;

import com.zwx.learn.array.util.MyArray;

public class ArrayForObject {
    public static void main(String[] args) {
        MyArray ma = new MyArray();
        ma.add(1);
        System.out.println("ma.size() = " + ma.size());
        ma.add(2);
        //ma.delete(0);
        ma.show();
        ma.insert(1,10);
        ma.update(1,100);
        ma.show();
    }
}
