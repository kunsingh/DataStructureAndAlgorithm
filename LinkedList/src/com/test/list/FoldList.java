package com.test.list;

/**
 * Fold a linked list such that the last element becomes second element, last but one element becomes 4th element and so on. 
 * For example input linked list: 1->2->3->4->5->6->7->8->9-> output linked list 1->9->2->8->3->7->4->6->5->
 */
public class FoldList {

    public static void foldLinkedList(Node head){
        Node curr = head;
        Node mid = head;
        Node next = head;
        
        while(next != null){
            mid = mid.next;
            next = next.next;
            if(next !=null){
                next = next.next; 
            }
        }
        Node middleNode = mid;
        Node reverseListHead = reverseList(middleNode);
        curr = head;
        while(reverseListHead != null && curr != mid){
            Node temp = curr.next;
            Node tempRev = reverseListHead.next;
            curr.next = reverseListHead;
            reverseListHead.next = temp;
            curr = temp;
            reverseListHead = tempRev;
        }
        if(reverseListHead != null){
            reverseListHead.next = null;
        }else{
            curr.next = null;
        }
    }
    private static Node reverseList(Node head) {
        Node start = head;
        Node prev = null;
        while(start != null){
            Node next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        LinkList linkedList = new LinkList();
        linkedList.insertLast(1);
        linkedList.insertLast(2);
        linkedList.insertLast(3);
        linkedList.insertLast(4);
        linkedList.insertLast(5);
        linkedList.insertLast(6);
        linkedList.insertLast(7);
        linkedList.insertLast(8);

        linkedList.displayList();
        foldLinkedList(linkedList.first);
        linkedList.displayList();
    }
}
