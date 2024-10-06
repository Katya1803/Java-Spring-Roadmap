package com.globalsoftwaresupport;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;
	
	@Override
	public void insert(T data) {
		// this is when we insert the first node into the BST (parent is null)
		if(root==null) {
			root = new Node<>(data, null);
			settleViolations(root);
		} else {
			// there are already items in the BST
			insert(data, root);
		}
	}

	// O(logN)
	private void insert(T data, Node<T> node) {	
		// this is the case when the data is SMALLER than the value in the node
		// GO TO THE LEFT SUBTREE 
		if(node.getData().compareTo(data) > 0) {
			// there is a valid (not NULL) left child so we go there
			if( node.getLeftChild() != null ) {
				insert(data, node.getLeftChild());
			}	
			// the left child is a NULL so we create a left child
			else {
				Node<T> newNode = new Node<>(data, node);
				node.setLeftChild(newNode);
				// WE HAVE TO CHECK whether the red black properties are violated
				settleViolations(newNode);
			}			
		// this is the case when the data is GREATER than the value in the node
		// GO TO THE RIGHT SUBTREE
		} else {
			// there is a valid (not NULL) right child so we go there
			if( node.getRightChild() != null ) {
				insert(data, node.getRightChild());
			}			
			// the right child is a NULL so we create a right child
			else {
				// WE HAVE TO CHECK whether the red black properties are violated
				Node<T> newNode = new Node<>(data, node);
				node.setRightChild(newNode);
				settleViolations(newNode);
			}		
		}
	}
	
	// takes at most O(logN) 
	private void settleViolations(Node<T> node) {
		
		Node<T> parentNode = null;
		Node<T> grandParentNode = null;
		
		// we have to check the violations up to the root node
		while(node!=root && isRed(node) && isRed(node.getParentNode())) {
			
			parentNode = node.getParentNode();
			grandParentNode = node.getParentNode().getParentNode();
			
			// parent is a left child of it's parent (so the grandparent)
			if( parentNode == grandParentNode.getLeftChild() ) {
				
				Node<T> uncle = grandParentNode.getRightChild();
				
				// case 1.) and case 4.) RECOLORING
				if( uncle != null && isRed(uncle) ) {
					grandParentNode.setColor(NodeColor.RED);
					parentNode.setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					node = grandParentNode;
				} else {
					// case 2.) 
					if( node == parentNode.getRightChild() ) {
						leftRotation(parentNode);
						// update the references we keep going up to the root node
						node = parentNode;
						parentNode = grandParentNode;
					}
					
					// case 3.) rotation on the grandparent + parent and grandparent switch color
					rightRotation(grandParentNode);
					System.out.println("Recoroling "+parentNode+" + "+grandParentNode);
					// swap the color of the parent and the grandparent
					NodeColor tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					// update the references because we keep going to the root node
					node = parentNode;
				}
			} else {
				// parent is a right child of it's parent (so the grandparent)
				Node<T> uncle = grandParentNode.getLeftChild();
				
				// case 1.) and case 4.) symmetric partner
				if( uncle != null && isRed(uncle) ) {
					grandParentNode.setColor(NodeColor.RED);
					parentNode.setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					node = grandParentNode;
				} else {
					// case 2.) symmetric partner
					if( node == parentNode.getLeftChild()) {
						rightRotation(parentNode);
						node = parentNode;
						parentNode = grandParentNode;
					}
					
					// case 3.) symmetric partner
					leftRotation(grandParentNode);
					System.out.println("Recoroling "+parentNode+" + "+grandParentNode);
					NodeColor tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					node = parentNode;
				}
			}	
		}
		
		// root node can not be RED so we have to recolor if necessary
		if(isRed(root)) {
			System.out.println("Recoloring the root to black...");
			root.setColor(NodeColor.BLACK);
		}
	}
	
	private boolean isRed(Node<T> node) {
		
		if(node == null) 
			return false;
		
		return node.getColor() == NodeColor.RED; 		
	}
	
	// it can be done in O(1)
	private void rightRotation(Node<T> node) {
		System.out.println("Rotating right on node " + node);
		
		Node<T> tempLeftChild = node.getLeftChild();
		Node<T> grandChild = tempLeftChild.getRightChild();
	
		// make the rotation - the new root node will be the tempLeftChild
		tempLeftChild.setRightChild(node);
		node.setLeftChild(grandChild);
			
		// we have to handle the parents
		if(grandChild != null) 
			grandChild.setParentNode(node);
			
		// we have to handle the parents for the node
		Node<T> tempParent = node.getParentNode();
		node.setParentNode(tempLeftChild);
		tempLeftChild.setParentNode(tempParent);
			
		// we have to handle the parent
		if(tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getLeftChild() == node) {
			tempLeftChild.getParentNode().setLeftChild(tempLeftChild);
		}
			
		if(tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getRightChild() == node) {
			tempLeftChild.getParentNode().setRightChild(tempLeftChild);
		}
			
		// no parent after rotation because it has become the root node
		if(node == root) 
			root = tempLeftChild;	
	}
	
	// it can be done in O(1)
	private void leftRotation(Node<T> node) {
		System.out.println("Rotating left on node " + node);
		
		Node<T> tempRightChild = node.getRightChild();
		Node<T> grandChild = tempRightChild.getLeftChild();
				
		// make the rotation - the new root node will be the tempLeftChild
		tempRightChild.setLeftChild(node);
		node.setRightChild(grandChild);
				
		// we have to handle the parents
		if(grandChild != null) 
			grandChild.setParentNode(node);
				
		// we have to handle the parents for the node
		Node<T> tempParent = node.getParentNode();
		node.setParentNode(tempRightChild);
		tempRightChild.setParentNode(tempParent);
				
		// we have to handle the parent
		if(tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getLeftChild() == node) {
			tempRightChild.getParentNode().setLeftChild(tempRightChild);
		}
				
		if(tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getRightChild() == node) {
			tempRightChild.getParentNode().setRightChild(tempRightChild);
		}
				
		// no parent after rotation because it has become the root node
		if(node == root) 
			root = tempRightChild;	
	}
	
	@Override
	public void traverse() {
		// in-order traversal in O(N) linear running time
		if( root != null) 
			traversal(root);
	}

	// O(N) 
	private void traversal(Node<T> node) {
		
		if(node.getLeftChild() != null)
			traversal(node.getLeftChild());
		
		System.out.print(node + " - ");
		
		if(node.getRightChild() != null)
			traversal(node.getRightChild());
	}
}
