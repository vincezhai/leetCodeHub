package com.zwx.leetcode.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class L_E_559 {

    public static void main(String[] args) {

    }

    public static int maxDepth(Node root) {
        int res = 0;
        if(root == null){
            return res;
        }
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                Node node = queue.poll();
                if(node.children != null){
                    for (int j = 0; j < node.children.size(); j++) {
                        queue.offer(node.children.get(j));
                    }
                }
            }
            res++;
        }
        return res;
    }
}
