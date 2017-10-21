package com.test.arbitrarypointer;

public class CopyWithArbitraryPointer {

    public static Node copyList(Node node) {
        Node start = null;
        Node copyCurr = null;
        Node currNode = node;
        // copy with next ptr
        while (currNode != null) {
            if (start == null) {
                start = new Node(currNode.value);
            } else {
                copyCurr = start;
                while (copyCurr.nextPtr != null) {
                    copyCurr = copyCurr.nextPtr;
                }
                copyCurr.nextPtr = new Node(currNode.value);
            }
            currNode = currNode.nextPtr;
        }

        // copy arbt ptr
        currNode = node;
        Node nextPtr = node;
        copyCurr = start;
        while (currNode != null) {
            nextPtr = currNode.nextPtr;
            currNode.nextPtr = copyCurr;
            copyCurr.arbtPtr = currNode;
            currNode = nextPtr;
            copyCurr = copyCurr.nextPtr;
        }

        copyCurr = start;
        while (copyCurr != null) {
            copyCurr.arbtPtr = copyCurr.arbtPtr.arbtPtr.nextPtr;
            copyCurr = copyCurr.nextPtr;
        }

        return start;
    }

    public static void main(String[] args) {

        Node node1 = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(8);
        Node node4 = new Node(9);
        Node node5 = new Node(12);
        Node node6 = new Node(10);
        Node node7 = new Node(1);
        Node node8 = new Node(3);
        Node node9 = new Node(2);

        node1.nextPtr = node2;
        node2.nextPtr = node3;
        node3.nextPtr = node4;
        node4.nextPtr = node5;
        node5.nextPtr = node6;
        node6.nextPtr = node7;
        node7.nextPtr = node8;
        node8.nextPtr = node9;
        node9.nextPtr = null;

        node1.arbtPtr = node5;
        node2.arbtPtr = node4;
        node3.arbtPtr = node1;
        node4.arbtPtr = node8;
        node5.arbtPtr = node9;
        node6.arbtPtr = node3;
        node7.arbtPtr = node2;
        node8.arbtPtr = node6;
        node9.arbtPtr = node7;

        Node currNode = node1;
        System.out.println("-----List With Arbitrary Pointer-----");
        while (currNode != null) {
            currNode.displayNode();
            currNode = currNode.nextPtr;
        }

        Node copyCurr = copyList(node1);
        System.out.println("-----List After copy-----");
        while (copyCurr != null) {
            copyCurr.displayNode();
            copyCurr = copyCurr.nextPtr;
        }
    }

}
