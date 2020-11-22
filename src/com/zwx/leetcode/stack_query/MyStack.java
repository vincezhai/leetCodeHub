package com.zwx.leetcode.stack_query;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int n = queue.size();
        queue.add(x);
        for (int i = 0; i < n; i++) {
            queue.add(queue.poll() );
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return  (int)queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return (int)queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}
