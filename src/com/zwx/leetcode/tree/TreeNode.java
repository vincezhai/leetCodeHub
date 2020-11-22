package com.zwx.leetcode.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { this.val = x; }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void front(){
        System.out.print(val + " ");
        if(left != null){
            left.front();
        }
        if(right != null){
            right.front();
        }
    }

    public void middle(){
        if(left != null){
            left.middle();
        }
        System.out.print(val + " ");
        if(right != null){
            right.middle();
        }
    }

    public void back(){
        if(left != null){
            left.back();
        }
        if(right != null){
            right.back();
        }
        System.out.print(val + " ");
    }

    public TreeNode frontSearch(int i){
        TreeNode res = null;
        // curr
        if(this.val == i){
            return this;
        } else {
            // left
            if(this.left != null){
                res = left.frontSearch(i);
            }
            if(res != null){
                return res;
            }
            // right
            if(this.right != null){
                res = right.frontSearch(i);
            }
        }
        return res;
    }

    public void delete(int i ){
        TreeNode parent = this;
        if(parent.left != null  && parent.left.val == i){
            parent.left = null;
            return;
        }
        if( parent.right != null && parent.right.val == i){
            parent.right = null;
            return;
        }
        // 都不是
        parent = left;
        if(parent != null){
            parent.delete(i);
        }
        parent = right;
        if(parent != null){
            parent.delete(i);
        }



    }


}
