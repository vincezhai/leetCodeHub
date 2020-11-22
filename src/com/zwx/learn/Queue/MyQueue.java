package com.zwx.learn.Queue;

//先进后出
public class MyQueue {
    int[] elements;

    public MyQueue(){
        elements = new int[0];
    }

    //入队
    public void push(int element){
        int[] newArray = new int[elements.length+1];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        newArray[elements.length] = element;
        elements = newArray;
    }

    //出队
    public int poll(){
        if(elements.length == 0){
            throw new RuntimeException("stack is empty");
        }

        int[] newArray = new int[elements.length-1];
        int elemnet = elements[0];
        for (int i = 0; i < elements.length - 1 ; i++) {
            newArray[i] = elements[i+1];
        }
        elements = newArray;
        return elemnet;
    }

    public boolean isEmpty(){
        return elements.length == 0;
    }


}
