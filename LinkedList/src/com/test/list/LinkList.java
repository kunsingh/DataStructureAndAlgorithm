package com.test.list;

public class LinkList {

    Node first;
    int nItems;

    public LinkList() {
        first = null;
        nItems = 0;
    }

    public void insertFirst(int info) {
        Node node = new Node(info);
        node.next = first;
        first = node;
        nItems++;
    }

    public void insertLast(int info) {
        Node node = new Node(info);
        if (first == null) {
            first = node;
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        nItems++;
    }

    public boolean delete(int info) {
        assert size() > 0 : "Empty list";
        nItems--;
        // if it is the first element then move first one element further
        if (first.info == info) {
            first = first.next;
            return true;
        } else {
            Node current = first;
            Node previous = first;
            while (current != null && current.info != info) {
                previous = current;
                current = current.next;
            }
            if (current != null) {
                previous.next = current.next;
                return true;
            } else {
                System.err.println("No match found in the list for value:" + info);
                return false;
            }
        }
    }

    public Node find(int info) {
        assert size() > 0 : "Empty list";
        Node current = first;
        while (current != null && current.info != info) {
            current = current.next;
        }
        if (current != null) {
            return current;
        } else {
            System.err.println("No match found in the list for value:" + info);
            return null;
        }
    }

    public int size() {
        return nItems;
    }

    public void displayList() {
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public void displayList(Node start) {
        Node current = start;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkList linkedList1 = new LinkList();
        linkedList1.insertFirst(5);
        linkedList1.insertFirst(10);
        linkedList1.insertFirst(15);
        linkedList1.insertFirst(20);
        System.out.println("First List-");
        linkedList1.displayList();
        linkedList1.delete(15);
        System.out.println("After deleting 15-");
        linkedList1.displayList();

        LinkList linkedList2 = new LinkList();
        linkedList2.insertLast(5);
        linkedList2.insertLast(10);
        linkedList2.insertLast(15);
        linkedList2.insertLast(20);
        System.out.println("Second List-");
        linkedList2.displayList();
        linkedList2.delete(5);
        System.out.println("After deleting first element 5-");
        linkedList2.displayList();

    }
}
