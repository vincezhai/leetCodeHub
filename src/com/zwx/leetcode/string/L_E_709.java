package com.zwx.leetcode.string;

public class L_E_709 {
    public static void main(String[] args) {
        String s = "ABCabc";
        System.out.println("f1(s) = " + f1(s));
        System.out.println("f2(s) = " + f2(s));
    }

    // 利用StringBuilder
    public static String  f2(String s){
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char tmp = sb.charAt(i);
            if(tmp > 64 && tmp < 91){
                tmp+=32;
                sb.setCharAt(i,tmp);
            }
        }
        return sb.toString();
    }

    public static String f1(String s){
        String res = "";
        for(char c : s.toCharArray()){
            if(c > 64 && c < 91){
                c += 32;
                res += c;
            }
            else {
                res += c;
            }
        }
        return res;
    }
}
