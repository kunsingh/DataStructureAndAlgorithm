package com.test.arrayandnumber;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthElementInArray {

    public int findKthElementInArray(int[] A, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(A.length, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i : A) {
            priorityQueue.add(i);
        }
        for (int i = 0; i < k - 1; i++) {
            priorityQueue.poll();
        }
        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        int[] A = { 10, 3, 7, 11, 4, 5, 2, 6, 8 };
        int value = new KthElementInArray().findKthElementInArray(A, 3);
        System.out.println(value);
    }
}
