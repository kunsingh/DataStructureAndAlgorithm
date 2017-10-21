package com.test.list;

import java.util.Stack;

public class DisplayReverse {

    public static void displayReverse(Node first) {
        Stack<Integer> stack = new Stack<>();
        Node current = first;
        while (current != null) {
            stack.push(current.info);
            current = current.next;
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkList linkedList = new LinkList();
        linkedList.insertFirst(5);
        linkedList.insertFirst(10);
        linkedList.insertFirst(15);
        linkedList.insertFirst(20);
        System.out.println("List-");
        linkedList.displayList();

        System.out.println("Printed in reverse order-");
        displayReverse(linkedList.first);

    }
}
