package com.zwx.leetcode.bfs_dfs;

import com.zwx.learn.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_M_47 {
    public static void main(String[] args) {

    }

    public static  List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used,false);
        dfs(res,path,nums,0,used);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int pos,boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i] || ( i> 0 &&(nums[i] == nums[i-1]) && !used[i-1] )){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(res,path,nums,i+1,used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
