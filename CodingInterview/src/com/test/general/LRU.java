package com.test.general;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LRU<K, V> {

    // Maximum capacity for the LRU cache.
    private final int capacity;
    // Queue to store the recently used keys.
    private ConcurrentLinkedQueue<K> queue;
    // Key-Value store to maintain the actual object.
    private ConcurrentHashMap<K, V> map;

    public LRU(final int capacity) {
        this.capacity = capacity;
        this.queue = new ConcurrentLinkedQueue<K>();
        this.map = new ConcurrentHashMap<K, V>(capacity);
    }

    public V get(final K key) {
        return map.get(key);
    }

    public synchronized void put(final K key, final V value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        if (map.containsKey(key)) {
            queue.remove(key);
        }
        while (queue.size() >= capacity) {
            K expiredKey = queue.poll();
            if (expiredKey != null) {
                map.remove(expiredKey);
            }
        }
        queue.add(key);
        map.put(key, value);
    }
    
    
    public static void main(String[] args) {
        LRU<Integer,Integer> lru = new LRU<>(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(5, 5);
        lru.put(6, 6);
        lru.put(7, 7);
        lru.put(8, 8);
        
        for(int i=1;i<=8;i++){
            System.out.println(lru.get(i));
        }
    }
    

}
