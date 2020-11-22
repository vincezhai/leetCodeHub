package com.zwx.leetcode.practice;

import org.omg.CORBA.INTERNAL;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L_M_402 {
    public static void main(String[] args) {
        System.out.println( removeKdigits("1432219",3) );
    }

    public static String removeKdigits(String num, int k) {
        String res = "";
        Stack<Character> stack = new Stack<>();
        for(char ch : num.toCharArray()){
            stack.push(ch);
            res += ch;
            if( ch - '0' > stack.peek() - '0' ) {
                stack.pop();
                res = res.substring(0,res.length() - 1);
                if (k-- == 0) {
                    break;
                }
            }
        }
        return res;
    }
}
