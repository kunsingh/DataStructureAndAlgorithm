package com.test.stockbuyandsale;

public class MaximumDifference {

    public int findMaxDifference(int[] A){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        int maxPos = 0;
        for(int i = 0; i< A.length ;i++){
            if(A[i] > max){
                max = A[i];
                maxPos = i;
            }
        }
       
        for(int i = 0; i< maxPos ;i++){
            if(A[i] < min ){
                min = A[i];
            }
        }
        
        return maxPos > 0? max - min:0;
    }
    
    public static void main(String[] args) {
        MaximumDifference difference = new MaximumDifference();
        int A[] = { 110, 100,  90, 2};
        System.out.println(difference.findMaxDifference(A));
    }
}
