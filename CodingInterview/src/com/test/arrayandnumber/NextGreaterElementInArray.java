package com.test.arrayandnumber;

public class NextGreaterElementInArray {

    public static void getImmediateGreaterElementInArray(int[] A){
        
        for(int i=0; i< A.length - 1; i++){
            
            int j = i+1;
            while(j< A.length){
                if(A[i] < A[j]){
                    System.out.println(A[i] +"-----"+A[j]);
                    break;
                }
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int[] A = {5, 3, 7, 10, 8, 11, 9, 12, 13, 4};
        getImmediateGreaterElementInArray(A);
    }
}
