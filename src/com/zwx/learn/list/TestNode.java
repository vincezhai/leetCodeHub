package com.zwx.learn.list;

public class TestNode {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.append(n2);
        n1.append(n3);
        System.out.println("n1.getnext().getnext().data = " + n1.getnext().getnext().data);

        System.out.println("n1.getnext().getnext().data = " + n1.getnext().getnext().data);
    }
}
