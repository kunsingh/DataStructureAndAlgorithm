package com.test.stackandqueue;

class Link<T> {
    T data;
    Link<T> next;

    public Link(T data) {
        this.data = data;
    }
}

class MyStack<T> {

    Link<T> top;
    int nItems;

    public void push(T data) {
        Link<T> node = new Link<T>(data);
        node.next = top;
        top = node;
        nItems++;
    }

    public T pop() {
        if (top == null) {
            System.err.println("Empty stack....");
            return null;
        }
        T val = top.data;
        top = top.next;
        nItems--;
        return val;
    }

    public T peek() {
        return top.data;
    }

    public int size() {
        return nItems;
    }
}

public class StackWithMax extends MyStack<Integer> {
    MyStack<Integer> maxStack;

    public StackWithMax() {
        maxStack = new MyStack<Integer>();
    }

    public void push(int data) {
        super.push(data);
        if (data > max()) {
            maxStack.push(data);
        }
    }

    public int max() {
        if (maxStack.size() > 0) {
            return maxStack.peek();
        }
        return -1;
    }

    public Integer pop() {
        Integer val = super.pop();
        if (val != null) {
            if (val == max()) {
                maxStack.pop();
            }
        }
        return val;
    }

    public static void main(String[] args) {
        StackWithMax stack = new StackWithMax();
        stack.push(50);
        stack.push(10);
        stack.push(4);
        stack.push(34);
        stack.push(3);
        stack.push(12);
        stack.push(60);
        System.out.println(stack.max());
        stack.pop();
        System.out.println(stack.max());
    }
}