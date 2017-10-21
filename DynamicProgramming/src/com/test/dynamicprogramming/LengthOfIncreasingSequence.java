package com.test.dynamicprogramming;

public class LengthOfIncreasingSequence {

    public static int lengthOfIncreasingSequence(int[] A) {
        assert A.length > 0 : "Empty Array";
        int[] F = new int[A.length];
        F[0] = 1;
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            max = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && F[j] > max) {
                    max = F[j];
                    System.out.println(F[j] + " f[j]-MAX " + max);
                }
            }
            F[i] = max + 1;
            System.out.println(F[i] + " f[i]-MAX " + max);
        }
        return F[A.length - 1];
    }

    public static void main(String[] args) {
        // int[] A = {4,3,2,1};
        int[] A = { 12, 10, 14, -12, 0, -4, 50, 61 };
        System.out.println(lengthOfIncreasingSequence(A));
    }
}
