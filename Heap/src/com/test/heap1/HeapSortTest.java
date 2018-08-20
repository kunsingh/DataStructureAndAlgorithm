package com.test.heap1;


public class HeapSortTest {

	public static void main(String[] args) {
		Heap heap = new Heap(10);
		heap.insert(14);
		heap.insert(11);
		heap.insert(58);
		heap.insert(38);
		heap.insert(21);
		heap.insert(10);
		heap.insert(29);
		heap.insert(13);
		heap.insert(11);
		heap.insert(37);
		heap.displayHeap();
		while(!heap.isEmpty()){
			System.out.print(heap.remove().getKey()+" ");
		}
	}
}
