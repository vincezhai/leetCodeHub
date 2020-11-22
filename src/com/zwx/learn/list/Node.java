package com.zwx.learn.list;

public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node append(Node node){
        Node currentNode = this;
        while(true){
            Node n = currentNode.getnext();
            if(n == null){
                currentNode.next =node;
                break;
            }
            currentNode = n;
        }
        return this;
    }


    public Node getnext(){
        return this.next;
    }

}
