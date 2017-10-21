package com.test.binarysearch;

public class FindNumberInRotatedArray {

    public int findNumber(int[] A, int start, int end, int value){
        
        while(start < end){
            int mid = (start + end) >>> 1;
            if(A[mid] ==  value){
                return mid;
            }
            //if lower part is sorted
            if(A[start] <= A[mid]){
                if(A[start] <= value && A[mid] > value){
                    end = mid -1;
                }else{
                    start = mid +1;
                }
            }
            
           //if upper part is sorted
           if(A[mid] <= A[end]){
               if(A[mid] <= value && A[end] > value){
                   start = mid + 1;
               }else{
                   end = mid -1;
               }
           }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] A = {18, 19, 20, 25, 5, 6, 8, 10, 14};
        System.out.println(new FindNumberInRotatedArray().findNumber(A, 0, A.length-1, 10));   
    }
}
