package com.test.avoid.deadlock;


public class AccountWithoutDeadlock {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

   
    private static class Thread1 implements Runnable {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1- taken lock1");
                depositeAmount();
            }
            System.out.println("Thread 1- releasing lock1");

            synchronized (lock2) {
                System.out.println("Thread 1- taken lock2");
                printReport();
            }
            System.out.println("Thread 1- releasing lock2");

        }
    }

    private static class Thread2 implements Runnable {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 2- taken lock2");
                printReport();
            }
            System.out.println("Thread 2- releasing lock2");

            synchronized (lock1) {
                System.out.println("Thread 2- taken lock1");
                depositeAmount();
            }
            System.out.println("Thread 2- releasing lock1");

        }
    }

    private static void depositeAmount() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Depositing amount");
    }

    private static void printReport() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("printing report....");
    }

    public static void main(String[] args) {
        Thread T1 = new Thread(new Thread1());
        Thread T2 = new Thread(new Thread2());
        T1.start();
        T2.start();
    }

}
