package com.zwx.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L_M_978 {
    public static void main(String[] args) {
        int[] arr = {0,1,1,0,1,0,1,1,0,0};
        //int[] arr = {9,4,2,10,7,8,8,1,9};
        //int[] arr = {4,8,12,16};
        //int[] arr = {9,9};
        int res = maxTurbulenceSize(arr);
        System.out.println("res = " + res);
    }

    @Deprecated
    public static int maxTurbulenceSize(int[] arr) {
        int max = 0;
        if(arr.length == 0){
            return max;
        }
        if(arr.length == 1){
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < arr.length - 1; right++) {
            if(arr[right] == arr[right+1]){
                if(!list.isEmpty()){
                    list.remove(0);
                }
                max = Math.max(max,right - left + 1);
                left = right+1;
                continue;
            }
            //
            if( !calcuStatus(arr,list,right)){
                if(!list.isEmpty()){
                    list.remove(0);
                }
                //left = right+1;
                left++;
            }
            max = Math.max(max,right - left + 1);
        }
        return max;
    }

    public static boolean calcuStatus(int[] arr, List<Integer> list, int right){
        int curr = 2;
        if(arr[right] > arr[right + 1]){
            curr = 1;
        }
        if(arr[right] < arr[right + 1]){
            curr = -1;
        }
        if(list.isEmpty()){
            list.add(curr);
            return true;
        }

        if( list.get(list.size() - 1) == -curr){
            list.add(curr);
            return true;
        } else {
            return false;
        }
    }
}
