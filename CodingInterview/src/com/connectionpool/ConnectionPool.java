package com.connectionpool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionPool<T1, T2> {

    private final int capacity;
    // just to maintain Least recently used
    private Queue<T1> queue;
    // data structure to hold the actual pool object
    private ConcurrentHashMap<T1, T2> map;

    public ConnectionPool(final int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<T1>();
        this.map = new ConcurrentHashMap<T1, T2>(capacity);
    }

    public T2 get(final T1 key) {
        return map.get(key);
    }

    public int size() {
        return map.size();
    }

    // not atomic operation- working on multiple data structure that's why
    // explicit synchronize
    public synchronized void put(final T1 key, final T2 value) {
        assert key == null || value == null : "key or value is null";

        while (queue.size() >= capacity) {
            T1 lastUsed = queue.poll();
            if (lastUsed != null) {
                map.remove(lastUsed);
            }
        }
        queue.add(key);
        map.put(key, value);
    }

}
