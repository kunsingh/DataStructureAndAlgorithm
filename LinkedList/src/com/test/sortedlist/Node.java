package com.test.sortedlist;

public class Node {

    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    public void displayLink() {
        System.out.print("[" + value + "]-> ");
    }
}
