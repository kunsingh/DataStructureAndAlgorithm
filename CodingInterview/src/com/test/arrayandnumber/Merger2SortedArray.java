package com.test.arrayandnumber;

import java.util.Arrays;

public class Merger2SortedArray {

    public static int[] merge(int B[],int A[], int m) {
        int i = 0;//m - 1;
        int j = 0;//m - 1;
        int length = (2 * m) - 1;
        
        int[] result = new int[length];
        int k =0;
        while(k < length){
            if(A[i] < B[j]){
                result[k++] = A[i++];
            }else{
                result[k++] = B[j++];
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
        int[] B = new int[10];
        B[0] = 2;
        B[1] = 5;
        B[2] = 7;
        B[3] = 9;
        B[4] = 11;

        System.out.println(Arrays.toString( merge(A, B, 5)));
    }
}
