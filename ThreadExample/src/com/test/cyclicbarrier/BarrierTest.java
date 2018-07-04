package com.test.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierTest implements Runnable {

	private CyclicBarrier cyclicBarrier;

	public BarrierTest(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {

		try {
			System.out.println(Thread.currentThread().getName() + " is waiting");
			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
		} catch (InterruptedException | BrokenBarrierException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {

			@Override
			public void run() {
				System.out.println("Reached to BARRIER");
			}
		});

		Thread t1 = new Thread(new BarrierTest(cyclicBarrier), "Thread-1");
		Thread t2 = new Thread(new BarrierTest(cyclicBarrier), "Thread-2");
		Thread t3 = new Thread(new BarrierTest(cyclicBarrier), "Thread-3");

		t1.start();
		t2.start();
		t3.start();
	}
}
