package com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		BinarySearchTree<Person> bst = new BinarySearchTree<>();
		
		bst.insert(new Person(12, "Adam"));
		bst.insert(new Person(5, "Kevin"));
		bst.insert(new Person(78, "Ana"));
		bst.insert(new Person(56, "Michael"));
		bst.insert(new Person(34, "Daniel"));
		bst.insert(new Person(41, "Bill"));
		
		bst.traversal();
		

	}
}
