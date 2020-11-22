package com.zwx.leetcode.array;

import com.zwx.learn.array.Array;

import java.util.Arrays;
import java.util.Stack;

public class L_E_1550 {
    public static void main(String[] args) {
        int[] arr ={2,6,4,1};
        System.out.println(Arrays.toString(arr));
        System.out.println("f1(arr) = " + f1(arr));
    }

    public static boolean f1(int[] arr){
        boolean tmp = false;
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] % 2 != 0))
                s += "1";
            else
                s += "0";
        }
        System.out.println("s = " + s);
        if(s.contains("111"))
            return true;
        else
            return false;
    }

}


