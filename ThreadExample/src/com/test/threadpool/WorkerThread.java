package com.test.threadpool;

import java.util.concurrent.BlockingQueue;

public class WorkerThread extends Thread {

    private BlockingQueue<Runnable> queue;
    private boolean isStopped = false;

    public WorkerThread(final BlockingQueue<Runnable> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while(!isStopped){
            try{
                Runnable runnable = queue.take();
                runnable.run();
            }catch(Exception ex){
                
            }
        }
    }
    
    public synchronized void doStop(){
        isStopped = true;
        this.interrupt();
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}
