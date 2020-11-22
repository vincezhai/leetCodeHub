package com.zwx.leetcode.array;

import com.zwx.learn.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_E_1450 {
    public static void main(String[] args) {
        int[] startTime = {1,2,3};
        int[] endTime = {3,2,7};
        int queryTime = 4;
        System.out.println("f1() = " + f1(startTime,endTime,queryTime));

        // 905
        int[] a ={3,1,2,4};
        System.out.println("f2() = " + Arrays.toString( f2(a)) );

    }


    public static int[] f2(int[] a) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if(a[i]%2 != 0){
                odd.add(a[i]);
            } else {
                even.add(a[i]);
            }
        }
        int[] res = new int[a.length];
        for (int i = 0; i < even.size(); i++) {
            res[i] = even.get(i);
        }
        for (int i = even.size(); i < a.length; i++) {
            res[i] = odd.get(i-even.size());
        }
        return res;

    }

    public static int f1(int[] startTime, int[] endTime, int queryTime){
        int cnt =0;
        try{
            if(startTime.length == endTime.length)
                for (int i = 0; i < startTime.length; i++) {
                    if(queryTime>= startTime[i] && queryTime <=endTime[i])
                       cnt++;
                }
        }
        catch (Exception e){
            System.out.println(" error ：长度不相同");
        }
        return cnt;


    }
}
