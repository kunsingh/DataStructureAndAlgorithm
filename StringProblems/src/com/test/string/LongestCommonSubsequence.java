package com.test.string;

public class LongestCommonSubsequence {
    
    static String longestCommonSubsequence(String A, String B) {
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
    
    public static void main(String[] args) {
        try {
            String A = "ABAZDC";
            String B = "BACBAD";
            String ans = longestCommonSubsequence(A, B);
            System.out.println(ans);
        } catch (Exception ee) {
            System.out.println("Problem in Computation");
        }
    }
}
