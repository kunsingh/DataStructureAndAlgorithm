package com.test.arrayandnumber;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 */
public class TripletSumToZero {

    public static void findTriplet(int[] A, int sum) {
        for (int i = 0; i < A.length - 2; i++) {
            // Fix the second element as A[j]
            for (int j = i + 1; j < A.length - 1; j++) {
                // Now look for the third number
                for (int k = j + 1; k < A.length; k++) {
                    if (A[i] + A[j] + A[k] == sum) {
                        System.out.println("Triplet is: " + A[i] + " " + A[j] + " " + A[k]);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] A = { -1, 0, 1, 2, -1, -4 };
        findTriplet(A, 0);
    }

}
