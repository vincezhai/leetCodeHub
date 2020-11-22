package com.zwx.leetcode.string;

import com.zwx.learn.array.Array;

import java.util.*;

public class L_E_1576 {
    public static void main(String[] args) {
        String s = "??yw?ipkj?";
        System.out.println("f1(s) = " + f1(s));
    }


    public static String f1(String s){
        StringBuilder sb = new StringBuilder(s);
        int length = s.length();
        if(length == 1){
            if(sb.charAt(0) == '?')
                sb.setCharAt(0,'a');
        }

        for (int i = 0; i < length; i++) {
            Stack<Character> stack = new Stack<>();
            stack.push('a');
            stack.push('b');
            stack.push('c');
            if(sb.charAt(i) == '?') {
                char left, right, tmp;
                // first
                if (i == 0) {
                    right = sb.charAt(i + 1);
                    if (right == 'a' || right =='?')
                        tmp = 'b';
                    else
                        tmp = (char) (right - 1);
                    sb.setCharAt(i, tmp);
                }

                // last
                if (i == length - 1) {
                    left = sb.charAt(i - 1);
                    if (left == 'a' || left == '?')
                        tmp = 'b';
                    else
                        tmp = (char) (left - 1);
                    sb.setCharAt(i, tmp);
                }

                // middle
                if (i > 0 && i < length -1){
                    right = sb.charAt(i + 1);
                    left = sb.charAt(i - 1);
                    for (int j = 0; j < 2; j++) {
                        char ch = stack.peek();
                        if (ch == right || ch == left)
                            stack.pop();
                    }
                    tmp = stack.peek();
                    sb.setCharAt(i, tmp);
                }
            }

        }
        return sb.toString();
    }
}
