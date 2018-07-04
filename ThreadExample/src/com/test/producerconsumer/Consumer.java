package com.test.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getValue();
        
    }

    private void getValue() {
        int value = queue.poll();
        System.out.println(value);
        
    }
    
    
    
    
}
