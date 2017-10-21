package com.test;

import java.util.Arrays;

public class QuickSort {
    private static int[] theArray;
    private static int arraySize;

    QuickSort(/*int newArraySize*/ int[] A) {
        arraySize = A.length;//newArraySize;
        theArray = A;//new int[arraySize];
//        generateRandomArray();
    }

    public void quickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            int pivot = theArray[right];
            int pivotLocation = partitionArray(left, right, pivot);
            quickSort(left, pivotLocation - 1);
            quickSort(pivotLocation + 1, right);
        }
    }

    public int partitionArray(int left, int right, int pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;
        while (true) {
            while (leftPointer < (arraySize - 1) && theArray[++leftPointer] < pivot){
                //leftPointer++;
            }
            while (rightPointer > 0 && theArray[--rightPointer] > pivot){
               // rightPointer--;
            }
            if (leftPointer >= rightPointer)
                break;
            else {
                swap(leftPointer, rightPointer);
            }
        }
        swap(leftPointer, right);
        return leftPointer;
    }

    private void swap(int leftPointer, int rightPointer) {
        int temp = theArray[leftPointer];
        theArray[leftPointer] = theArray[rightPointer];
        theArray[rightPointer] = temp;
    }

    private void generateRandomArray() {
        for (int i = 0; i < arraySize; i++) {
            theArray[i] = (int) (Math.random() * 50) + 10;
        }
    }

    public static void main(String[] args) {
        int[] A={53, 13, 59, 44, 44, 48, 57, 58, 40, 27};
        QuickSort quickSort = new QuickSort(A);
//        quickSort.generateRandomArray();
        System.out.println(Arrays.toString(QuickSort.theArray));
        quickSort.quickSort(0, 9);
        System.out.println(Arrays.toString(QuickSort.theArray));
    }
}
