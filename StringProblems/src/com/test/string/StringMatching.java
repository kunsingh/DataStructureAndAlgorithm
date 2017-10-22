package com.test.string;

public class StringMatching {

    public static int bruteForceStringMatch(String text, String pattern) {
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int j = 0;
            while (j < pattern.length() && pattern.charAt(j) == text.charAt(i + j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(StringMatching.bruteForceStringMatch("kunal", "l"));
    }
}
