package com.test.binarysearch;

public class FindLasttInstanceOfNumberInSortedArrayWithDuplicates {
 public int findLastOccurrence(int[] A, int start, int end, int value){
        
        while(start <= end){
            int mid = (start + end) >>> 1;
            
            if(A[mid] == value && ((mid == end) || (A[mid+1] > A[mid]))){
                return mid;
            }
            
            if(value >= A[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] A = { 3, 8, 8, 8, 10, 14, 18, 18, 20 };
        System.out.println(new FindLasttInstanceOfNumberInSortedArrayWithDuplicates().findLastOccurrence(A, 0, A.length-1, 8));
        System.out.println(new FindLasttInstanceOfNumberInSortedArrayWithDuplicates().findLastOccurrence(A, 0, A.length-1, 15));
        int[] A1 = { 8, 8, 8, 8, 10, 10, 10, 10, 10 };
        System.out.println(new FindLasttInstanceOfNumberInSortedArrayWithDuplicates().findLastOccurrence(A1, 0, A1.length-1, 8));
        System.out.println(new FindLasttInstanceOfNumberInSortedArrayWithDuplicates().findLastOccurrence(A1, 0, A1.length-1, 10));
    }
}
