package com.test.binarysearch;

public class FindNoOfOccurrenceOfNumberInSortedArrayWithDuplicate {

    public int findNumberOfOccurrence(int[] A, int start, int end, int value){
        FindFirstInstanceOfNumberInSortedArrayWithDuplicates firstPositionFinder = new FindFirstInstanceOfNumberInSortedArrayWithDuplicates();
        FindLasttInstanceOfNumberInSortedArrayWithDuplicates lastPositionFinder = new FindLasttInstanceOfNumberInSortedArrayWithDuplicates();
        int startPosition = firstPositionFinder.findFirstOccurrence(A, start, end, value);
        int lastPosition = lastPositionFinder.findLastOccurrence(A, start, end, value);
        return startPosition != -1?(lastPosition - startPosition) + 1: -1;
    }
    
    public static void main(String[] args) {
        int[] A = { 3, 8, 8, 8, 10, 14, 18, 18, 20 };
        System.out.println(new FindNoOfOccurrenceOfNumberInSortedArrayWithDuplicate().findNumberOfOccurrence(A, 0, A.length-1, 8));
        System.out.println(new FindNoOfOccurrenceOfNumberInSortedArrayWithDuplicate().findNumberOfOccurrence(A, 0, A.length-1, 10));
        System.out.println(new FindNoOfOccurrenceOfNumberInSortedArrayWithDuplicate().findNumberOfOccurrence(A, 0, A.length-1, 18));
        System.out.println(new FindNoOfOccurrenceOfNumberInSortedArrayWithDuplicate().findNumberOfOccurrence(A, 0, A.length-1, 5));
    }
}
