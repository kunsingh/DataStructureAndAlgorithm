package com.test.list;

public class ReverseListGroups {

    public static Node reverseListInGroup(Node start, int k) {
        assert start != null : "Empty list!";
        Node prev = null;
        Node current = start;
        
        Node next = null;
        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            start.next = reverseListInGroup(next, k);
        }
        return prev;
    }



    public static void main(String[] args) {
        LinkList linkedList = new LinkList();
        linkedList.insertLast(5);
        linkedList.insertLast(10);
        linkedList.insertLast(15);
        linkedList.insertLast(20);
        linkedList.insertLast(25);
        linkedList.insertLast(30);
        linkedList.insertLast(1);

        linkedList.displayList();
        linkedList.first = reverseListInGroup(linkedList.first, 3);
        linkedList.displayList();
    }
}
