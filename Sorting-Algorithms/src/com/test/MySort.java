package com.test;

public class MySort {

    public static void sort(int[] A) {
        int[] aux = new int[A.length];
        for (int i : A) {
            if (aux[i] == 0) {
                aux[i] = i;
            } else {
                aux[aux.length] = i;
            }
        }
        int k = 0;
        for (int i : aux) {
            if (aux[i] > 0) {
                A[k++] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[10000000];

        for (int i = 10000000 - 1; i >= 0; i--) {
            A[i] = i;
        }
        long startTime = System.currentTimeMillis();
        MySort.sort(A);
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken:: " + (endTime - startTime));
        // for (int i = 0; i < A.length; i++) {
        // System.out.println(A[i]);
        // }
    }
}
