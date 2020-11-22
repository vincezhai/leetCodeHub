package com.zwx.leetcode.tree;

public class BinarySortTree {
    Node root;
    public void add(Node node){
        if(root == null){
            root = node;
        } else {
            root.add(node);
        }
    }

    public void middle(){
        if(root != null){
            root.middle();
            System.out.println();
        }
    }

    public void front(){
        if(root != null){
            root.front();
            System.out.println();
        }
    }

    public void back(){
        if(root != null){
            root.back();
            System.out.println();
        }
    }

    public Node search(int i){
        if(root == null){
            return null;
        }
        return root.search(i);
    }

    public Node searchParent(int i){
        if(root == null){
            return null;
        }
        return root.searchParent(i);
    }

    public void delete(int value){
        if(root == null){
            return;
        } else {
            Node target = search(value);
            if(target == null){
                return;
            }
            Node parent = searchParent(value);
            // 删除节点为叶子节点
            if(target.right == null && target.left == null){
                if(parent.left.val == value){
                    parent.left = null;
                }
                if(parent.right.val == value){
                    parent.right = null;
                }
            }
            // 删除的节点只有一个左子节点
            if(target.left!= null && target.right == null){
                if(parent.left.val == value){
                    parent.left = target.left;
                }
                if(parent.right.val == value){
                    parent.right = target.left;
                }
            }
            // 删除的节点只有一个右子节点
            if(target.right!= null && target.left == null){
                if(parent.left.val == value){
                    parent.left = target.right;
                }
                if(parent.right.val == value){
                    parent.right = target.right;
                }
            }
            // 删除节点有两个节点
            if(target.right!= null && target.left != null){
                int min = deleteMin(target.right);
                target.val = min;
            }


        }
    }

    public int deleteMin(Node node){
        Node target = node;
        while (target.left != null){
            target = target.left;
        }
        delete(target.val);
        return target.val;
    }


}
