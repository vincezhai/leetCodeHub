package com.zwx.leetcode.list;
import com.zwx.leetcode.myUtils.ListNode;

import java.util.List;

public class L_E_206 {
    public static void main(String[] args) {
        // init and sout
        int[] arr = {1,2,5,6,7};
        ListNode node = new ListNode(arr);
        System.out.println(node.toString());
        System.out.println("-------------- start func --------------");

        //start ...
        System.out.println(" res : " + f(node).toString());
    }

    public static ListNode f(ListNode head){
        ListNode current = head;
        ListNode previous = null;
        while (current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
