package com.zwx.leetcode.stack_query;

import com.zwx.learn.array.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MainTest {
    public static void main(String[] args) {
       //stack

       //循环队列
       MyCircularQueue circularQueue = new MyCircularQueue(3);
       //circularQueue(circularQueue);

       //双端循环队列
       MyCircularDeque myCircularDeque = new MyCircularDeque(3);
       //circulardeueue(myCircularDeque);

       //queue
        MyQueue queue = new MyQueue();
        queue(queue);

    }

    public static void queue(MyQueue myQueue){
        myQueue.push(1);
        myQueue.getStack();
        // queue is: [1]

        myQueue.push(2);
        myQueue.getStack();
        // queue is: [1, 2] (leftmost is front of the queue)

        myQueue.push(3);
        myQueue.getStack();

        System.out.println("myQueue.peek() = " + myQueue.peek());
        // return 1

        System.out.println("myQueue.pop() = " + myQueue.pop());
        // return 1, queue is [2]

        System.out.println("myQueue.empty() = " + myQueue.empty());
        // return false
    }

    public static void circularQueue(MyCircularQueue circularQueue) {
        System.out.println("circularQueue.enQueue(1) = " + circularQueue.enQueue(1));
        // 返回 true
        System.out.println("circularQueue.enQueue(2) = " + circularQueue.enQueue(2));
        // 返回 true
        System.out.println("circularQueue.enQueue(3) = " + circularQueue.enQueue(3));
        // 返回 true
        System.out.println("circularQueue.enQueue(4) = " + circularQueue.enQueue(4));
        // 返回 false，队列已满
        System.out.println("circularQueue.Rear() = " + circularQueue.Rear());
        // 返回 3
        System.out.println("circularQueue.isFull() = " + circularQueue.isFull());
        // 返回 true
        System.out.println("circularQueue.deQueue() = " + circularQueue.deQueue());
        // 返回 true
        System.out.println("circularQueue.enQueue(4) = " + circularQueue.enQueue(4));
        // 返回 true
        System.out.println("circularQueue.Rear() = " + circularQueue.Rear());
        // 返回 4
    }

    public static void circulardeueue(MyCircularDeque circularDeque) {

        System.out.println("circularDeque.insertLast(1) = " + circularDeque.insertLast(1));
        circularDeque.getAll();
        // 返回 true

        System.out.println("circularDeque.insertLast(2) = " + circularDeque.insertLast(2));
        circularDeque.getAll();
        // 返回 true

        System.out.println("circularDeque.insertFront(3) = " + circularDeque.insertFront(3));
        circularDeque.getAll();
        // 返回 true

        System.out.println("circularDeque.insertFront(4) = " + circularDeque.insertFront(4));
        circularDeque.getAll();
        // 已经满了，返回 false

        System.out.println("circularDeque.getRear() = " + circularDeque.getRear());
        circularDeque.getAll();
        // 返回 2

        System.out.println("circularDeque.isFull() = " + circularDeque.isFull());
        circularDeque.getAll();
        // 返回 true

        System.out.println("circularDeque.deleteLast() = " + circularDeque.deleteLast());
        circularDeque.getAll();
        // 返回 true

        System.out.println("circularDeque.insertFront(4) = " + circularDeque.insertFront(4));
        circularDeque.getAll();
        // 返回 true

        System.out.println("circularDeque.getFront() = " + circularDeque.getFront());
        circularDeque.getAll();
        // 返回 4
    }

}
