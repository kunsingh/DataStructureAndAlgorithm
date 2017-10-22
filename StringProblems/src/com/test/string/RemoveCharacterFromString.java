package com.test.string;

public class RemoveCharacterFromString {

    public static String removeChars( String str, String remove ){
        char[] s = str.toCharArray();
        char[] r = remove.toCharArray();
        
        boolean[] flags = new boolean[128];
        for(char c:r){
            flags[c] = true;
        }
        int i = 0;
        for(char c:s){
            if(!flags[c]){
                s[i++] = c;
            }
        }
        return new String(s,0,i);
    }
    public static void main(String[] args) {
        String result = removeChars("I am a good boy", "aeiou");
        System.out.println(result);
    }
}
