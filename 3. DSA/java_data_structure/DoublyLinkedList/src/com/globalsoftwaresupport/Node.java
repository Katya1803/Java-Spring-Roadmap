package com.globalsoftwaresupport;

public class Node<T extends Comparable<T>> {
	
	private T data;
	// this is even more memory heavy than singly linked lists
	private Node<T> previousNode;
	private Node<T> nextNode;
	
	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node<T> previousNode) {
		this.previousNode = previousNode;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return "" + data;
	}	
}
