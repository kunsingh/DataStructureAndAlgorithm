package com.test.list;

public class KthToLastNode {

    public static Node kthToLastNode(Node first, int k) {
        assert first != null : "list should not be empty";
        assert k > 0 : "position should be greater than 0";
        Node current = first;
        Node nodeBehind = first;
        for (int i = 0; i < k; i++) {
            if (current == null) {
                return null;
            }
            current = current.next;
        }
        while (current != null) {
            nodeBehind = nodeBehind.next;
            current = current.next;
        }

        return nodeBehind;
    }

    static int i = 0;

    public static void kthToLastNode_rec(Node first, int k) {
        assert first != null : "list should not be empty";
        assert k > 0 : "position should be greater than 0";
        if (first == null) {
            return;
        }
        kthToLastNode_rec(first.next, k);
        if (++i == k) {
            System.out.print(first.info);
        }
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertLast(6);
        linkList.insertLast(5);
        linkList.insertLast(10);
        linkList.insertLast(4);
        linkList.insertLast(12);
        linkList.insertLast(3);
        linkList.insertLast(2);

        linkList.displayList();
        System.out.println("The 3rd from last is: ");
        kthToLastNode_rec(linkList.first, 3);
        System.out.println();
        System.out.println("The 5th from last is: " + kthToLastNode(linkList.first, 5).info);
    }
}
