package com.zwx.leetcode.stack_query;

import com.zwx.learn.array.Array;

import java.util.Arrays;

public class MyCircularDeque {
    private int[] array;
    private int cnt;
    private int head;
    private int tail;
    private int length;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.array = new int[k];
        this.cnt = 0;
        this.head = 0;
        this.tail = 0;
        this.length = array.length;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(this.cnt == this.length ){
            return false;
        }
        this.head--;
        this.head = (this.head + this.length) % this.length;
        this.array[head] = value;
        cnt++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(this.cnt == this.length){
            return false;
        }
        this.array[tail] = value;
        this.tail++;
        this.tail = (this.tail + this.length) % this.length;
        this.cnt++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(this.cnt ==0)
            return false;
        this.head++;
        this.head = (this.head + this.length )% this.length;
        this.cnt--;
        return true;

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(this.cnt ==0)
            return false;
        this.tail--;
        this.tail = (this.tail + this.length) % this.length;
        this.cnt--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(this.cnt == 0)
            return -1;
        return this.array[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(this.cnt == 0)
            return -1;
      //  return this.array[(this.tail + this.length -1)%this.length];
        if(tail>0)
            return array[tail-1];
        else
            return array[length-1];

    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(this.cnt == 0){
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(this.cnt == length){
            return true;
        }
        return false;
    }

    //debug
    public int[] getArray() {
        return this.array;
    }
    public void getAll() {
        System.out.println("All :  cnt=" + this.cnt + " ,head=" + this.head + " ,tail=" + this.tail + " ,Array =" + Arrays.toString(this.array));
        System.out.println();
    }
}
