package com.zwx.leetcode.practice;

import com.zwx.learn.array.Array;
import com.zwx.leetcode.bfs_dfs.TreeNode;

import java.util.*;

public class Subset {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> subset =  subsets(a);
        System.out.println("subset = " + subset);
        List<List<Integer>> permute =  permute(a);
        System.out.println("permute = " + permute);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        subSetDfs (nums, lists,path,0);
        return lists;
    }
    private static void subSetDfs(int[] nums, List<List<Integer>> lists, List<Integer> path, int pos) {
        lists.add(new ArrayList<>(path));
        for (int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            subSetDfs(nums,lists,path,i+1);
            path.remove(path.size()-1);
        }
    }

    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        orderDfs(nums,lists,path,used);
        return lists;
    }

    private static void orderDfs(int[] nums, List<List<Integer>> lists, List<Integer> path, boolean[] used) {
        if(path.size() == nums.length){
            lists.add(new ArrayList<>(path) );
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                orderDfs(nums, lists, path, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            int num = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                 TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                tmp.add(node.val);
            }
            res.add(tmp);
        }
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        HashMap<Character,Integer> table = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            if(table.containsKey(s.charAt(right))){
                left = Math.max(left, table.get(s.charAt(right)) + 1);
            }
            table.put(s.charAt(right),right);
            max = Math.max(max,right - left + 1);
        }
        return max;
    }


}
