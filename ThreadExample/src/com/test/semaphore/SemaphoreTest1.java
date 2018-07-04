package com.test.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest1 {

    Semaphore aArrived = new Semaphore(0);
    Semaphore bArrived = new Semaphore(0);

    public SemaphoreTest1() {
        new Thread(new ThreadB()).start();
        new Thread(new ThreadA()).start();

    }

    class ThreadA implements Runnable {
        @Override
        public void run() {
            System.out.println("Statement A1");
            aArrived.release();
            try {
                bArrived.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Statement A2");
        }
    }

    class ThreadB implements Runnable {
        @Override
        public void run() {
            System.out.println("Statement B1");
            bArrived.release();
            try {
                aArrived.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Statement B2");
        }
    }

    public static void main(String[] args) {
        new SemaphoreTest1();
    }
}
