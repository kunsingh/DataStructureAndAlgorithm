package com.test.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromUnsortedList {

    public static void deleteDuplicates1(Node start) {
        Node current = start;
        while (current != null) {
            Node next = current.next;
            Node previous = current;
            while (next != null) {
                if (current.value == next.value) {
                    previous.next = next.next;
                } else {
                    previous = next;
                }
                next = next.next;
            }
            current = current.next;
        }
    }

  
    public static void deleteDuplicates(Node start) {
        Set<Integer> set = new HashSet<>();
        Node current = start;
        Node previous = start;
        while (current != null) {
            System.out.println("adding to set: " + current.value);
            if (!set.add(current.value)) {
                System.out.println("Inside If");
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkList = new LinkedList();
        linkList.insertAtEnd(5);
        linkList.insertAtEnd(20);
        linkList.insertAtEnd(5);
        linkList.insertAtEnd(5);
        linkList.insertAtEnd(40);
        linkList.insertAtEnd(5);
        linkList.insertAtEnd(40);

        System.out.println("List: ");
        linkList.displayList();
        deleteDuplicates1(linkList.first);
        System.out.println("After removal of duplicates: ");
        linkList.displayList();
    }
}
