package com.test.linkedlist;

public class LinkedList {

    public Node first;
    int nItems;

    public LinkedList() {
        first = null;
    }

    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (first == null) {
            first = node;
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        ++nItems;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Node find(int key) {
        Node current = first;
        while (current != null) {
            if (current.value == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void delete(int key) {
        Node current = first;
        Node previous = first;
        while (current != null) {
            if (current.value == key) {
                previous.next = current.next;
                break;
            }
            previous = current;
            current = current.next;
            nItems--;
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

    public int size() {
        return nItems;
    }

    public Node getFirst() {
        return first;
    }

    public static void main(String[] args) {
        LinkedList linkList = new LinkedList();
        linkList.insertAtEnd(4);
        linkList.insertAtEnd(4);
        linkList.insertAtEnd(4);
        // linkList.insertAtEnd(4);
        // linkList.insertAtEnd(5);
        // linkList.insertAtEnd(60);
        // linkList.insertAtEnd(100);

        linkList.displayList();
        // linkList.deleteFirst();
        // linkList.displayList();
        // linkList.delete(5);
        linkList.removeNode(linkList.getFirst(), 3);
        linkList.displayList();
    }

    public Node removeNode(Node head, int x) {
        if (head == null) {
            return null;
        }
        if (head.value > x) {
            head = head.next;
        }

        Node current = head;
        Node previous = head;
        while (current != null) {
            if (current.value > x) {
                previous.next = current.next;

            } else {
                previous = current;
            }

            current = current.next;

        }

        return head;
    }
}
