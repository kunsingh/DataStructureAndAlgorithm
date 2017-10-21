package com.test.maccontinuoussum;

public class MaxContinuousSum {

    
    public static int getMaxContinuousSum1(int[] A){
        int maxSum = 0;
        int sum = 0;
        for(int i=0;i<A.length;i++){
            sum = sum + A[i];
            if(sum < 0){
                sum = 0;
                continue;
            }
            if(maxSum < sum){
                maxSum = sum;
            }
        }
        
        return maxSum;
    }
    //Actual
    public static int largestContinuousSum1(int[] A) {
        assert A.length > 0 : "Empty array.";
        int maxSum = A[0];
        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            sum = Math.max(sum + A[i], A[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] A={-2,11,-4,13,-5,2};
        System.out.println(largestContinuousSum1(A));
        int[] A1={1,-3,4,-2,-1,6};
        System.out.println(largestContinuousSum1(A1)); 
    }
}
