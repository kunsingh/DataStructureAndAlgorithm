package com.test.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

class FillingWorker implements Runnable{

    private List<Integer> currentBuffer;
    private int counter;
    private Exchanger<List<Integer>> exchanger;
    
    public FillingWorker(Exchanger<List<Integer>> exchanger){
        this.exchanger = exchanger;
        this.counter = 0;
        this.currentBuffer = new ArrayList<>();
    }
    @Override
    public void run() {
        while(true){
            if(this.currentBuffer.size() == 10){
                System.out.println("FillingWorke to EmptyWorker: "+this.currentBuffer.size());
                try {
                    currentBuffer = exchanger.exchange(this.currentBuffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            currentBuffer.add(counter++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}

class EmptyingWorker implements Runnable{

    private List<Integer> currentBuffer;
    private Exchanger<List<Integer>> exchanger;
    
    public EmptyingWorker(Exchanger<List<Integer>> exchanger){
        this.exchanger = exchanger;
        this.currentBuffer = new ArrayList<>();
        this.currentBuffer.add(10);
        this.currentBuffer.add(20);
        this.currentBuffer.add(30);
    }
    @Override
    public void run() {
        while(true){
            if(this.currentBuffer.isEmpty()){
                System.out.println("EmptyWorker to FillingWorker: "+this.currentBuffer.size());
                try {
                    currentBuffer = exchanger.exchange(this.currentBuffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            currentBuffer.remove(0);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<List<Integer>> exchanger = new Exchanger<>();
        new Thread(new FillingWorker(exchanger)).start();
        new Thread(new EmptyingWorker(exchanger)).start();
    }
}
