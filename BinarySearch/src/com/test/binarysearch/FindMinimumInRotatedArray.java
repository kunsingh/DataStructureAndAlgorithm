package com.test.binarysearch;

public class FindMinimumInRotatedArray {

    public int findMinimum(int[] A, int start, int end){
        while(A[start] > A[end]){
            int mid = (start + end) >>> 1;
            
            if(A[mid] > A[end]){
                start = mid +1;
            }else{
                end = mid;
            }
        }
        
        return start;
    }
    
    public static void main(String[] args) {
        int[] A = {18, 19, 20, 25, 5, 6, 8, 10, 14};
        System.out.println(new FindMinimumInRotatedArray().findMinimum(A, 0, A.length-1));
    }
}
