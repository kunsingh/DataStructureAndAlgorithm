package com.test.list;

public class ReverseList {

    static Node head;

    public static Node reverseList(Node start) {
        assert start != null : "Empty list!";
        Node first = start;
        Node second = first.next;
        Node third = second.next;
        first.next = null;
        while (third != null) {
            second.next = first;
            first = second;
            second = third;
            third = third.next;
        }
        second.next = first;
        start = second;
        return start;
    }

    public static Node reverseList1(Node start) {
        assert start != null : "Empty list!";
        Node prev = null;
        Node curr = start;
        while (curr != null) {
            Node next = curr.next; // don't loss the 2nd pointer
            curr.next = prev; // point second to first(next to previous)
            prev = curr; // move previous to the
            curr = next; // move curr to preserved next pointer
        }
        start = prev;
        return start;
    }

    public static void reverse(Node start) {
        assert start != null : "Empty list!";

        Node remaining = start.next;
        if (remaining == null) {
            head = start;
            return;
        }
        reverse(remaining);
        start.next.next = start;
        start.next = null;
        start = remaining;

        // return start;
    }

    public static void main(String[] args) {
        LinkList linkedList = new LinkList();
        linkedList.insertLast(5);
        linkedList.insertLast(10);
        linkedList.insertLast(15);
        linkedList.insertLast(20);

        linkedList.displayList();
        linkedList.first = reverse1(linkedList.first);
        linkedList.displayList();
    }
    
    public static Node reverse1(Node start){
        assert start!=null:"head is null";
        Node current = start;
        Node second = start.next;
        Node third = second.next;
        if(current.next == null){
            return current;
        }
        
        current.next = null;
        while(third !=null){
            second.next = current;
            current = second;
            second = third;
            third = third.next;
            
        }
        
        second.next = current;
        return second;
        
    }
}
