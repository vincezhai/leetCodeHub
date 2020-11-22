package com.zwx.leetcode.stack_query;

import java.util.LinkedList;
import java.util.Queue;

public class MyCircularQueue {
    private int[] array;
    private int cnt;
    private int head;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.array = new int[k];
        this.cnt = 0;
        this.head = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(this.cnt == this.array.length){
            return false;
        }
        array[ (this.head + this.cnt)%this.array.length ] = value;
        this.cnt++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(cnt == 0){
            return false;
        }
        //array[] = ;
        this.head ++;
        if(this.head >= this.array.length){
            this.head = this.head % this.array.length;
        }
        this.cnt--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(this.cnt == 0){
            return -1;
        }
        return this.array[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(this.cnt == 0){
            return -1;
        }
        int last = this.head + this.cnt ;
        if(last > this.array.length){
            last = last % this.array.length;
        }
        return array[last -1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(this.cnt == 0){
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(this.cnt == this.array.length){
            return true;
        }
        return false;
    }
}
