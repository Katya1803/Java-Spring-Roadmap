package com.globalsoftwaresupport;

import java.util.LinkedList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		LinkedList<String> dll = new LinkedList<>();
		
		dll.addLast("Kevin");
		dll.addLast("Daniel");
		dll.addLast("Ana");
		
		dll.removeLast();
		
		for(String name : dll)
			System.out.println(name);
		
		DoublyLinkedList<String> names = new DoublyLinkedList<>();
		
		names.insert("Adam");
		names.insert("Kevin");
		names.insert("Ana");
		names.insert("Daniel");
		
		// names.traverseForward();

	}

}
