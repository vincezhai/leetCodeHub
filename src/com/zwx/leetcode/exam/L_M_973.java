package com.zwx.leetcode.exam;

import com.zwx.learn.array.Array;

import javax.jnlp.ClipboardService;
import java.util.*;
import java.util.stream.Collectors;

public class L_M_973 {
    public static void main(String[] args) {
        //int[][] a = {{1,3},{-2,2},{3,4}};
        //int k = 1;
        int[][] a = {{5,-1},{-2,4},{2,-4}};
        int k = 2;
        //int[][] res =  f(a, k);
        int[][] res =  f1(a, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

    }

    public static int[][] f1(int[][] points, int k) {
        int[] array = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int length =  points[i][0]*points[i][0] + points[i][1]*points[i][1];
            array[i] = length;
        }
        Arrays.sort(array);
        int max = array[k-1];
        int index = 0;
        int[][] res = new int[k][2];
        for (int i = 0; i < points.length; i++) {
            if( points[i][0]*points[i][0] + points[i][1]*points[i][1] <= max){
                res[index] = points[i];
                index++;
            }
        }
        return res;
    }


    public static int[][] f(int[][] points, int k){
        //建立匹配
        HashMap< List<Integer>,Integer> map = new HashMap<>();
        int[] allLength = new int[points.length];
        for (int i = 0; i < points.length; i++) {
                int length =  points[i][0]*points[i][0] + points[i][1]*points[i][1];
                allLength[i] = length;
                List<Integer> list = new ArrayList<>();
                list.add(points[i][0]);
                list.add(points[i][1]);
                map.put(list,length);
        }
        System.out.println("map = " + map);
        //排序
        Arrays.sort( allLength);
        //输出倒数k个数
        int[][] res = new int[k][2];
        int cnt = 0;
        for (int i = 0; i < k ; i++) {
            int length = allLength[i];
            for (Map.Entry entry : map.entrySet()){
                int val =(int)entry.getValue();
                if(val == length){
                    List<Integer> tmplist = (List<Integer>) entry.getKey();
                    int[] tmp = {tmplist.get(0),tmplist.get(1)};
                    res[i] = tmp;
                    cnt++;
                    if(cnt > k){
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
