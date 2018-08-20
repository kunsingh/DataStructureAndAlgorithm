package com.test.volatiletest;

import java.util.ArrayList;
import java.util.List;

public class NeedForVolatile {

    private static volatile boolean running = false;

    public static void main(String[] args) throws Exception {
        List<Object> list = new ArrayList<>();
        list.add(5);
        list.add("kk");
        list.add(12.5);
        Thread t1 =  new Thread(new Runnable() {

            @Override
            public void run() {
                while (!running) {
                }
                System.out.println("started");

                while (running) {
                }
                System.out.println("Stopped");
            }
        });
        t1.start();
        Thread.sleep(1000);
        System.out.println("Starting....");
        running = true;
        Thread.sleep(1000);
        System.out.println("Stoping....");
        running = false;
    }
}
