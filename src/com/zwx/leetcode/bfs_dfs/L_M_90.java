package com.zwx.leetcode.bfs_dfs;

import com.zwx.learn.array.Array;

import javax.jnlp.ClipboardService;
import java.util.*;

public class L_M_90 {
    public static void main(String[] args) {
        int[] a = {1,2,2};
        List<List<Integer>> res = subsetsWithDup(a);
        for(List<Integer> tmp : res){
            System.out.println("tmp = " + tmp);
        }

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res,path,nums,0);
        return res;
    }

    public static void dfs(List<List<Integer>> res,List<Integer> path,int[] nums,int pos){
        res.add(new ArrayList<>(path));
        for (int i = pos; i < nums.length; i++) {
            if(i>pos && (nums[i] == nums[i-1])){
                continue;
            }
            path.add(nums[i]);
            dfs(res,path,nums,i +1 );
            path.remove(path.size() - 1);
        }
    }
}
