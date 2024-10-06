package com.globalsoftwaresupport;

public class Node<T> {

	private T data;
	private Node<T> rightChild;
	private Node<T> leftChild;
	private Node<T> parentNode;
	private NodeColor color;
	
	public Node(T data, Node<T> parentNode) {
		this.data = data;
		this.parentNode = parentNode;
		// the default color is RED
		this.color = NodeColor.RED;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node<T> parentNode) {
		this.parentNode = parentNode;
	}

	public NodeColor getColor() {
		return color;
	}

	public void setColor(NodeColor color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "" + data;
	}
}
