package com.test.heap;

import java.util.Arrays;

public class MaxHeap {

    private int[] heapArray;
    private int maxSize;
    private int heapSize;

    public MaxHeap(int size) {
        heapSize = 0;
        maxSize = size;
        heapArray = new int[maxSize];
    }

    public MaxHeap(int[] A) {
        heapSize = A.length;
        maxSize = A.length;
        heapArray = A;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    // time O(logn)-trickledown
    public void maxHeapify(int i) {// consider i as parent
        int left = (2 * i) + 1;
        int right = left + 1;
        int largest = i;
        if (left < heapSize && heapArray[left] > heapArray[i]) {
            largest = left;
        }
        if (right < heapSize && heapArray[right] > heapArray[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = heapArray[i];
            heapArray[i] = heapArray[largest];
            heapArray[largest] = temp;
            maxHeapify(largest);
        }
    }

    // time O(logn)
    public void minHeapify(int i) {
        int left = (2 * i) + 1;
        int right = left + 1;
        int smallest = i;
        if (left < heapSize && heapArray[left] < heapArray[i]) {
            smallest = left;
        }
        if (right < heapSize && heapArray[right] < heapArray[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            int temp = heapArray[i];
            heapArray[i] = heapArray[smallest];
            heapArray[smallest] = temp;
            minHeapify(smallest);
        }
    }

    // time O(logn)--trickledown
    public void maxHeapifyNonRecursive(int i) {
        int largest = i;
        while (largest < heapSize / 2) {
            int left = (2 * i) + 1;
            int right = left + 1;
            if (left < heapSize && heapArray[left] > heapArray[i]) {
                largest = left; // largest=6
            }
            if (right < heapSize && heapArray[right] > heapArray[largest]) {
                largest = right;
            }
            if (largest != i) {
                int temp = heapArray[i];
                heapArray[i] = heapArray[largest];
                heapArray[largest] = temp;
                i = largest;
            } else {
                break;
            }

        }
    }

    // o(nlogn)
    public void builMaxHeap() {
        // we are not starting from 0 because we are swapping largest child to
        // the parent(see algorithm)
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            maxHeapifyNonRecursive(i);
        }
    }

    public void builMinHeap() {
        // we are not starting from 0 because we are swapping largest child to
        // the parent(see algorithm)
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    // time O(nlogn)
    public void heapSort() {
        builMaxHeap();
        for (int i = heapSize - 1; i >= 1; i--) {
            int temp = heapArray[0];
            heapArray[0] = heapArray[i];// top is always the largest
            heapArray[i] = temp;
            heapSize--;
            maxHeapifyNonRecursive(0);// top element may violate heap property
        }
    }

    // prioprityQueue operations
    public int extractMax() {
        assert heapSize < 0 : "heap underflow";
        int max = heapArray[0];
        heapArray[0] = heapArray[--heapSize];
        maxHeapifyNonRecursive(0);
        return max;
    }

    public void insertKey(int key) {
        assert heapSize > maxSize - 1 : "heap overflow";
        heapArray[heapSize] = key;
        trickleUp(heapSize++);
    }

    public void changeKey(int i, int key) {
        int oldValue = heapArray[i];
        heapArray[i] = key;
        if (key > oldValue) {
            trickleUp(i);
        } else {
            maxHeapify(i);
        }
    }

    private void trickleUp(int i) {
        int parent = (i - 1) / 2;
        while (i > 0 && heapArray[i] > heapArray[parent]) {
            int temp = heapArray[parent];
            heapArray[parent] = heapArray[i];
            heapArray[i] = temp;
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    public void showHeap() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heapArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A1 = { 1, 8, 9, 2, 10, 14, 5, 0, 3, 4, 7, 16 };

        System.out.println("Original Array:: " + Arrays.toString(A1));
        MaxHeap heap = new MaxHeap(A1);

        heap.builMaxHeap();
        heap.showHeap();

        heap.builMinHeap();
        heap.showHeap();
        // for (int i : A1) {
        // heap.insertKey(i);
        // }
        // System.out.print("After inserting to heap:: ");
        // heap.showHeap();
        // System.out.println();
        // System.out.println("Removed Max:: " + heap.extractMax());
        // System.out.println("Removed Max:: " + heap.extractMax());
        // System.out.print("After two removal the heap:: ");
        // heap.showHeap();
        // System.out.println();
        // heap.insertKey(50);
        // heap.insertKey(0);
        // System.out.print("After inserting 50 and 0 the heap:: ");
        // heap.showHeap();
    }
}
