package com.test.doublylinklist;

public class DoublyLinkList {

    private Node first;
    private Node last;
    private int nItems;

    public DoublyLinkList() {
        first = last = null;
        nItems = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return nItems;
    }

    public void insertFirst(int data) {
        Node node = new Node(data);
        if (isEmpty()) {
            last = node;
        } else {
            first.previous = node;
        }
        node.next = first;
        first = node;
        nItems++;
    }

    public void insertLast(int info) {
        Node node = new Node(info);
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
        }
        node.previous = last;
        last = node;
        nItems++;
    }

    public boolean delete(int info) {
        assert isEmpty() : "Empty list!";
        nItems--;
        if (first.info == info) {
            return deleteFirst();
        }
        if (last.info == info) {
            return deleteLast();
        }
        Node current = first;
        while (current != null && current.info != info) {
            current = current.next;
        }
        if (current != null) {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            return true;
        } else {
            System.err.println("No match found in the list for value:" + info);
            return false;
        }
    }

    public boolean deleteFirst() {
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.previous = null;
        }
        return true;
    }

    public boolean deleteLast() {
        last = last.previous;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        return true;
    }

    public void displayForward() {
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkList list1 = new DoublyLinkList();
        list1.insertFirst(5);
        list1.insertFirst(10);
        list1.insertFirst(15);
        list1.insertFirst(20);
        System.out.println("First List-");
        list1.displayForward();
        list1.delete(15);
        System.out.println("After deleting 15-");
        list1.displayForward();

        DoublyLinkList list2 = new DoublyLinkList();
        list2.insertLast(5);
        list2.insertLast(10);
        list2.insertLast(15);
        list2.insertLast(20);
        System.out.println("Second List-");
        list2.displayForward();
        list2.delete(5);
        System.out.println("After deleting first element 5-");
        list2.displayForward();
    }
}
