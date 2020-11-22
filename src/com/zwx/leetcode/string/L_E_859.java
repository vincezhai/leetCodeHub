package com.zwx.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class L_E_859 {
    public static void main(String[] args) {
        String a = "ab";
        String b = "ab";
        System.out.println("f1(a,b) = " + f1(a, b));
        System.out.println("f2(a,b) = " + f2(a, b));
    }



    //算了算了
    public static boolean f2(String a, String b){
        boolean bool = false;
        if(a.length() != b.length())
            return bool;

        if(a.equals(b))
        {
            for (int i = 0; i < a.length() - 1; i++) {
                if (a.indexOf(a.charAt(i), i + 1) != -1) {
                    return true;
                }
            }
            return false;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i))
                list.add(i);
        }

        if(list.size() !=2){
            return bool;
        }
        if(a.charAt(list.indexOf(0)) ==b.charAt(list.indexOf(1)) && a.charAt(list.indexOf(1)) ==b.charAt(list.indexOf(0)))
            bool = true;
        return bool;
    }

    //这个是连续相邻交换才可以，不适用本题
    public static boolean f1(String a, String b){
        boolean bool = false;
        if(a.length() != b.length())
            return bool;

        StringBuilder sb = new StringBuilder(a);
        for (int i = 0; i < a.length() -1 ; i++) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(i+1));
            sb.setCharAt(i+1,tmp);
            if(sb.toString().equals(b)){
                bool =true;
                break;
            }else {
                sb = new StringBuilder(a);
            }
        }
        return bool;
    }
}
