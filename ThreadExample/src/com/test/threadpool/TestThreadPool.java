package com.test.threadpool;

public class TestThreadPool {

    public static void main(String[] args) throws Exception {
        CustomThreadPool threadPool=new CustomThreadPool(5); //create 2 threads in ThreadPool 
        for(int i=0; i<10;i++){
            Runnable task= new Task();
            threadPool.execute(task);
        }
//        threadPool.stop();
 }
}

class Task implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " is executing task.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
};