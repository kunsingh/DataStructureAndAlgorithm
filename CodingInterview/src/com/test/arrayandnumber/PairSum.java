package com.test.arrayandnumber;

/**
 * Find all pairs which sums to k.
 */
import java.util.HashMap;
import java.util.Map;

public class PairSum {

    public static void pairSum(int[] A, int k) {
        Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (pairs.containsKey(A[i])) {
                System.out.println(A[i] + ", " + pairs.get(A[i]));
            } else {
                pairs.put(k - A[i], A[i]);
            }
        }
    }
    
    //differ by +1 or +2
    public static void pairSum(int[] A) {
        Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (pairs.containsKey(A[i])) {
                System.out.println(A[i] + ", " + pairs.get(A[i]));
            } else {
                pairs.put(A[i]+1, A[i]);
                pairs.put(A[i]+2, A[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 5, 8, 11, 12, 16, 6, 7, 1, 11 };
//        pairSum(A);//, 13);
//        int[] A1 = { 1, 11, 2 };
        pairSum(A, 13);
    }
}
