package com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		Heap heap = new Heap();
		
		for(int i=0;i<10000;i++)
			heap.insert(i);
	
		heap.heapSort();

		
	}

}
