package com.test.binarysearch;

import java.util.Arrays;
import java.util.List;

public class TestBattle {

    public String solution(int N, String S, String T) {
        // write your code in Java SE 8
        String[] shipPositions = S.split(",");
        List<String> hitPostion = Arrays.asList(T.split(" "));
        int shunkenShipCount = 0;
        int hitButNotShunkenCount = 0;
        boolean hitButNotShunken = false;
        for(int i=0;i< shipPositions.length;i++){
            String[] positions = shipPositions[i].split(" ");
            String startPost = positions[0];
            String endPost = positions[1];
            
            int startRow = Character.getNumericValue(startPost.charAt(0));
            
            int endRow = Character.getNumericValue(endPost.charAt(0));
            while(startRow <= endRow){
                char startColumn = startPost.charAt(1);
                
                char endColumn = endPost.charAt(1);
                while(startColumn++ < endColumn){
                    System.out.println(startRow+""+startColumn);
                    String nextPosition = startRow+""+startColumn;
                    if(!hitPostion.contains(nextPosition)){
                        hitButNotShunkenCount = hitButNotShunkenCount +1;
                        hitButNotShunken = true;
                        break;
                    }
                   
                }
                if(!hitButNotShunken){
                    shunkenShipCount = shunkenShipCount +1;
                }
                startRow++;
            }
        }
        
        
        return "";
    }
    
    public static void main(String[] args) {
        new TestBattle().solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A");
    }
}
