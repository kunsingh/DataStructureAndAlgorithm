package com.test.arrayandnumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortArrayAsPerFrequency {

    public int[] sort(int[] A){
        Map<Integer, FrequencyAndIndex> map = new HashMap<>();
        
        for(int i=0; i< A.length; i++){
            if(map.containsKey(A[i])){
                FrequencyAndIndex value = map.get(A[i]);
                value.frequency = value.frequency+1;
                map.put(A[i], value);
            }else{
                FrequencyAndIndex value = new FrequencyAndIndex(i, 1);
                map.put(A[i], value);
            }
        }
        
        List<Entry<Integer, FrequencyAndIndex>> list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Entry<Integer, FrequencyAndIndex>>() {

            @Override
            public int compare(Entry<Integer, FrequencyAndIndex> o1, Entry<Integer, FrequencyAndIndex> o2) {
                int k = o2.getValue().frequency - o1.getValue().frequency;
                if(k != 0) {
                    return k;
                }
                else
                {
                    return o1.getValue().index - o2.getValue().index;
                }
            }
        });
        int[] result = new int[A.length];
        int i = 0;
        
        for(Entry<Integer, FrequencyAndIndex> entry: list){
            int frequency = entry.getValue().frequency;
            int value = entry.getKey();
            for(int j=0;j<frequency;j++){
                result[i++] = value;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {5, 13, 6, 5, 13, 7, 8, 6, 5};
        int[] result = new SortArrayAsPerFrequency().sort(a);
        System.out.println(Arrays.toString(result));
    }
}

class FrequencyAndIndex{
    
    int index;
    int frequency;
    
    public FrequencyAndIndex(int index, int frequency) {
        this.index = index;
        this.frequency = frequency;
    }
    
    
}
