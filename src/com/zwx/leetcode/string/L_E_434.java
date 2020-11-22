package com.zwx.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class L_E_434 {
    public static void main(String[] args) {
        String s = ", , , , a, eaefa";
        System.out.println("f1(s) = " + f1(s));
    }



    public static int f1(String s){
        s = s.trim();
        List<String> list = new ArrayList<>();
        String[] array= s.split(" ");
        for(String str : array){
            if(!str.isEmpty()){
                list.add(str);
            }
        }
        return list.size();
    }
}
