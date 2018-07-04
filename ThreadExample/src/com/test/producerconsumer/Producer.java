package com.test.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
       
        putValue();
       
    }

    private void putValue() {
        //some code here to get the data
        queue.offer(5);//some value from file or keyboard
        
    }
    
    

    
}
