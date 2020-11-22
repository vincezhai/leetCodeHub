package com.zwx.leetcode.twoPoint;

import com.zwx.learn.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_M_15 {
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        System.out.println("f(a) = " + f(a));
    }

    public static List<List<Integer>> f(int[] nums){
        Arrays.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));
        List<List<Integer>> res = new ArrayList<>();
        int[] input = new int[nums.length - 1];
        for (int i = 0; i < nums.length ; i++) {
            for(int j = 0;j<input.length;j++)
            {
                if(j<i){
                    input[j] = nums[j];
                } else {
                    input[j] = nums[j+1];
                }
            }
            System.out.println("input = " + Arrays.toString(input));
            List<List<Integer>> one = twoSum(input,-nums[i]);
            res.addAll(one);
        }
        return res;
    }

    public static List<List<Integer>> twoSum(int[] arr,int k){
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0,j =arr.length -1;i<j;i++,j--){
            if(arr[i] + arr[j] == k){
                List<Integer> one = new ArrayList<>();
                one.add(arr[i]);
                one.add(arr[j]);
                one.add(-k);
                list.add(one);
            } else if(arr[i] + arr[j] < k){
                i++;
            }else if(arr[i] + arr[j] > k){
                j--;
            }
        }
        return list;
    }
}
