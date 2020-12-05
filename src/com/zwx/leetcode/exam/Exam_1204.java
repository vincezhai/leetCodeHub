/*
给定一个一维数组tasks，对任务进行连续分组，二维数组代表相互不能在一个组。请返回最多可以分多少个组。

示例:
int[] tasks = {0, 1, 2, 3, 4, 5};
int[][] mutexPairs = {{1, 3}, {3, 5}};
输出:3
解答 0 1 2 、3 4、 5 共三个组

int[] tasks2 = {1, 3, 2, 4, 6, 5, 0};
int[][] mutexPairs2 = {{1, 3}, {4, 5}};
输出:3

int[] tasks3 = {1, 4, 2, 3, 0};
int[][] mutexPairs3 = {};
输出:1
*/
package com.zwx.leetcode.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Exam_1204 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        int[] tasks = {0, 1, 2, 3, 4, 5};
        int[][] mutexPairs = {{1, 3}, {3, 5}};
        int res = func(tasks,mutexPairs);
        System.out.println("test01 = " + res);
    }
    private static void test2() {
        int[] tasks = {1, 3, 2, 4, 6, 5, 0};
        int[][] mutexPairs = {{1, 3}, {4, 5}};
        int res = func(tasks,mutexPairs);
        System.out.println("test02 = " + res);

    }
    private static void test3() {
        int[] tasks = {1, 4, 2, 3, 0};
        int[][] mutexPairs = {};
        int res = func(tasks,mutexPairs);
        System.out.println("test03 = " + res);
    }

    public static int func(int[] tasks, int[][]mutexPairs){
        int res = 1;
        if(mutexPairs == null || mutexPairs.length == 0){
            return res;
        }
        // 预处理
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        prepare(map,mutexPairs);
        // 遍历
        HashSet<Integer> set = new HashSet();
        for (int right = 0; right < tasks.length; right++) {
            if(set.contains(tasks[right])){
                res++;
                set = new HashSet<>();
            }
            if(map.containsKey(tasks[right])){
                List<Integer> tmpList = map.get(tasks[right]);
                for(Integer curr : tmpList){
                    set.add(curr);
                }
            }
        }
        return res;
    }

    // 预处理方法
    private static void prepare(HashMap<Integer, List<Integer>> map, int[][]mutexPairs) {
        for (int i = 0; i < mutexPairs.length; i++) {
            if(map.containsKey(mutexPairs[i][0])){
                List<Integer> tmp = map.get(mutexPairs[i][0]);
                tmp.add(mutexPairs[i][1]);
                map.put(mutexPairs[i][0],tmp);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(mutexPairs[i][1]);
                map.put(mutexPairs[i][0],tmp);
            }
            // 倒叙来一次
            if(map.containsKey(mutexPairs[i][1])){
                List<Integer> tmp = map.get(mutexPairs[i][1]);
                tmp.add(mutexPairs[i][0]);
                map.put(mutexPairs[i][1],tmp);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(mutexPairs[i][0]);
                map.put(mutexPairs[i][1],tmp);
            }
        }
    }
}