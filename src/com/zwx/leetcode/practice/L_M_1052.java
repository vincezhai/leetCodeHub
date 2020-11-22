package com.zwx.leetcode.practice;

import com.zwx.learn.array.Array;

import java.util.Arrays;
import java.util.HashMap;

public class L_M_1052 {
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int x = 3;
        int res = maxSatisfied(customers,grumpy,x);
        System.out.println("res = " + res);

        // perSum
        int[] perSum = new int[customers.length + 1];
        perSum[0] = 0;
        for (int i = 0; i < customers.length; i++) {
            perSum[i + 1] = perSum[i] + customers[i];
        }
        // 验证
        System.out.println( Arrays.toString(perSum));
        for (int i = 0; i <  customers.length; i++) {
            System.out.println( " org = " + customers[i] + "; preSum = "+ (perSum[i+1] - perSum[i]) );
        }
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int x) {
        int max = 0;
        int left = 0;
        int right = 0;
        int winSum = 0;
        int winX = 0;
        int normalTotal = 0;
        for (; right < x; right++) {
            if(grumpy[right] == 0){
                winSum += customers[right];
                normalTotal += customers[right];
            }
            winX += customers[right];
            max = Math.max(max,winX - winSum);
        }
        for (right = x; right < customers.length; right++) {
            if(grumpy[left] == 0){
                winSum -= customers[left];
            }
            winX -= customers[left];
            left++;
            if(grumpy[right] == 0){
                normalTotal += customers[right];
                winSum += customers[right];
            }
            winX += customers[right];
            max = Math.max(max,winX - winSum);
        }
        return max + normalTotal;
    }
}
