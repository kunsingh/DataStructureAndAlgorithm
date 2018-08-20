package com.test.heap;

public class LeastNumbersFinder {

    public static int[] getLeastNumbers(int[] input, int k) {
        // if required number of least items is less than the given
        // array, return array itself
        if (input.length <= k) {
            return input;
        }
        int[] output = new int[k];
        MinHeap minHeap = new MinHeap(input.length);
        // insert the array element to the minHeap
        for (int key : input) {
            minHeap.insertKey(key);
        }
        // Top will be always the minimum, extract up to required number
        for (int i = 0; i < k; i++) {
            output[i] = minHeap.extractMin();
        }
        return output;
    }

    public static int[] getLKLargestNumber(int[] input, int k) {
        // if required number of least items is less than the given
        // array, return array itself
        if (input.length <= k) {
            return input;
        }
        int[] output = new int[k];
        MinHeap minHeap = new MinHeap(input.length);
        // insert the array element to the minHeap
        for (int i = 0; i < input.length; i++) {
            if (minHeap.size() < k) {
                minHeap.insertKey(input[i]);
            } else {
                if (minHeap.peek() < input[i]) {
                    minHeap.extractMin();
                    minHeap.insertKey(input[i]);
                }
            }
        }
        // Top will be always the minimum, extract up to required number
        for (int i = 0; i < minHeap.size(); i++) {
            output[i] = minHeap.get(i);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] array = { 1, 8, 9, 15, 20, 35, 2, 10, 14, 3, 4, 7, 16 };
        int[] output = LeastNumbersFinder.getLKLargestNumber(array, 5);
        for (int key : output) {
            System.out.print(key + " ");
        }
    }
}