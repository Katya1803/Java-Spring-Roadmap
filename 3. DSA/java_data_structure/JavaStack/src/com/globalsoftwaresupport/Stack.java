package com.globalsoftwaresupport;

public class Stack<T> {

	private T[] stack;
	private int count;
	
	public Stack() {
		stack = (T[]) new Object[1];
	}
	
	// we just have to add the new item to the end of the array O(1)
	public void push(T newData) {
		
		// ARRAYS ARE NOT DYANMIC DATA STRUCTURES !!!
		// we have to resize the underlying array if necessary
		// if there are too many items: we double the size of the array
		// if there are too few items: then we decrease (shrink) the array
		if(count == stack.length)
			resize(2*stack.length);
		
		// we just have to insert into the array
		stack[count++] = newData;
	}
	
	// returns (removes) the last item we have inserted O(1)
	public T pop() {
		
		if(isEmpty()) return null;
		
		T item = stack[--count];
		// obsolete references - avoid memory leaks
		stack[count] = null;
		
		// maybe we have to resize the array and decrease the size
		// the stack is 25% full
		if(count > 0 && count == stack.length / 4)
			resize(stack.length/2);
		
		return item;
	}
	
	// O(1)
	public boolean isEmpty() {
		return count == 0;
	}
	
	// size method in O(1)
	public int size() {
		return count;
	}

	// this is the bottleneck of the application O(N)
	private void resize(int capacity) {
		
		System.out.println("Need to resize the array...");
		
		T[] stackCopy = (T[]) new Object[capacity];
		
		// copy the items one by one
		for(int i=0;i<count;++i)
			stackCopy[i] = stack[i];
		
		// update the references
		stack = stackCopy;
	}
}
