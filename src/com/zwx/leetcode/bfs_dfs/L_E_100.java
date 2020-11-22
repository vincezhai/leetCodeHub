package com.zwx.leetcode.bfs_dfs;

public class L_E_100 {
    public static void main(String[] args) {

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p != null && q == null){
            return false;
        }
        if(q != null && p == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        } else {
            return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
        }
    }
}
