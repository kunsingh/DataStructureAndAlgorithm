package com.test.semaphore;

import java.util.concurrent.Semaphore;

//At a time only 2 threads will enter to critical section
public class SemaphoreTest {
    Semaphore binary = new Semaphore(1);

    public static void main(String args[]) {
        final SemaphoreTest test = new SemaphoreTest();
        new Thread() {
            @Override
            public void run() {
                test.mutualExclusion();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                test.mutualExclusion();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                test.mutualExclusion();
            }
        }.start();

    }

    // critical section code
    private void mutualExclusion() {
        try {
            binary.acquire();
            // mutual exclusive region
            System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
            Thread.sleep(1000);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            binary.release();
            System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
        }
    }

}
