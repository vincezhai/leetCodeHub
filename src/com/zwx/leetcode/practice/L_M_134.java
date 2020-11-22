package com.zwx.leetcode.practice;

import com.zwx.learn.array.Array;

import java.util.Arrays;

public class L_M_134 {
    public static void main(String[] args) {
        int[] gas = {3,3,4};
        int[] cost = {3,4,4};
        int res = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            res = canCompleteCircuit0(gas,cost);
        }
        System.out.println("cost times : " + (System.currentTimeMillis() -start));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // init

        int length = gas.length;
        int[] gas_copy = new int[gas.length * 2];
        int[] cost_copy = new int[gas.length * 2];
        for (int i = 0; i < gas.length; i++) {
            gas_copy[i] = gas[i];
            gas_copy[i+length] = gas[i];
            cost_copy[i] = cost[i];
            cost_copy[i+length] = cost[i];
        }
        int left = 0;
        int currGas = 0;
        int tst = 0;
        for (int right = 0; right < 2*length; right++) {
            if(right - left == length && currGas >= 0){
                return left;
            }
            if(currGas < 0 ){
                left = right;
                currGas = 0;
            }
            currGas += gas_copy[right];
            currGas -= cost_copy[right];
            tst++;
        }
        //System.out.println("tst = " + tst);
        return -1;
    }

    public static int canCompleteCircuit0(int[] gas, int[] cost) {
        int length = gas.length;
        int left = 0;
        int currGas = 0;
        int cnt = 0;
        int tst = 0;
        for (int right = 0; left < length; right++) {
            right = (right + length) %length;
            if( cnt == length && currGas >= 0){
                return left;
            }
            if(currGas < 0 ){
                left++;
                if(left == length){
                    break;
                }
                right = left;
                currGas = 0;
                cnt = 0;
            }
            currGas += gas[right];
            currGas -= cost[right];
            cnt++;
            tst++;
        }
        return -1;
    }
}
