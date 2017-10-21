package com.test;

public class MergeSortWithAuxArray {

    static int[] auxArray;

    public static void sort(int[] A) {
        auxArray = new int[A.length];
        mergeSort(A, 0, A.length - 1);
    }

    private static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }

    }

    private static void merge(int[] a, int low, int mid, int high) {
        for (int i = 0; i < a.length; i++) {
            auxArray[i] = a[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= mid && j <= high) {
            if (auxArray[i] <= auxArray[j]) {
                a[k] = auxArray[i];
                i++;
            } else {
                a[k] = auxArray[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= mid) {
            a[k] = auxArray[i];
            k++;
            i++;
        }

    }

    public static void main(String[] args) {
        int[] A = { 5, 3, 8, 2, 0, 78, 1, 6 };
        MergeSortWithAuxArray.sort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
