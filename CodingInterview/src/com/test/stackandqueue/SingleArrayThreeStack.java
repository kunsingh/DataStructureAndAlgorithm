package com.test.stackandqueue;

public class SingleArrayThreeStack {

	public int start;
	public int pointer;
	public int size;
	public int capacity;

	public SingleArrayThreeStack(int start, int capacity) {
		this.start = start;
		this.capacity = capacity;
		pointer = start - 1;
	}

	public boolean isWithinStack(int index, int totalSize) {
		if (start <= index && index < start + capacity) {
			return true;
		}else if(start+capacity > totalSize){
			return true;
		}
		return true;
	}
}
