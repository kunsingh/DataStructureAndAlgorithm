package com.test.stackandqueue;

public class Stack<T> {

    Node<T> top;
    int nItems;

    public T pop() {
        if (top != null) {
            T val = top.data;
            top = top.next;
            nItems--;
            return val;
        } else {
            return null;
        }
    }

    public void push(T value) {
        Node<T> newNode = new Node<T>(value);
        newNode.next = top;
        top = newNode;
        nItems++;
    }

    public T peek() {
        return top.data;
    }

    public int size() {
        return nItems;
    }
}
