package com.test.dynamicprogramming;


public class SubRectangularMatrixWithMaximumSum {

    public Result maxSum(int input[][]) {
        Result result = new Result();

        int rows = input.length;
        int cols = input[0].length;

        int[] temp = new int[rows];

        for (int left = 0; left < cols; left++) {
            for (int i = 0; i < rows; i++) {
                temp[i] = 0;
            }
            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) {
                    temp[i] = temp[i] + input[i][right];
                }
                KadaneResult kadaneResult = maxArraySum(temp);
                if (kadaneResult.maxSum > result.maxSum) {
                    result.maxSum = kadaneResult.maxSum;
                    result.left = left;
                    result.right = right;
                    result.upBound = kadaneResult.lowerIndex;
                    result.rightBound = kadaneResult.upperIndex;
                }
            }
        }

        return result;
    }

    private KadaneResult maxArraySum(int arr[]){
        KadaneResult kadaneResult = new KadaneResult();
        int currentStart = 0;
        int maxSoFar =  arr[0];
        for(int i=1; i < arr.length; i++){
            maxSoFar = max(arr[i], maxSoFar + arr[i]);
            if(maxSoFar < 0){
                maxSoFar = 0;
                currentStart = i+1;
            }
            if(kadaneResult.maxSum < maxSoFar){
                kadaneResult.lowerIndex = currentStart;
                kadaneResult.upperIndex = i;
                kadaneResult.maxSum = maxSoFar;
                System.out.println(kadaneResult);
            }
            
        }
        
        return kadaneResult;
    }
    
    private int max(int value1, int value2) {
        return value1 > value2 ? value1 : value2;
    }

    public static void main(String args[]) {
        int input[][] = { 
                          { 2, 1, -3, -4, 5 }, 
                          { 0, 6, 3, 4, 1 }, 
                          { 2, -2, -1, 4, -5 }, 
                          { -3, 3, 1, 0, 3 } 
                        };
        SubRectangularMatrixWithMaximumSum saw = new SubRectangularMatrixWithMaximumSum();
        System.out.println(saw.maxSum(input));
    }

}

class Result {
    int maxSum;
    int left;
    int right;
    int upBound;
    int rightBound;

    @Override
    public String toString() {
        return "Result [maxSum=" + maxSum + ", left=" + left + ", right=" + right + ", upBound=" + upBound + ", rightBound=" + rightBound + "]";
    }
}

class KadaneResult {
    int maxSum;
    int lowerIndex;
    int upperIndex;
    
    public KadaneResult(){
        
    }
    public KadaneResult(int maxSum, int lowerIndex, int upperIndex) {
        this.maxSum = maxSum;
        this.lowerIndex = lowerIndex;
        this.upperIndex = upperIndex;
    }



    @Override
    public String toString() {
        return "KadaneResult [maxSum=" + maxSum + ", lowerIndex=" + lowerIndex + ", upperIndex=" + upperIndex + "]";
    }

}