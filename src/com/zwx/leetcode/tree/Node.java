package com.zwx.leetcode.tree;

public class Node{
    int val;
    Node left;
    Node right;
    Node(){}
    Node(int x) { this.val = x; }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void add(Node node){
        if(node ==null){
            return;
        }
        if(node.val >= this.val){
            if(this.right == null){
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        if(node.val < this.val){
            if(this.left == null){
                this.left = node;
            } else {
                this.left.add(node);
            }
        }
        // 右旋转
        if( leftHeight() - rightHeight() >= 2){
            // 如果左比右高时，存在左数中的右边比左边高，就要先对左数左旋转，再整体右旋转
            if(left != null && (left.rightHeight() > left.leftHeight() )){
                left.leftRotate();
                rightRotate();
            } else {
                rightRotate();
            }

        }
        if(  rightHeight() - leftHeight() >= 2){
            if(right != null && (right.rightHeight() < right.leftHeight())){
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
        }
    }

    public void rightRotate(){
        // 1 新节点，值为当前节点的值
        Node node = new Node(val);
        // 2 新节点右数为当前的右树
        node.right = this.right;
        // 3 新节点右左数为当前的左树的右数
        node.left = left.right;
        // 4 当前节点的数值为左数的数值
        val = left.val;
        // 5 左数变成左数的左数，其实就是变相的干掉了自己
        left = left.left;
        // 6 右树变成新的树
        right = node;
    }

    public void leftRotate(){
        Node node = new Node(val);
        node.left = this.left;
        node.right = right.left;
        val = right.val;
        right = right.right;
        left = node;
    }

    public void middle(){
        if(this.left != null){
            this.left.middle();
        }
        System.out.print(this.val + " ");
        if(this.right != null){
            this.right.middle();
        }
    }

    public void front(){
        System.out.print(this.val + " ");
        if(this.left != null){
            this.left.front();
        }
        if(this.right != null){
            this.right.front();
        }
    }

    public void back(){
        if(this.left != null){
            this.left.back();
        }
        if(this.right != null){
            this.right.back();
        }
        System.out.print(this.val + " ");
    }

    public Node search(int i){
        if(this.val == i){
            return this;
        } else if(i < this.val ) {
            if(this.left == null){
                return null;
            }
            return this.left.search(i);
        } else if(i > this.val ) {
            if(this.right == null){
                return null;
            }
            return this.right.search(i);
        }
        return null;
    }

    public Node searchParent(int i){
        if( (this.left != null && this.left.val == i) || (this.right != null && this.right.val == i) ){
            return this;
        }  else {
            if (i < this.val && this.left != null) {
                return this.left.searchParent(i);
            } else if (i > this.val && this.right != null) {
                return this.right.searchParent(i);
            }
        }
        return null;
    }

    public int height(){
        return Math.max(left==null?0:this.left.height(),right==null?0:this.right.height()) + 1;
    }

    public int leftHeight(){
        if(left == null){
            return 0;
        } else{
            return left.height();
        }
    }

    public int rightHeight(){
        if(right == null){
            return 0;
        } else{
            return right.height();
        }
    }

}
