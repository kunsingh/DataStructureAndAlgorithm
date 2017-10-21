package com.test.Practice;

public class MaximumSubsequenceSum {

    public static int maxSubSum(int[] A) {
        assert A.length > 0 : "Empty array.";

        int maxSum = A[0];
        int currentSum = 0;
        for (int i : A) {
            currentSum = currentSum + i;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    public static int maxSubSum4(int[] a) {
        int maxSum = 0, thisSum = 0;

        for (int j = 0; j < a.length; j++) {
            thisSum += a[j];

            if (thisSum > maxSum)
                maxSum = thisSum;
            else if (thisSum < 0)
                thisSum = 0;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, -3, 4 };
        System.out.println(maxSubSum(A));
        System.out.println(maxSubSum4(A));
    }
}
