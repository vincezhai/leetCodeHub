package com.zwx.leetcode.practice;

import com.zwx.learn.array.Array;

import java.util.*;

public class L_M_1208 {
    public static void main(String[] args) {
        // init
        int[][] arr = { {1},{1,3},{2},{1,2},{3},{2,3},{1,2,3} ,{4},{1,4},{2,3},{4,3},{1,3,4}};
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> tmp =new ArrayList<>();
            for (int a : arr[i]) {
                tmp.add(a);
            }
            lists.add(tmp);
        }
        System.out.println("lists = " + lists);

        // start
        Comparator <List<Integer>> sizeCompare = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if( o1.size() > o2.size() ){
                    return 1;
                } else if( o1.size() < o2.size() ){
                    return -1;
                } else if(o1.size() == o2.size()){
                    return 0;
                }
                return 0;
            }
        };

        Comparator <List<Integer>> oneCompare = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if( o1.get(0) > o2.get(0) ){
                    return 1;
                } else if( o1.get(0) < o2.get(0) ){
                    return -1;
                } else if( o1.get(0) == o2.get(0) ){
                    return 0;
                }
                return 0;
            }
        };

        List<Comparator> compList = new ArrayList<>();
        compList.add(sizeCompare);
        compList.add(oneCompare);

        // sort
        Collections.sort(lists, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for( Comparator curr : compList  ){
                    if( curr.compare(o1,o2) > 0 ){
                        return 1;
                    } else if (curr.compare(o1,o2) < 0) {
                        return -1;
                    }
                }
                return 0;
            }
        });

        // sout
        for (List<Integer> tmp : lists) {
            System.out.println("list = " + tmp);
        }
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int res = 0;
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            max += Math.abs( s.charAt(right) - t.charAt(right));
            if(max > maxCost){
                max -= Math.abs( s.charAt(left) - t.charAt(left));
                left++;
            }
            res = Math.max(res,right - left + 1);
        }
        return res;
    }
}
