package com.test.longestcommonsubsequence;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static int getLongestSubsequence(String S1, String S2) {
        if (S1.length() > 0 && S2.length() > 0) {
            int[][] LCS = new int[S1.length()][S2.length()];
            LCS[0][0] = 0;
            for (int i = 1; i < S1.length(); i++) {
                for (int j = 1; j < S2.length(); j++) {
                    if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                        System.out.print(S1.charAt(i - 1));
                        LCS[i][j] = 1 + LCS[i - 1][j - 1];
                    }else{
                        LCS[i][j] = Math.max(LCS[i - 1][j],LCS[i][j-1]);
                    }
                }
                System.out.println(Arrays.toString(LCS));
            }
            return LCS[S1.length()-1][S2.length()-1];
        }

        return 0;
    }
    
    public static void main(String[] args) {
        
        System.out.println(LongestCommonSubsequence.getLongestSubsequence("abcbdab", "bdc"));
    }
}
