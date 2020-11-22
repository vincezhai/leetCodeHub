package com.zwx.leetcode.string;

import sun.security.krb5.internal.util.KrbDataOutputStream;

import java.util.Stack;

public class L_E_551 {
    public static void main(String[] args) {
        String s ="ALL";
        s.contains("LLL");
        System.out.println("f1(s) = " + f1(s));
    }

    public static boolean f1(String s){
        s+="P";
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int timesA =0;

        for (int i = 0; i < s.length(); i++) {
            if(array[i] == 'A')
                timesA++;
            if(array[i] == 'L')
                stack.push(array[i]);
            if(array[i] != 'L' && (stack.size()==1 || stack.size() ==2) ){
                int time = stack.size();
                for (int j = 0; j < time ; j++) {
                    stack.pop();
                }
            }
        }
        return timesA < 2 && stack.isEmpty();
    }
}
