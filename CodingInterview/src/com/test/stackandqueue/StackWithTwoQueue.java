package com.test.stackandqueue;

public class StackWithTwoQueue {

    Queue<Integer> oldQueue;
    Queue<Integer> newQueue;

    public StackWithTwoQueue() {
        oldQueue = new Queue<Integer>();
        newQueue = new Queue<Integer>();
    }

    public void push(int item) {
        oldQueue.enqueue(item);
    }

    public Integer pop() {
        copy(oldQueue, newQueue, 1);// leave last element in old queue
        int value = oldQueue.dequeue();// remove last element
        copy(newQueue, oldQueue, 0);// copy back all the elements
        return value;
    }

    private void copy(Queue<Integer> src, Queue<Integer> target, int upto) {
        if (target.size() == 0) {
            while (src.size() > upto) {
                target.enqueue(src.dequeue());
            }
        }
    }

    public static void main(String[] args) {
        StackWithTwoQueue stack = new StackWithTwoQueue();
        stack.push(50);
        stack.push(10);
        stack.push(4);
        stack.push(34);
        stack.push(3);
        stack.push(12);
        stack.push(60);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(55);
        stack.push(33);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
