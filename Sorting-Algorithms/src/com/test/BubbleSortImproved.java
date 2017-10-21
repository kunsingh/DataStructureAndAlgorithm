package com.test;

public class BubbleSortImproved {
    public static void sort(int[] A) {
        int size = A.length;
        boolean isSwapped = true;
        for (int pass = size; pass > 0 && isSwapped; pass--) {
            isSwapped = false;
            System.out.println("I am in outer IF");
            for (int i = 0; i < pass - 1; i++) {
                System.out.println("I am in inner IF");
                if (A[i] > A[i + 1]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    isSwapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] A = { 10, 5, 65, 23, 0, 8, 5, 9, 7, 9, 16 };
        BubbleSortImproved.sort(A);
        for (int a : A) {
            System.out.println(a);
        }
    }

}
