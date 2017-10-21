package com.test.linkedlist;

public class ReverseList {

    public static Node reverseList(Node head) {

        Node first = null;
        Node second = head;
        while (second != null) {
            Node temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }
        return first;
    }

    public static Node reverseInGroup(Node head, int k) {
        Node curr = head;
        Node first = null;
        Node next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = first;
            first = curr;
            curr = next;
            count++;
        }
        if (curr != null) {
            head.next = reverseInGroup(next, k);
        }
        return first;
    }

    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node curr = head;
        Node pointer = curr.next;
        while (pointer != null) {
            if (pointer.value < head.value) {
                curr.next = pointer.next;
                pointer.next = head;
                head = pointer;
            } else {
                Node node = head;
                while (node != curr && node.next.value < pointer.value) {
                    node = node.next;
                }
                if (node != curr) {
                    curr.next = pointer.next;
                    pointer.next = node.next;
                    node.next = pointer;
                } else
                    curr = curr.next;
            }
            pointer = curr.next;
        }
        return null;

    }

    static void bubbleSort(Node start) {
        boolean swapped;
        Node curr;
        Node lastPtr = null;

        /* Checking for empty list */
        if (start == null)
            return;

        do {
            swapped = false;
            curr = start;

            while (curr.next != lastPtr) {
                if (curr.value > curr.next.value) {
                    swap(curr, curr.next);
                    swapped = true;
                }
                curr = curr.next;
            }
            lastPtr = curr;
        } while (swapped);
    }

    private static void swap(Node ptr1, Node ptr2) {
        int temp = ptr1.value;
        ptr1.value = ptr2.value;
        ptr2.value = temp;
    }

    public static void main(String[] args) {
        LinkedList linkList = new LinkedList();
        linkList.insertAtEnd(6);
        linkList.insertAtEnd(5);
        linkList.insertAtEnd(10);
        linkList.insertAtEnd(4);
        linkList.insertAtEnd(12);
        linkList.insertAtEnd(3);
        linkList.insertAtEnd(2);
        linkList.displayList();
        // linkList.first = reverseInGroup(linkList.first, 3);
        bubbleSort(linkList.first);
        linkList.displayList();
    }
}
