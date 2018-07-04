package com.test.create.deadlock;

public class AccountWithDeadlock {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    private static class Thread1 implements Runnable {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1- taken lock1");
                depositeAmount();
                System.out.println("Thread 1- Waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1- taken lock1 & lock2");
                    printReport();
                }
            }

        }
    }

    private static class Thread2 implements Runnable {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 2- taken lock2");
                printReport();
                System.out.println("Thread 2- Waiting for lock1");
                synchronized (lock1) {
                    System.out.println("Thread 2- taken lock1 & lock2");
                    depositeAmount();
                }
            }
        }
    }

    private static void depositeAmount() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Depositing amount");
    }

    private static void printReport() {
        System.out.println("printing report....");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("amount deposited");

    }

    public static void main(String[] args) {
        Thread T1 = new Thread(new Thread1());
        Thread T2 = new Thread(new Thread2());
        T1.start();
        T2.start();
    }

}
