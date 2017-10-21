package com.test.general;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class LRUCache {

    private static final int MAX_ENTRIES = 3;

    Map<Integer, Integer> m = new LinkedHashMap<Integer, Integer>(MAX_ENTRIES) {

        /*
         * Override this , if it returns true the eldest entry in the map is
         * removed
         */
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return m.size() > MAX_ENTRIES;
        }
    };

    // model function
    int getValue(int x) {
        return ++x;
    }

    // to get value from cache
    private int getCacheValue(int x) {
        return m.get(x);
    }

    int get(int x) {
        int result = 0;
        if (m.containsKey(x)) {
            result = getCacheValue(x);

        } else {
            result = getValue(x);
            m.put(x, result);
        }
       
        return result;
    }
    
    public void put(int x, int v){
        m.put(x, v);
    }
    public static void main(String[] args) {
        LRUCache obj = new LRUCache();
        for (int i = 1; i <= 5; i++) {
                obj.get(i);
                System.out.println(obj.m);
        }
        
}


}
