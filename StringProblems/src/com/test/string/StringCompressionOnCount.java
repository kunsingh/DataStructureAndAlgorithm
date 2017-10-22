package com.test.string;

public class StringCompressionOnCount {

    public static String compress(String str) {
        // int size = countCompression(str);
        // if(size>=str.length()){
        // return str;
        // }

        StringBuffer sb = new StringBuffer();
        char start = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == start) {
                count++;
            } else {
                sb.append(start).append(count);
                start = str.charAt(i);
                count = 1;
            }
        }
        sb.append(start).append(count);
        return sb.toString();

    }

    // private static int countCompression(String str) {
    // if(str == null || str.isEmpty()){
    // return 0;
    // }
    //
    // char last = str.charAt(0);
    // int size =0;
    // int count =1;
    //
    // for(int i=1;i<str.length();i++){
    // if(str.charAt(i)==last){
    // count++;
    // }else{
    // last = str.charAt(i);
    // size +=1+String.valueOf(count).length();
    // System.out.println(size);
    // count =1;
    // }
    // }
    // size +=1+String.valueOf(count).length();
    // System.out.println(">: "+size);
    // return size;
    // }

    public static void main(String[] args) {
        System.out.println(compress("aabbccddeefggggg"));
    }
}
