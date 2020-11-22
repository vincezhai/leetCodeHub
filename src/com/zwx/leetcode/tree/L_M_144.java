package com.zwx.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L_M_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            // 每次都会把遍历到的节点弹出数值（先序需要先给根节点数值）
            // 层层右左压栈，层层pop,每进一层都会输出val
            TreeNode n = stack.pop();
            res.add(n.val);
            //先进右，这样栈不会第一个弹出右节点
            if(n.right != null){
                stack.push(n.right);
            }
            // 进左子树
            if(n.left != null){
                stack.push(n.left);
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            // 记得每次push完要置空
            //使用peek，因为先取左，再去根，peek这样允许你先下探以下子节点，而存在返回根，
            TreeNode n = stack.peek();
            if(n.left != null){
                // 一直压到最左底
                stack.push(n.left);
                n.left = null;
            } else {
                // 开始弹出，而且如果一直没有右子树，就是从底弹回到顶部
                res.add(n.val);
                stack.pop();

                // 进入右树，看作它就是根节点，再来一次，
                // 其实和递归一样，只不过用栈处理递进关系
                if(n.right != null){
                    stack.push(n.right);
                    n.right = null;
                }
            }
        }
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode n = stack.peek();
            // 只有子树都没有，才轮到root
            if(n.left == null && n.right == null){
                res.add( stack.pop().val);
            } else {
                if(n.right != null){
                    stack.push(n.right);
                    n.right = null;
                }
                // 进左子树
                if(n.left != null){
                    stack.push(n.left);
                    n.left = null;
                }
            }
        }
        return res;

    }

}
