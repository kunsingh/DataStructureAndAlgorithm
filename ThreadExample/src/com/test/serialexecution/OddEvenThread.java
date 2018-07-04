package com.test.serialexecution;

import java.util.ArrayList;
import java.util.List;

public class OddEvenThread {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		new Thread(new EvenThread(list, 100)).start();
		new Thread(new OddThread(list, 100)).start();
	}
}

class OddThread implements Runnable {

	private List<Integer> list;
	private final int upto;

	public OddThread(final List<Integer> list, final int upto) {
		this.list = list;
		this.upto = upto;
	}

	@Override
	public void run() {
		synchronized (list) {
			while (list.size() <= upto) {
				if (list.size() % 2 != 0) {
					System.out.println("Odd: " + list.size());
					list.add(list.size());
					list.notify();
				} else {
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}

class EvenThread implements Runnable {

	private List<Integer> list;

	private final int upto;

	public EvenThread(final List<Integer> list, final int upto) {
		this.list = list;
		this.upto = upto;
	}

	@Override
	public void run() {

		synchronized (list) {
			while (list.size() <= upto) {
				if (list.size() % 2 == 0) {
					System.out.println("Even: " + list.size());
					list.add(list.size());
					list.notify();
				} else {
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
