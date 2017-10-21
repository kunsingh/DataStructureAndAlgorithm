package com.test.dynamicprogramming;

public class LargestContinuousSum {

    public static int largestContinuousSum(int[] A) {
        int maxSum = A[0];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static int largestContinuousSum1(int[] A) {
        assert A.length > 0 : "Empty array.";
        int maxSum = A[0];
        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            sum = max(sum + A[i], A[i]);
            maxSum = max(sum, maxSum);
        }
        return maxSum;
    }

    public static int largestContinuousSumWithPosition(int[] A) {
        assert A.length > 0 : "Empty array.";
        int start = 0;
        int tstart = 0;
        int end = 0;

        int maxSum = A[0];
        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > sum + A[i]) {
                tstart = i;
                sum = A[i];
            } else {
                sum = sum + A[i];
            }

            if (sum > maxSum) {
                maxSum = sum;
                start = tstart;
                end = i;
            }
        }
        System.out.println(start + "  " + end);
        return maxSum;
    }

    private static int max(int i, int j) {
        return i > j ? i : j;
    }

    public static void main(String[] args) {
        int[] A = { 12, 10, 14, -12, 0, -4, 50, 61 };// , -16, 6, 7, 1, 11 };
        System.out.println(largestContinuousSumWithPosition(A));
        System.out.println(lcs(A));
    }

    public static int lcs(int[] A) {
        int maxSum = A[0];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            System.out.println(" maxSum:  " + maxSum);
        }
        return maxSum;
    }
}
