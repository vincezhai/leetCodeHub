package com.zwx.leetcode.bfs_dfs;

import java.util.ArrayList;
import java.util.List;

public class L_M_77 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> res = combine(n,k);
        for(List<Integer> tmp : res){
            System.out.println("tmp = " + tmp);
        }

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        dfs(res,path,nums,k,0);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int k, int pos ){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
        }
        for (int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(res,path,nums,k,i+1);
            path.remove(path.size() - 1);
        }
    }
}
