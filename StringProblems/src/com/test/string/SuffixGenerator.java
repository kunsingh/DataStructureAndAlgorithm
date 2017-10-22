package com.test.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuffixGenerator {

    public List<String> getSuffixes(String s){
        
        List<String> suffixes = new ArrayList<>();
        int n = s.length();
        for(int i=1; i<=s.length();i++){
            suffixes.add(s.substring(n-i,n));
        }
        return suffixes;
    }
    
    public static void main(String[] args) {
        List<String> suffixes = new SuffixGenerator().getSuffixes("Hellou");
        Collections.sort(suffixes);
        for(String s:suffixes){
            System.out.println(s);
        }
        
    }
}
