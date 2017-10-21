package com.test;

import java.util.Arrays;

public class MergeSort {
    static int invCount = 0;

    public static void mergeSort(int[] A) {
        if (A.length > 1) {
            int mid = A.length / 2;

            int[] leftArray = Arrays.copyOfRange(A, 0, mid);
            int[] rightArray = Arrays.copyOfRange(A, mid, A.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(A, leftArray, rightArray);
        }
    }

    static void merge(int[] a, int[] leftArr, int[] rightArr) {
        int totElem = leftArr.length + rightArr.length;
        int i = 0;
        int li = 0;
        int ri = 0;
        while (i < totElem) {
            if ((li < leftArr.length) && (ri < rightArr.length)) {
                if (leftArr[li] < rightArr[ri]) {
                    a[i] = leftArr[li];
                    i++;
                    li++;
                } else {
                    a[i] = rightArr[ri];
                    i++;
                    ri++;
                    invCount = invCount + i - li;// TODO
                }
            } else {
                if (li >= leftArr.length) {
                    while (ri < rightArr.length) {
                        a[i] = rightArr[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= rightArr.length) {
                    while (li < leftArr.length) {
                        a[i] = leftArr[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        System.out.println("Inversion Count:: " + invCount);
    }

    public static void main(String[] args) {
        int[] A = { 2, 4, 1, 3, 8, 5, 7, 6, 10 };
        MergeSort.mergeSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
