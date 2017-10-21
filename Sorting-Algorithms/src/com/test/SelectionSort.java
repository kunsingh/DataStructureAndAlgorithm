package com.test;

public class SelectionSort {

    public static void sort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            int temp = A[i];
            A[i] = A[min];
            A[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] Arr = { 5, 3, 8, 2, 0, 78, 1, 6 };
        SelectionSort.sort(Arr);
        for (int i = 0; i < Arr.length; i++) {
            System.out.println(Arr[i]);
        }

        int[] A = new int[100000];

        for (int i = 0; i < 100000; i++) {
            A[i] = i;
        }
        long startTime = System.currentTimeMillis();
        SelectionSort.sort(A);
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken:: " + (endTime - startTime));
    }
}
