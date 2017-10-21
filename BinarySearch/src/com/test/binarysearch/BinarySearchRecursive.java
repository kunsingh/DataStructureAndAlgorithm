package com.test.binarysearch;

public class BinarySearchRecursive {

    public int binarySearchRecursive(int[] A, int start, int end, int value){
        if(start <= end){
            int mid = (start + end) >>> 1;
            if(A[mid] == value){
                return mid;
            }
            
            if(A[mid] < value){
                return binarySearchRecursive(A, mid+1, end, value);
            }else{
                return binarySearchRecursive(A, start, mid-1, value);
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] A = {3, 5, 6, 8, 10, 14, 18, 19, 20};
        System.out.println(new BinarySearchRecursive().binarySearchRecursive(A, 0, A.length, 8));
        System.out.println(new BinarySearchRecursive().binarySearchRecursive(A, 0, A.length, 15));
        System.out.println(new BinarySearchRecursive().binarySearchRecursive(A, 0, A.length, 19));
    }
}
