package com.test.circular;

class Node {

    int info;
    Node next;

    public Node(int value) {
        this.info = value;
    }

    public void displayLink() {
        System.out.print("[" + info + "] ");
    }
}