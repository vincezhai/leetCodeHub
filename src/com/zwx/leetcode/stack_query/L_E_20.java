package com.zwx.leetcode.stack_query;

import java.util.Stack;

public class L_E_20 {
    public static void main(String[] args) {

        String s = "()";
        /*
        for(char ch : s.toCharArray()){
            int index = ch;
            System.out.println( ch +  " = " + index);
        }
        */
        System.out.println("f(s) = " + f(s));
    }

    public static boolean f(String s){
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for(char ch : array){
            //为方便匹配，做预处理
            int delta = 2;
            if( ch == '(' || ch == ')'){
                delta = 1;
            }
            // null -> push
            if(stack.isEmpty()){
                stack.push(ch);
            } else {
                if( ch == ( stack.peek() + delta ) ){
                    //match
                    stack.pop();
                } else {
                    // not match
                    stack.push(ch);
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
