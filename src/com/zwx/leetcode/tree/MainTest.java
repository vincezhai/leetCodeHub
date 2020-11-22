package com.zwx.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        // 普通二叉树
        //binaryTreeTest();

        // BST，搜索二叉树
        bst();



    }

    public static void bst(){

        BinarySortTree bst = new BinarySortTree();
        //int[] arr = new int[] {7,3,10,8,12,5,1,9};
        int[] arr = new int[] {1,2,3,4,5,6,7,8};
        //int[] arr = new int[] {8,9,6,7,5,4};
        for (int i = 0; i <arr.length ; i++) {
            bst.add(new Node(arr[i]));
        }
        System.out.println("middle");
        bst.middle();
        System.out.println("front");
        bst.front();
        System.out.println("back");
        bst.back();

        // 查找
        Node node =  bst.search(8);
        System.out.println("node.val = " + node.val);

        // 查找父节点
        Node n =  bst.searchParent(8);
        System.out.println("n.val = " + n.val);

        //删除节点
        //bst.delete(5);
        bst.middle();
        System.out.println("bst.root.height() = " + bst.root.height());
        System.out.println("bst.root.val = " + bst.root.val);


    }

    public static void binaryTreeTest(){
        BinaryTree binaryTree = new BinaryTree();

        // level one
        TreeNode root = new TreeNode(1);
        binaryTree.setRoot(root);

        // level two
        TreeNode rootL = new TreeNode(2);
        TreeNode rootR = new TreeNode(3);
        root.setLeft(rootL);
        root.setRight(rootR);

        // level three
        rootL.setLeft(new TreeNode(4));
        rootL.setRight(new TreeNode(5));
        rootR.setLeft(new TreeNode(6));
        rootR.setRight(new TreeNode(7));

        // 遍历
        System.out.println("front");
        binaryTree.front();
        System.out.println();

        System.out.println("middle");
        binaryTree.middle();
        System.out.println();

        System.out.println("back");
        binaryTree.back();
        System.out.println();

        // 查找
        System.out.println();
        System.out.println(" start Search ");
        TreeNode test =  binaryTree.frontSearch(2);
        System.out.println("test.val = " + test.val);
        System.out.println("test.left.val = " + test.left.val);
        System.out.println("test.right.val = " + test.right.val);

        // 删除
        System.out.println();
        System.out.println(" start delete");
        binaryTree.front();
        System.out.println();
        binaryTree.delete(1);
        binaryTree.front();
    }
}
