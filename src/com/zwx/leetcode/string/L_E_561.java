package com.zwx.leetcode.string;

import java.util.*;

public class L_E_561 {
    public static void main(String[] args) {
        int[] a = {1,5,4,6,7,1,6,9};
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("arrayPairSum(a) = " + arrayPairSumv2(a));
      //  System.out.println("a = " + Arrays.toString(a));
    }

    // 冒泡，慢
    public static int arrayPairSum (int[] nums) {
        int res =0;
        for(int i = 0; i<nums.length;i++)
            for(int j=i;j<nums.length;j++)
            {
                if(nums[i]>nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        for (int i = 0; i <nums.length ; i+=2) {
            res += nums[i];
        }
        return res;
    }

    // Arrays.sort 快排
    public static int arrayPairSumv2 (int[] nums) {
        int res = 0;
       Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i+=2) {
            res += nums[i];
        }
        return res;
    }

}
