package com.test.arrayandnumber;

import java.util.Arrays;

public class MinimumDifferenceInUnSortedArray {

    public static int getMinDifference(int[] A) {
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i+1; j < A.length; j++) {

                if (i != j && minDiff > Math.abs(A[i] - A[j])) {
                    minDiff = Math.abs(A[i] - A[j]);
                }
            }
        }
        return minDiff;
    }
    
    
    public static void main(String[] args) {
        int[] A = { 2, 5, 6, 8, 0, 1};
        System.out.println(getMinDifference(A));
        System.out.println(getMinDifference2(A));
    }
    
    public static int getMinDifference2(int[] A) {
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(A);
        for (int i = 0; i < A.length-1; i++) {
            if(minDiff > Math.abs(A[i]-A[i+1])){
                minDiff = Math.abs(A[i]-A[i+1]);
            }
        }
        return minDiff;
    }
}
