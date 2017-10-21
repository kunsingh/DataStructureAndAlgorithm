package com.test.linkedlist;


public class KthToLastNodeInList {

    public static Node kthToLast(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        Node behind = head;
        for (int i = 0; i < k; i++) {
            curr = curr.next;
            if (curr == null) {
                return null;
            }
        }
        while (curr != null) {
            curr = curr.next;
            behind = behind.next;
        }
        return behind;
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
        System.out.println("The 3rd from last is: " + kthToLast(linkList.first, 3).value);
        System.out.println();
        System.out.println("The 5th from last is: " + kthToLast(linkList.first, 5).value);
    }
}
