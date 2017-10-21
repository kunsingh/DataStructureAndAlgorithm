package com.test.stackandqueue;

public class QueueWithTwoStacks {
    Stack<Integer> oldStack;
    Stack<Integer> newStack;

    public QueueWithTwoStacks() {
        oldStack = new Stack<Integer>();
        newStack = new Stack<Integer>();
    }

    public int size() {
        return oldStack.size() + newStack.size();
    }

    public void enqueue(int value) {
        newStack.push(value);
    }

    public int dequeue() {
        shiftStack();
        return oldStack.pop();
    }

    private void shiftStack() {
        if (oldStack.size() == 0) {
            while (newStack.size() > 0) {
                oldStack.push(newStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueue(10);
        queue.enqueue(18);
        queue.enqueue(5);
        queue.enqueue(29);
        queue.enqueue(27);
        queue.enqueue(6);

        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
