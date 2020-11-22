package com.zwx.leetcode.string;

import java.util.Arrays;
import java.util.Stack;

public class JZ_E_58I {
    public static void main(String[] args) {
        String s = " hello world! ";
        System.out.println("f1(s) = " + f1(s));
        System.out.println("f2(s) = " + f2(s));

    }

    //双指针
    public static  String  f2(String s){
        String res = new String();
        s = s.trim();
        StringBuilder sb = new StringBuilder(s);
        int i = sb.length()-1,j = i;
        while (i>=0){
            while(i>=0 && sb.charAt(i) != ' ')
                i--;
            res += s.substring(i+1,j+1) + " ";
            while(i>=0 && sb.charAt(i) == ' ')
                i--;
            j = i;
        }
        return res;
    }

    public static String f1(String s){
        s = s.trim();
        String res = new String();
        Stack<String> stack = new Stack<String>();
        String[] array = s.split(" ");
        for(String str : array){
            if(!str.isEmpty())
                stack.push(str);
        }
        while (!stack.isEmpty()){
            res += (stack.pop()+" ");
        }
        if(res.isEmpty())
            return "";
        else
            return res.substring(0,res.length()-1);
    }
}
