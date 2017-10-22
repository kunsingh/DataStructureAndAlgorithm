package com.test.string;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String s1, String s2){
        
        int length = Math.min(s1.length(), s2.length());
        for(int i =0; i < length; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                return s1.substring(0, i);
            }
        }
        return s1.substring(0, length);
    }
    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix("hellf", "hellous"));
    }
}
