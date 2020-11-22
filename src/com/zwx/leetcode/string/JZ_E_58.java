package com.zwx.leetcode.string;

public class JZ_E_58 {

    public static void main(String[] args) {
        String s = "123456";
        System.out.println("f1(s,2) = " + f1(s, 2));
        System.out.println("f2(s,2) = " + f2(s, 2));
        System.out.println("f3(s,2) = " + f3(s, 2));
    }

    public static String f1(String input,int num){
        String res = input.substring(0,num);
        String res1 = input.substring(num,input.length());

        return res1+res;
    }

    public static String f2(String input,int num){
        return  (input + input.substring(0,num)).substring(num,input.length()+num);
    }

    public static String f3(String input,int num){
        int l = input.length();
        StringBuilder str = new StringBuilder();
        for (int i = num; i < l ; i++) {
            str.append(input.charAt(i));
        }
        for (int i = 0; i < num ; i++) {
            str.append(input.charAt(i));
        }
        return str.toString();
    }
}
// 123456
// 345612