package com.zwx.learn.stack;

//先进先出
public class MyStack {
        //栈的底层用数组
        int[] elements;

        public MyStack(){
            elements = new int[0];
        }

        public void push(int element){
            int[] newArray = new int[elements.length+1];
            for (int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }
            newArray[elements.length] = element;
            elements = newArray;
        }

        public int pop(){
            if(elements.length == 0){
                throw new RuntimeException("stack is empty");
            }

            int[] newArray = new int[elements.length-1];
            int elemnet = elements[elements.length-1];
            for (int i = 0; i < elements.length - 1 ; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;
            return elemnet;
        }

        public int peek(){
            if(elements.length == 0){
                throw new RuntimeException("zwx : stack is empty");
            }
            return elements[elements.length-1];
        }

        public boolean isEmpty(){
            return elements.length == 0;
        }
}
