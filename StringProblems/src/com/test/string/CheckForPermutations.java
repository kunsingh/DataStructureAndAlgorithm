package com.test.string;

public class CheckForPermutations {

    private static final int[] intArray = new int[256];

    public static boolean checkForPermutation(String src, String target) {

        assert src.length() == target.length() : "Strings should be of equal length";

        for (int i = 0; i < src.length(); i++) {
            intArray[src.charAt(i)]++;
        }

        for (int i = 0; i < target.length(); i++) {
            if (--intArray[target.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkForPermutation("kunal", "lanuk"));
    }
}
