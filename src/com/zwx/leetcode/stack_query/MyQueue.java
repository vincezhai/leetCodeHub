package com.zwx.leetcode.stack_query;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> stack_tmp;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack = new Stack<>();
        this.stack_tmp = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 仅用stack反向
        int n = this.stack.size();
        while (!this.stack.isEmpty()){
            stack_tmp.push( stack.pop() );
        }
        stack.push(x);
        while (!this.stack_tmp.isEmpty()){
            stack.push( stack_tmp.pop() );
        }

        /* 用数组反向
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = this.stack.pop();
        }
        this.stack.push(x);
        for (int i = n-1; i >=0; i--) {
            this.stack.push(a[i]);
        }
        */

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return this.stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return this.stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stack.isEmpty();
    }

    //get
    public void getStack(){
        System.out.println("this.stack = " + this.stack);
    }

}
