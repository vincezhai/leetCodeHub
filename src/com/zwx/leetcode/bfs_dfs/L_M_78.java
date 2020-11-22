package com.zwx.leetcode.bfs_dfs;

import java.util.ArrayList;
import java.util.List;

public class L_M_78 {
    public static void main(String[] args) {
        int[] num = {1,2,3,4};
        subsets(num);

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums,res,list,0);
        return res;

    }

    public static void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int pos){
        res.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums,res,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
