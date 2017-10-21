package com.test.arrayandnumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MaxOccorrenceFinder {

    Map<Integer, Integer> occurrenceCountMap = new HashMap<Integer, Integer>();

    public void getMaxOccurrenceAndHowManyTimes(int[] A) {
        assert A != null && A.length > 0 : " There should be valid array to find the occurrence";

        for (int i : A) {
            if (occurrenceCountMap.containsKey(i)) {
                int count = occurrenceCountMap.get(i);
                occurrenceCountMap.put(i, count + 1);
            } else {
                occurrenceCountMap.put(i, 1);
            }
        }

        Set<Entry<Integer, Integer>> entrySet = occurrenceCountMap.entrySet();
        List<Entry<Integer, Integer>> list = new ArrayList<>(entrySet);

        Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {

            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        
        System.out.println("Max occurred value - times :"+ list.get(list.size()-1).getKey()+" - "+list.get(list.size()-1).getValue());

    }
    
    
    public static void main(String[] args) {
        int[] A={1,2,3,4,4,5,5,6,5,8,5,9,5};
        new MaxOccorrenceFinder().getMaxOccurrenceAndHowManyTimes(A);
    }

}
