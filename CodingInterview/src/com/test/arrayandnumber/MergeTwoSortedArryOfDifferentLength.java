package com.test.arrayandnumber;

import java.util.Arrays;
import java.util.Stack;

public class MergeTwoSortedArryOfDifferentLength {
    private static int[]  merge(int[] leftArr, int[] rightArr) {
       
        int length = leftArr.length + rightArr.length;
        int[] result = new int[length];
        int k = 0;
        int li = 0;
        int ri = 0;
        while (k < length) {
            if (li < leftArr.length && ri < rightArr.length) {
                if (leftArr[li] < rightArr[ri]) {
                    result[k++] = leftArr[li++];
                } else {
                    result[k++] = rightArr[ri++];
                }
            } else {
                if (li < leftArr.length) {
                    while (li < leftArr.length) {
                        result[k++] = leftArr[li++];
                    }
                }
                if (ri < rightArr.length) {
                    while (ri < rightArr.length) {
                        result[k++] = rightArr[ri++];
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[5];
        A[0] = 3;
        A[1] = 5;
        A[2] = 8;
        A[3] = 10;
        A[4] = 12;
        int[] B = new int[7];
        B[0] = 2;
        B[1] = 4;
        B[2] = 7;
        B[3] = 9;
        B[4] = 10;
        B[5] = 16;
        B[6] = 17;
        int[] result = merge(A, B);
        System.out.println(Arrays.toString(result));
    }
}
