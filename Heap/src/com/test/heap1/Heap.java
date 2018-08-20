package com.test.heap1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Heap {

    private Node[] heapArray;
    private int maxSize;
    private int heapSize;

    public Heap(int size) {
        maxSize = size;
        heapSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean insert(int key) {
        if (heapSize == maxSize) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[heapSize] = newNode;
        trickleUp(heapSize++);
        return true;
    }

    private void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        while (index > 0 && bottom.getKey() > heapArray[parent].getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {// delete item with max key
        Node root = heapArray[0];
        heapArray[0] = heapArray[--heapSize];
        trickleDown(0);
        return root;
    }

    private void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        while (index < heapSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            if (rightChild < heapSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= heapSize) {
            return false;
        }

        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if (newValue > oldValue) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }
        return true;
    }

    // -------------------------------------------------------------
    public void displayHeap() {
        System.out.print("heapArray: "); // array format
        for (int m = 0; m < heapSize; m++)
            if (heapArray[m] != null)
                System.out.print(heapArray[m].getKey() + " ");
            else
                System.out.print("-- ");
        System.out.println();
        // heap format
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0; // current item
        String dots = "...............................";
        System.out.println(dots + dots); // dotted top line
        while (heapSize > 0) // for each heap item
        {
            if (column == 0) // first item in row?
                for (int k = 0; k < nBlanks; k++)
                    // preceding blanks
                    System.out.print(' ');
            // display item
            System.out.print(heapArray[j].getKey());
            if (++j == heapSize) // done?
                break;
            if (++column == itemsPerRow) // end of row?
            {
                nBlanks /= 2; // half the blanks
                itemsPerRow *= 2; // twice the items
                column = 0; // start over on
                System.out.println(); // new row
            } else
                // next item on row
                for (int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(' '); // interim blanks
        } // end for
        System.out.println("\n" + dots + dots); // dotted bottom line
    } // end displayHeap()
      // -------------------------------------------------------------

    public static void main(String[] args) throws Exception {
        int value, value2;
        Heap theHeap = new Heap(31); // make a Heap; max size 31
        boolean success;
        theHeap.insert(70); // insert 10 items
        theHeap.insert(40);
        theHeap.insert(50);
        theHeap.insert(20);
        theHeap.insert(60);
        theHeap.insert(100);
        theHeap.insert(80);
        theHeap.insert(30);
        theHeap.insert(10);
        theHeap.insert(90);
        while (true) // until [Ctrl]-[C]
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, remove, change: ");
            int choice = getChar();
            switch (choice) {
            case 's': // show
                theHeap.displayHeap();
                break;
            case 'i': // insert
                System.out.print("Enter value to insert: ");
                value = getInt();
                success = theHeap.insert(value);
                if (!success)
                    System.out.println("Can't insert; heap full");
                break;
            case 'r': // remove
                if (!theHeap.isEmpty())
                    theHeap.remove();
                else
                    System.out.println("Can't remove; heap empty");
                break;
            case 'c': // change
                System.out.print("Enter current index of item: ");
                value = getInt();
                System.out.print("Enter new key: ");
                value2 = getInt();
                success = theHeap.change(value, value2);
                if (!success)
                    System.out.println("Invalid index");
                break;
            default:
                System.out.println("Invalid entry\n");
            } // end switch
        } // end while
    } // end main()
      // -------------------------------------------------------------

    private static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
