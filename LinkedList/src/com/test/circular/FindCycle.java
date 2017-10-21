package com.test.circular;

public class FindCycle {

    public static boolean hasCycle(Node head) {
        Node behind = head;
        Node forward = head.next;

        while (true) {
            if (forward == null) {
                return false;
            }
            if (forward == behind || forward.next == behind) {
                return true;
            }
            forward = forward.next.next;
            behind = behind.next;
        }
    }

    public static void main(String[] args) {
        CircularLinkList list1 = new CircularLinkList();
        list1.insert(5);
        list1.insert(10);
        list1.insert(15);
        list1.insert(20);
        System.out.println("List-");
        list1.displayList();
        System.out.println(hasCycle(list1.first));

        LinkedList linkList = new LinkedList();
        linkList.insertAtEnd(10);
        linkList.insertAtEnd(20);
        linkList.insertAtEnd(5);
        linkList.insertAtEnd(1);
        linkList.insertAtEnd(40);
        linkList.insertAtEnd(60);
        linkList.insertAtEnd(100);
        linkList.displayList();
        System.out.println(hasCycle(linkList.first));
    }
}
