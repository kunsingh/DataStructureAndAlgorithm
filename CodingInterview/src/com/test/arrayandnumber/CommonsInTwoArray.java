package com.test.arrayandnumber;

public class CommonsInTwoArray {

	public static void findCommons(int[] A1, int[] A2){
		int i=0,j=0;
		while(i<A1.length && j<A2.length){
			if(A1[i] > A2[j]){
				j++;
			}else if(A1[i]<A2[j]){
				i++;
			}else{
				System.out.print(A1[i]+" ");
				i++;
				j++;
			}
		}
	}
	public static void main(String[] args) {
		int[] A1={0,4,5,6,9,18,36,80};
		int[] A2={5,6,8,9,12,13,17,18,19,20,80};
		CommonsInTwoArray.findCommons(A1, A2);
	}
	
}
