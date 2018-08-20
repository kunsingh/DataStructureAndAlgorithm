package com.test.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class MedianFinder {

    // By default priority queue is MinHeap in java
    private PriorityQueue<Integer> maxHeap, minHeap;

    private static final int INITIAL_CAPACITY = 10;

    public MedianFinder() {
        // Nothing to do for minHeap
        minHeap = new PriorityQueue<Integer>(INITIAL_CAPACITY);

        // To act like a max heap, reverse the default behavior with comparator
        maxHeap = new PriorityQueue<>(INITIAL_CAPACITY, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return (i1 > i2 ? -1 : (i1 == i2 ? 0 : 1));
            }
        });
    }

    public void addNewNumber(int randomNumber) {
        if (maxHeap.size() == minHeap.size()) {
            if ((minHeap.peek() != null) && randomNumber > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(randomNumber);
            } else {
                maxHeap.offer(randomNumber);
            }
        } else {
            if (randomNumber < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(randomNumber);
            } else {
                minHeap.offer(randomNumber);
            }
        }
    }

    public double getMedian() {
        if (maxHeap.isEmpty())
            return minHeap.peek();
        else if (minHeap.isEmpty())
            return maxHeap.peek();
        if (maxHeap.size() == minHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    // Generate some random numbers between 0 to 100
    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // between 0 to 100
        }
        return array;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        // If the number(N) of elements is Odd then median = (N+1)/2 th element
        System.out.println("------N is ODD------");
        int[] A1 = medianFinder.generateRandomArray(15);
        System.out.println("Array: " + Arrays.toString(A1));
        for (int a : A1) {
            medianFinder.addNewNumber(a);
        }
        System.out.println("Median is: " + medianFinder.getMedian());
        // Try to find median in sorted array
        Arrays.sort(A1);
        System.out.println("Sorted Array: " + Arrays.toString(A1));

        System.out.println("------N is EVEN------");
        // If the number(N) of elements is Even then median = AVG(N/2th, N/2th)
        // element
        medianFinder = new MedianFinder();
        int[] A2 = medianFinder.generateRandomArray(16);
        System.out.println("Array: " + Arrays.toString(A2));
        for (int a : A2) {
            medianFinder.addNewNumber(a);
        }
        System.out.println("Median is: " + medianFinder.getMedian());
        // Try to find median in sorted array
        Arrays.sort(A2);
        System.out.println("Sorted Array: " + Arrays.toString(A2));
    }
}
