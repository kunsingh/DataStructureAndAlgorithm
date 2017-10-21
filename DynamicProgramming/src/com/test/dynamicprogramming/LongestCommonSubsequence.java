package com.test.dynamicprogramming;

public class LongestCommonSubsequence {

    static String longestIncreasingCommonSubsequence(String A, String B) {
        int[][] LCSArr = new int[A.length() + 1][B.length() + 1];
        StringBuilder sb = new StringBuilder();// just for the string
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    LCSArr[i][j] = 1 + LCSArr[i - 1][j - 1];
                    sb.append(A.charAt(i - 1));
                } else {
                    LCSArr[i][j] = Math.max(LCSArr[i][j - 1], LCSArr[i - 1][j]);
                }
            }
        }
        System.out.println(LCSArr[A.length()][B.length()]);
        return sb.toString();
    }

    public static String longestCommonSubString(String word1, String word2) {
        int max = 0;
        int index = 0;
        int[][] lcsarr = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); ++i) {
            for (int j = 0; j <= word2.length(); ++j) {
                if (i == 0 || j == 0) {
                    lcsarr[i][j] = 0;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        lcsarr[i][j] = lcsarr[i - 1][j - 1] + 1;
                    } else {
                        lcsarr[i][j] = 0;
                    }
                }
                if (max < lcsarr[i][j]) {
                    max = lcsarr[i][j];
                    index = i;
                }
            }
        }
        System.out.println(max);
        String str = "";
        if (max == 0) {
            return "";
        } else {
            for (int i = index - max; i <= max; ++i) {
                str += word2.charAt(i);
            }
            return str;
        }
    }

    public static void main(String[] args) {
        try {
            String A = "abbcc";// "ABAZDC";
            String B = "dbbcc";// "BACBAD";
            String ans = longestIncreasingCommonSubsequence(A, B);
            System.out.println(ans);
        } catch (Exception ee) {
            System.out.println("Problem in Computation");
        }
    }
}
