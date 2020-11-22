package com.zwx.leetcode.hashmap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class L_M_560 {
    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int k = 2;
        System.out.println("f(arr ,k) = " + f(arr, k));
    }

    //TODO
    public static int f(int[] nums, int k){
        int res = 0;
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length ; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++)
            for (int j = i; j < nums.length; j++) {
                //System.out.println("---: " + (preSum[j+1] - preSum[i]));
                if(preSum[j+1] - preSum[i] == k)
                    res++;
            }

        return res;
    }
}
