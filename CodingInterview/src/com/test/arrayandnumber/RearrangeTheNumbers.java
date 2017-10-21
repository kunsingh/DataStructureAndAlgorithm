package com.test.arrayandnumber;

import java.util.Arrays;

/**
 * Rearrange positive and negative numbers in O(n) time and O(1) extra space
 * 
 */
public class RearrangeTheNumbers {

    // it will not maintain the order
    public static void rearrangeTheNumbers(int[] A) {
        assert A != null && A.length > 0 : "";
        int positiveIdx = partition(A, 0);
        System.out.println(Arrays.toString(A));
        int negativeIdx = 0;

        while (positiveIdx < A.length && negativeIdx < positiveIdx) {
            int temp = A[positiveIdx];
            A[positiveIdx] = A[negativeIdx];
            A[negativeIdx] = temp;
            positiveIdx++;
            negativeIdx += 2;
        }

    }

    private static int partition(int[] a, int pivot) {

        int low = -1;
        int high = a.length;
        while (true) {
            while (low < (a.length - 1) && a[++low] < pivot)
                ;
            while (high > 0 && a[--high] > pivot)
                ;

            if (low >= high) {
                break;
            } else {
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
            }
        }
        return low;
    }

    public static void rearrangeTheNumbers2(int[] A) {
        boolean positive = false;
        if (A[0] < 0) {
            positive = true;
        }
        int fromIndex = 1;
        for (int i = 1; i < A.length; i++) {
            if (positive) {// positive required
                if (A[i] > 0) {
                    if (i != fromIndex) {
                        shiftAndSwap(A, fromIndex, i);
                        positive = false;
                        fromIndex = i + 1;
                    }
                }
            } else {// negative required
                if (A[i] < 0) {
                    if (i != fromIndex) {
                        shiftAndSwap(A, fromIndex, i);
                        positive = true;
                        fromIndex = i + 1;
                    }
                }
            }
        }
    }

    private static void shiftAndSwap(int[] a, int fromIndex, int toIndex) {
        int temp = a[toIndex];
        for (int j = toIndex; j > fromIndex; j--) {
            a[j] = a[j - 1];
        }
        a[fromIndex] = temp;

    }

    public static void rearrangeTheNumbers1(int[] data) {
        int count = 0;
        // data is the array/vector in sort container having given input.
        if (data[0] < 0){
            count++;
        }
        for (int i = 1; i < data.length; i++) {
            if (data[i] < 0) {
                int j = i;
                while (j > count) {
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                    j--;
                }
                count++;
            }
        }
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        int[] A = { 1, 5, 7, -2, 6, -3, 8, -4, -5, 14, 9 };
        System.out.println(Arrays.toString(A));
        rearrangeTheNumbers(A);
        System.out.println(Arrays.toString(A));
    }
}
