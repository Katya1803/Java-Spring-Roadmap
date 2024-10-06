package com.globalsoftwaresupport;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class App {

	public static void main(String[] args) {
		
		// by default the heap is MIN HEAP
		Queue<Person> heap = new PriorityQueue<>();
		
		// O(logN)
		heap.add(new Person("aa", 34));
		heap.add(new Person("ssss", 12));
		heap.add(new Person("dddd", 67));
		heap.add(new Person("Adrrrram", 18));
		heap.add(new Person("rrr", 52));
		heap.add(new Person("Micrrrrrrrhael", 23));
		
		
		// when we consider all N items in O(logN) = O(NlogN)
		while(!heap.isEmpty())
			// O(logN)
			System.out.println(heap.poll());
		
	}

}
