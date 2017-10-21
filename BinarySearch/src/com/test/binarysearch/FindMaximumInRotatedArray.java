package com.test.binarysearch;

public class FindMaximumInRotatedArray {

    public int findMaximum(int[] A, int start, int end){
        while(A[start] > A[end]){
            int mid = (start + end) >>> 1;
            
            if(A[mid] < A[start]){
                end = mid -1;
            }else{
                start = mid;
            }
        }
        
        return end;
    }
    
    public static void main(String[] args) {
        int[] A = {18, 19, 20, 25, 5, 6, 8, 10, 14};
        System.out.println(new FindMaximumInRotatedArray().findMaximum(A, 0, A.length-1));
    }
}
