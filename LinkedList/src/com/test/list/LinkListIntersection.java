package com.test.list;

import java.util.HashSet;
import java.util.Set;

public class LinkListIntersection {

    public static boolean isListsIntersects(Node start1, Node start2) {
        assert start1 != null && start2 != null : "One or both of the list is empty";
        Set<Integer> set = new HashSet<Integer>();
        Node current1 = start1;
        while (current1 != null) {
            set.add(current1.info);
            current1 = current1.next;
        }
        Node current2 = start2;
        while (current2 != null) {
            boolean isAdded = set.add(current2.info);
            if (!isAdded) {
                return true;
            }
            current2 = current2.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkList linkedList1 = new LinkList();
        linkedList1.insertFirst(5);
        linkedList1.insertFirst(10);
        linkedList1.insertFirst(15);
        linkedList1.insertFirst(20);
        linkedList1.displayList();

        LinkList linkedList2 = new LinkList();
        linkedList2.insertFirst(10);
        linkedList2.insertFirst(45);
        linkedList2.insertFirst(25);
        linkedList2.insertFirst(60);
        linkedList2.displayList();

        System.out.println("Is Intersect:: " + isListsIntersects(linkedList1.first, linkedList2.first));
    }
}
