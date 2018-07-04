package com.test.serialexecution;

public class SerialCounter implements Runnable{

    private int count = 0;
    
    @Override
    public void run() {
       incrementCounter();
        
    }

    private synchronized void incrementCounter() {
        count++;
        System.out.println("Thread Name :"+ Thread.currentThread().getName()+" Count: "+count);
    }
    
    public static void main(String[] args) throws Exception{
        SerialCounter  count = new SerialCounter();
        Thread t1 = new Thread(count);
        t1.setName("1");
        Thread t2 = new Thread(count);
        t2.setName("2");
        Thread t3 = new Thread(count);
        t3.setName("3");

       
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }

}
