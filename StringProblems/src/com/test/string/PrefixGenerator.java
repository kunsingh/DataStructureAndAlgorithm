package com.test.string;

import java.util.ArrayList;
import java.util.List;

public class PrefixGenerator {

    public List<String> getPrefixes(String s){
        
        List<String> prefixes = new ArrayList<>();
        
        for(int i=1; i<s.length();i++){
            prefixes.add(s.substring(0,i));
        }
        return prefixes;
    }
    
    public static void main(String[] args) {
        List<String> prefixes = new PrefixGenerator().getPrefixes("Hellou");
        for(String s:prefixes){
            System.out.println(s);
        }
        
    }
}
