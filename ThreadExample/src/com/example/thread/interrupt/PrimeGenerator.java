package com.example.thread.interrupt;

public class PrimeGenerator extends Thread{

    @Override
    public void run() {
        long number = 1l;
        while(true){
            if(isPrime(number)){
                System.out.printf("Number %d is prime", number);
                System.out.println();
                if(interrupted()){
                    System.out.println("The Thread is interrupted");
//                    return;
                }
                try{
                    Thread.sleep(500);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if(number <=2){
            return true;
        }
        for(int i=2 ; i<= number/2;i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Thread primeGeneratorThread = new PrimeGenerator();
        primeGeneratorThread.start();
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        primeGeneratorThread.interrupt();
    }
    
}
