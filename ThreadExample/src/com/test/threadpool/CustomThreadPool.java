package com.test.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

    private BlockingQueue<Runnable> taskQueue;
    List<WorkerThread> workerThreads = new ArrayList<>();
    private boolean isStopped = false;
    
    public CustomThreadPool(final int noOfThreads) {
        taskQueue = new LinkedBlockingQueue<>(noOfThreads);
        for (int i = 0; i < noOfThreads; i++) {
            workerThreads.add(new WorkerThread(taskQueue));
        }
        
        for(WorkerThread thread: workerThreads){
            thread.start();
        }
    }
    
    public synchronized void  execute(Runnable task) throws Exception{
        if(this.isStopped) throw
            new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.add(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(WorkerThread thread : workerThreads){
           thread.doStop();
        }
    }
}
