package com.test.arrayandnumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSelect {

    public static int getKthLargestElement(List<Integer> A, int k) {

        int pivot = A.get(A.size() - 1);
        List<Integer> A1 = new ArrayList<Integer>();
        List<Integer> A2 = new ArrayList<Integer>();

        for (int i : A) {
            if (i < pivot) {
                A1.add(i);
            } else {
                A2.add(i);
            }
        }
        if (k <= A1.size()) {
            return getKthLargestElement( A1, k);
        } else if (k > A.size() - A2.size()) {
            return getKthLargestElement(A2, k - (A.size() - A2.size()));
        } else {
            return pivot;
        }
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<Integer>();
        A.add(4);
        A.add(2);
        A.add(8);
        A.add(9);
        A.add(3);
        A.add(7);
        A.add(6);
        A.add(10);
        
        System.out.println(getKthLargestElement(A,4));
        
        Collections.sort(A);
        for(int i:A){
            System.out.print(i+" ");
        }
        
        

    }
}
