package com.globalsoftwaresupport;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;
	
	@Override
	public void insert(T data) {
		// this is when we insert the first node into the BST (parent is null)
		if(root==null) {
			root = new Node<>(data, null);
		} else {
			// there are already items in the BST
			insert(data, root);
		}
	}

	private void insert(T data, Node<T> node) {	
		// this is the case when the data is SMALLER than the value in the node
		// GO TO THE LEFT SUBTREE 
		if(node.getData().compareTo(data) > 0) {
			// there is a valid (not NULL) left child so we go there
			if( node.getLeftChild() != null )
				insert(data, node.getLeftChild());
			// the left child is a NULL so we create a left child
			else
				node.setLeftChild(new Node<>(data, node));
		// this is the case when the data is GREATER than the value in the node
		// GO TO THE RIGHT SUBTREE
		} else {
			// there is a valid (not NULL) right child so we go there
			if( node.getRightChild() != null )
				insert(data, node.getRightChild());
			// the right child is a NULL so we create a right child
			else
				node.setRightChild(new Node<>(data, node));
		}	
	}

	@Override
	public void remove(T data) {
		if(root != null) 
			remove(data, root);
	}

	private void remove(T data, Node<T> node) {
		
		if(node == null) return;
		
		// first we have to search for the item we want to remove
		if(data.compareTo(node.getData()) < 0) {
			remove(data, node.getLeftChild());
		} else if(data.compareTo(node.getData()) > 0) {
			remove(data, node.getRightChild());
		} else {
			// WE HAVE FOUND THE ITEM WE WANT TO REMOVE !!!
			
			// if the node is a leaf node (without left and right children)
			// THIS IS THE CASE 1)
			if(node.getLeftChild()==null && node.getRightChild() == null) {
				System.out.println("Removing a leaf node ...");
				
				// whether the node is a left child or right child
				Node<T> parent = node.getParentNode();
				
				// the node is a left child
				if(parent!=null && parent.getLeftChild() == node) {
					parent.setLeftChild(null);
				// the node is a right child
				} else if (parent!=null && parent.getRightChild() == node) {
					parent.setRightChild(null);
				}
				
				// maybe the root node is the one we want to remove
				if(parent == null) 
					root = null;
				
				// remove the node and makes it eligible for GC
				node = null;
			}
			
			// CASE 2) when we remove items with a single child
			// a single right child
			else if(node.getLeftChild()==null && node.getRightChild() != null) {
				System.out.println("Removing a node with a single right child ...");
				Node<T> parent = node.getParentNode();

				// the node is a left child
				if(parent!=null && parent.getLeftChild() == node) {
					parent.setLeftChild(node.getRightChild());
				// the node is a right child
				} else if (parent!=null && parent.getRightChild() == node) {
					parent.setRightChild(node.getRightChild());
				}
				
				// when we deal with the root node
				if(parent == null) {
					root = node.getRightChild();
				}
				
				// have to update the right child's parent
				node.getRightChild().setParentNode(parent);
				node = null;
			}
			
			// it is approximately the same CASE 2) BUT we have to deal with left child
			else if(node.getLeftChild() != null && node.getRightChild() == null) {
				System.out.println("Removing a node with a single left child ...");
				Node<T> parent = node.getParentNode();

				// the node is a left child
				if(parent!=null && parent.getLeftChild() == node) {
					parent.setLeftChild(node.getLeftChild());
				// the node is a right child
				} else if (parent!=null && parent.getRightChild() == node) {
					parent.setRightChild(node.getLeftChild());
				}
				
				// when we deal with the root node
				if(parent == null) {
					root = node.getLeftChild();
				}
				
				// have to update the right child's parent
				node.getLeftChild().setParentNode(parent);
				node = null;
			}
			
			// remove 2 children
			else {
				System.out.println("Removing a node with 2 children ...");
				
				// find the predecessor (max item in the left subtree)
				Node<T> predecessor = getPredecessor(node.getLeftChild());
				
				// swap just the values !!!
				T temp = predecessor.getData();
				predecessor.setData(node.getData());
				node.setData(temp);
				
				// we have to call the delete method recursively on the predecessor
				remove(data, predecessor);
			}	
		}	
	}

	private Node<T> getPredecessor(Node<T> node) {
		
		if(node.getRightChild() != null)
			return getPredecessor(node.getRightChild());
		
		return node;
	}

	@Override
	public void traversal() {
		
		// in-order traversal in O(N) linear running time
		if( root == null) return;
		
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

	@Override
	public T getMin() {
		
		if(root == null) return null;
		
		// the min item is the leftmost item in the tree
		return getMin(root);
	}

	private T getMin(Node<T> node) {
		
		if(node.getLeftChild() != null) 
			return getMin(node.getLeftChild());
		
		return node.getData();
	}

	@Override
	public T getMax() {
		
		if(root == null) return null;
		
		// the max item is the rightmost item in the tree
		return getMax(root);
	}

	private T getMax(Node<T> node) {
		
		if(node.getRightChild() != null) 
			return getMax(node.getRightChild());
		
		return node.getData();
	} 
}
