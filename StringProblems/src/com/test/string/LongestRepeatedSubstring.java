package com.test.string;

import java.util.Collections;
import java.util.List;

public class LongestRepeatedSubstring {

    private SuffixGenerator suffixGenerator = new SuffixGenerator();
    private LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
    public String longestRepeatedSubstring(String s1){
        int length = s1.length();
        List<String> suffixes = suffixGenerator.getSuffixes(s1);
        Collections.sort(suffixes);
        String longestSubString = "";
        
        for(int i =0; i< length-1; i++){
            String tempString = longestCommonPrefix.longestCommonPrefix(suffixes.get(i), suffixes.get(i+1));
            if(tempString.length() > longestSubString.length()){
                longestSubString = tempString;
            }
        }
        return longestSubString;
    }
    public static void main(String[] args) {
        System.out.println(new LongestRepeatedSubstring().longestRepeatedSubstring("HellofortheHelloWorld"));
    }
}
