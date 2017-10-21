package com.test.stackandqueue;

public class Queue<T> {
    Node<T> front, rear;
    int nItems;

    public void enqueue(T item) {
        Node<T> node = new Node<T>(item);
        if (front == null) {
            rear = node;
            front = rear;
        } else {
            rear.next = node;
            rear = rear.next;
        }
        nItems++;
    }

    public T dequeue() {
        if (front != null) {
            T val = front.data;
            front = front.next;
            nItems--;
            return val;
        } else {
            return null;
        }
    }

    public T poll() {
        if (front == null) {
            System.err.println("Queue is empty.....");
            return null;
        }
        return front.data;
    }

    public int size() {
        return nItems;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(50);
        queue.enqueue(10);
        queue.enqueue(4);
        queue.enqueue(34);
        queue.enqueue(3);
        queue.enqueue(12);
        queue.enqueue(60);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
