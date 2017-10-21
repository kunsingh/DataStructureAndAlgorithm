package com.test.arbitrarypointer;

public class Node {

    int value;
    Node nextPtr;
    Node arbtPtr;

    public Node(int value) {
        this.value = value;
    }

    public void displayNode() {
        System.out.print("Value: " + value);
        if (nextPtr != null)
            System.out.print(" nextPtr: " + nextPtr.value);
        else{
            System.out.print(" nextPtr: " + nextPtr);
        }
        if (arbtPtr != null)
            System.out.print(" arbitPtr: " + arbtPtr.value);
        
        System.out.println();
    }
}
