package com.zwx.learn.array.util;

import com.zwx.learn.array.Array;

import java.time.chrono.MinguoDate;
import java.util.Arrays;

public class MyArray {

    private int[] elements;

    public MyArray(){
        elements = new int[0];
    }

    //size
    public int size(){
        return elements.length;
    }

    //show
    public void show(){
        System.out.println(Arrays.toString(elements));
    }

    // add at end
    public void add(int element){
        int[] newArray = new int[elements.length+1];
        for (int i = 0; i <elements.length ; i++) {
            newArray[i] = elements[i];
        }
        newArray[elements.length] = element;
        elements = newArray;
    }

    // delete
    public void delete (int idx){
        // bound
        if(idx < 0 || idx > elements.length-1)
            throw new RuntimeException("out of bound");

        int[] newArray = new int[elements.length-1];
        for (int i = 0; i < newArray.length; i++) {
            if(i < idx){
                newArray[i] = elements[i];
            }else {
                newArray[i] = elements[i+1];
            }
        }
        elements=newArray;
    }

    //find
    public int get(int idx){
        return elements[idx];
    }

    //insert
    public void insert(int idx, int element){
        if(idx < 0 || idx >elements.length-1)
            throw new RuntimeException("out of bound");

        int[] newArray = new int[elements.length+1];
        for (int i = 0; i <elements.length; i++) {
            if(i < idx){
                newArray[i] = elements[i];
            }else if (idx == i){
                newArray[i] = element;
            }else {
                newArray[i] = elements[i-1];
            }
        }
        elements = newArray;
    }

    //update
    public void update(int idx, int element){
        if(idx < 0 || idx >elements.length-1)
            throw new RuntimeException("out of bound");
        elements[idx] = element;
    }
}
