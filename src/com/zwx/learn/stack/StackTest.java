package com.zwx.learn.stack;

public class StackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        for (int i = 0; i <10 ; i++) {
            myStack.push(i);
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println(myStack.pop());
        }
        myStack.peek();

    }
}
