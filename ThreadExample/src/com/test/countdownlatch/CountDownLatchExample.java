package com.test.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements Runnable{

    private int id;
    private CountDownLatch latch;
    private Random random;
    
    public Worker(int id, CountDownLatch latch){
        this.id = id;
        this.latch = latch;
        random = new Random();
    }
    @Override
    public void run() {
        doWork();
        this.latch.countDown();
        System.out.println("dddd");
    }
    private void doWork() {
        try{
            System.out.println("Thread with id: "+this.id+" starts working....");
            Thread.sleep(random.nextInt(1000));
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    
}
public class CountDownLatchExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CountDownLatch latch = new CountDownLatch(5);
        for(int i=0;i<5;i++){
            executorService.execute(new Worker(i+1, latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("All are finished.....");
        executorService.shutdown();
    }
}
