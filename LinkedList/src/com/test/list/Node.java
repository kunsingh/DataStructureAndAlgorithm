package com.test.list;

public class Node {

    int info;
    Node next;

    public Node(int info) {
        this.info = info;
    }

    public void displayNode() {
        System.out.print("[" + info + "]->");
    }
}
