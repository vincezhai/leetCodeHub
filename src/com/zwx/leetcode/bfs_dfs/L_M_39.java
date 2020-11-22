package com.zwx.leetcode.bfs_dfs;

import com.zwx.learn.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_M_39 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res,path,candidates,target,0);
        return res;
    }

    public static void dfs(List<List<Integer>> res,List<Integer> path,int[] nums, int target, int pos){
       if( 0 == target){
           res.add(new ArrayList<>(path));
       }
       if(target<0){
           return;
       }
        for (int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(res,path,nums,target - nums[i],i+1);
            path.remove(path.size() - 1);
        }
    }
}
