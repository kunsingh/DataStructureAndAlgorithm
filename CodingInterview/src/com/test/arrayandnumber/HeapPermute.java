package com.test.arrayandnumber;

import java.util.Arrays;

public class HeapPermute {

    public static int[] heapPermute(int[] A, int n) {
        if (n == 0) {
            return A;
        } else {
            for (int i = 0; i <= n; i++) {
                heapPermute(A, n - 1);
                if (n % 2 == 0) {
                    int temp = A[0];
                    A[0] = A[n];
                    A[n] = temp;
                } else {
                    int temp = A[i];
                    A[i] = A[n];
                    A[n] = temp;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = { 2, 3, 4 };
        int[] B = heapPermute(A, A.length - 1);
        System.out.println(Arrays.toString(B));
    }

}
