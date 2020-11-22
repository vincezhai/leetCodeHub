package com.zwx.leetcode.practice;

import com.zwx.learn.array.Array;

import java.util.*;

public class Zzz {
    public static void main(String[] args) {
       int[][] arr = {{1,2},{2,5},{3,6}};
       List<List<int[]>> lists = new ArrayList<>();
       List<int[]> path = new ArrayList<>();
       boolean[] used = new boolean[arr.length];
       dfs(arr,lists,path,used);
       int[][] res = new int[arr.length][2];
        for (List<int[]> curr : lists) {
            if( isRight(curr) ){
                res = curr.toArray(new int[arr.length][2]);
            }

            for (int[] array : curr) {
                System.out.print(Arrays.toString(array) + "  ");
            }
            System.out.println("\n---");
        }
       /* int[][] test = {{5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}};
        List<int[]> tst = new ArrayList<>();
        for (int i = 0; i < test.length; i++) {
            tst.add(test[i]);
        }
        System.out.println("isRight(test) = " + isRight(tst));*/
    }

    private static boolean isRight(List<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            int cnt = 0;
            int[] curr = list.get(i);
            for (int j = 0; j < i; j++) {
                if(list.get(j)[0] >= curr[0]){
                    cnt++;
                }
            }
            if(cnt != curr[1]){
                return false;
            }
        }
        return true;
    }

    private static void dfs(int[][] arr, List<List<int[]>> lists, List<int[]> path, boolean[] used) {
        if(path.size() == arr.length){
            lists.add( new ArrayList<>(path) );
        }
        for (int i = 0; i < arr.length; i++) {
            if(!used[i]){
                path.add(arr[i]);
                used[i] = true;
                dfs(arr,lists,path,used);
                used[i] = false;
                path.remove( path.size() -1 );
            }
        }
    }
}
