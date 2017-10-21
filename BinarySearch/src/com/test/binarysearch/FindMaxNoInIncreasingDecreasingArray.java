    package com.test.binarysearch;

public class FindMaxNoInIncreasingDecreasingArray {

    public int findMaximum(int[] A, int start, int end) {
        if (start == end) {
            return A[start];
        }
        // if only 2 elements
        if ((start + 1) == end) {
            return A[start] < A[end] ? A[end] : A[start];
        }
        while (start < end) {
            int mid = (start + end) >>> 1;
            
            if(A[mid] > A[mid + 1] && A[mid] > A[mid - 1]){
              return mid;
            }
            
            if(A[mid] < A[mid+1]){
                start = mid +1;
            }else{
                end = mid-1;
            }
        }

        return end;
    }
    public static void main(String[] args) {
        int[] A = { 3, 5, 6, 8, 15, 7 };
        System.out.println(new FindMaxNoInIncreasingDecreasingArray().findMaximum(A, 0, A.length-1));
    }
}
