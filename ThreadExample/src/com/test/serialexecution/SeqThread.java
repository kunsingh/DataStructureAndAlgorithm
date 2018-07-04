package com.test.serialexecution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SeqThread {

    Runnable R1 = new Runnable() {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("In Thread One= " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    Runnable R2 = new Runnable() {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("In Thread Two= " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public void execute() {
        try {
            ExecutorService executor = Executors.newCachedThreadPool();
            executor.submit(R1);
            executor.submit(R2);
            executor.shutdown();

            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SeqThread().execute();
    }
}
