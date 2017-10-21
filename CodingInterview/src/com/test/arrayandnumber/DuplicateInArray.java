package com.test.arrayandnumber;

public class DuplicateInArray {

	public static int findDuplicate(int[] n){
		int sumOfArrayElement=0;
		for(int i=0;i<n.length;i++){
			sumOfArrayElement= sumOfArrayElement + n[i];
		}
		int sumTotal = ((n.length - 1) * (n.length - 2)) >> 1;
		return sumOfArrayElement-sumTotal;
	}
	
	public static void main(String[] args) {
		int[] n={0,1,2,3,4,5,6,6,8,9};
		System.out.println(DuplicateInArray.findDuplicate(n));
	}
}
