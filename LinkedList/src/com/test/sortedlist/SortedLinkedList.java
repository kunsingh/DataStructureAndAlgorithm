package com.test.sortedlist;

public class SortedLinkedList {

    private Node first;

    public SortedLinkedList() {
        first = null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (first == null) {
            first = node;
        } else {
            if (first.value > value) {
                node.next = first;
                first = node;
            } else {
                Node current = first;
                Node previous = first;
                while (current.next != null) {
                    if (current.value > value) {
                        previous.next = node;
                        node.next = current;
                        break;
                    }
                    previous = current;
                    current = current.next;
                }
                if (current.next == null) { // reached to last of the list
                    current.next = node;
                }
            }
        }
    }

    public void displayList() {
        Node current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortedLinkedList linkList = new SortedLinkedList();
        linkList.insert(10);
        linkList.insert(20);
        linkList.insert(5);
        linkList.insert(1);
        linkList.insert(40);
        linkList.insert(60);
        linkList.insert(100);

        linkList.displayList();
    }
}
