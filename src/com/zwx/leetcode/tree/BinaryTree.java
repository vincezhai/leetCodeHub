package com.zwx.leetcode.tree;

public class BinaryTree {
    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void front(){
        if(root != null){
            root.front();
        }
    }

    public void middle(){
        if(root != null){
            root.middle();
        }
    }

    public void back(){
        if(root != null){
            root.back();
        }
    }

    public TreeNode frontSearch(int i ){
        return root.frontSearch(i);
    }

    public void delete(int i){
        if(root.val == i){
            root =null;
        }else {
            root.delete(i);
        }
    }


}
