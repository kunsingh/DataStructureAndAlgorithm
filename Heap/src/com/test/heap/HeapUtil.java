package com.test.heap;

import java.util.Arrays;

public class HeapUtil {

    private void maxHeapify(int[] heapArray, int index, int heapSize) {
        int largest = index;
        while (largest < heapSize / 2) { // check before leaf node only
            int left = (2 * index) + 1;
            int right = left + 1;
            if (left < heapSize && heapArray[left] > heapArray[index]) {
                largest = left; // largest=6
            }
            if (right < heapSize && heapArray[right] > heapArray[largest]) {
                largest = right;
            }
            if (largest != index) {
                int temp = heapArray[index];
                heapArray[index] = heapArray[largest];
                heapArray[largest] = temp;
                index = largest;
            } else {
                break;
            }

        }
    }

    public void builMaxHeap(int[] heapArray, int heapSize) {
        // we are not starting from 0 because we are swapping largest child to
        // the parent(see algorithm)
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            maxHeapify(heapArray, i, heapSize);
        }
    }

    public void heapSort(int[] heapArray) {
        builMaxHeap(heapArray, heapArray.length);
        int heapSize = heapArray.length;
        for (int i = heapSize - 1; i >= 1; i--) {
            int temp = heapArray[0];
            heapArray[0] = heapArray[i];// top is always the largest
            heapArray[i] = temp;
            heapSize--; // top at its right position
            maxHeapify(heapArray, 0, heapSize);// top element may violate heap
                                               // property
        }
    }

    public static void main(String[] args) {
        int[] heapArray = { 1, 8, 9, 2, 10, 14, 3, 4, 7, 16 };

        // System.out.println("Before heapify: "+Arrays.toString(heapArray));
        //
        // new HeapUtil().builMaxHeap(heapArray, heapArray.length);
        //
        // System.out.println("After heapify: "+Arrays.toString(heapArray));

        System.out.println("Before Sort: " + Arrays.toString(heapArray));
        new HeapUtil().heapSort(heapArray);
        System.out.println("After Sort: " + Arrays.toString(heapArray));
    }
}
