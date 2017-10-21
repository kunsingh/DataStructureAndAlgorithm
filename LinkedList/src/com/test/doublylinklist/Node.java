package com.test.doublylinklist;

public class Node {

    int info;
    Node next;
    Node previous;

    public Node(int info) {
        this.info = info;
    }

    public void displayNode() {
        System.out.print("[" + info + "]->");
    }
}
