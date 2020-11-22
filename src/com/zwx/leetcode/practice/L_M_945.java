package com.zwx.leetcode.practice;

import com.zwx.learn.array.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class L_M_945 {
    public static void main(String[] args) {
        int[] a = {3,2,1,2,1,7};
        //int[] a = {1,2,2};
        int res = minIncrementForUnique(a);
        System.out.println("res = " + res);
    }

    public static int minIncrementForUnique(int[] array) {
        if (array == null || array.length == 1){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int num : array){
            while (map.containsKey(num)){
                num++;
                res++;
            }
            map.put(num,1);
        }
        return res;
    }

}
