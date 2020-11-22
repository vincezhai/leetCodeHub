package com.zwx.leetcode.bfs_dfs;

import java.util.ArrayList;
import java.util.List;

public class L_M_46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permute(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int leng = nums.length;
        if(nums == null){
            return res;
        }
        boolean[] used = new boolean[leng];
        List<Integer> path = new ArrayList<>();
        dfs(nums,res,path,used,0);
        return res;
    }

    public static void dfs(int[] nums,List<List<Integer>> res, List<Integer> path, boolean[] used, int pos){
       if(pos == nums.length){
           res.add(new ArrayList<>(path));
       }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,res,path,used,pos+1);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }

}
