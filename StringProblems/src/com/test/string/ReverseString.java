package com.test.string;

public class ReverseString {

    public static void reverse(String src){
        String[] str = src.split(" ");
        for(String s:str){
            System.out.println(s+" ");
        }
    }
    public static void main(String[] args) {
        reverse("I am a good boy");
    }
}
