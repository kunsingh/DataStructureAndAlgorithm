package com.test.stackandqueue;

public class StackWithMin extends Stack<Integer> {

    private Stack<Integer> minStack;

    public StackWithMin() {
        minStack = new Stack<Integer>();
    }

    public void push(int value) {
        if (min() == -1 || value < min()) {
            minStack.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            minStack.pop();
        }
        return value;
    }

    private int min() {
        if (minStack.size() > 0) {
            return minStack.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(50);
        stack.push(10);
        stack.push(4);
        stack.push(34);
        stack.push(3);
        stack.push(12);
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}
