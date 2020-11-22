package com.zwx.leetcode.list;

import com.zwx.leetcode.myUtils.ListNode;

import java.nio.file.LinkOption;

public class L_E_21 {
    public static void main(String[] args) {
        int[] a = {1,2,4};
        int[] b = {1,3,4};
        ListNode list1 = new ListNode(a);
        ListNode list2 = new ListNode(b);
        ListNode res =  f(list1,list2);
        System.out.println("res.toString() = " + res.toString());
    }

    public static ListNode f(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;

    }
}
