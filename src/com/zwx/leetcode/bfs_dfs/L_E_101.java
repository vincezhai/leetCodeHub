package com.zwx.leetcode.bfs_dfs;

public class L_E_101 {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root,root);
    }

    public static boolean check(TreeNode n1,TreeNode n2){
        if(n1 == null && n2 == null){
            return true;
        }
        if(n1 == null || n2 == null){
            return false;
        }
        if(n1.val == n2.val){
            if(check(n1.left,n2.right) && check(n2.left,n1.right)){
                return true;
            } else {
                return false;
            }


        } else {
            return false;
        }
    }
}
