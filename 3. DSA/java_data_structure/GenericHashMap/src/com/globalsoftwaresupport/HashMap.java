package com.globalsoftwaresupport;

@SuppressWarnings("unchecked")
public class HashMap<Key, Value> {

	private Key[] keys;
	private Value[] values;
	// number of items (default value 0)
	private int n;
	// it manages the resize operation
	private int capacity;
	
	public HashMap() {
		this.keys = (Key[]) new Object[Constants.TABLE_SIZE];
		this.values = (Value[]) new Object[Constants.TABLE_SIZE];
		this.capacity = Constants.TABLE_SIZE;
	}
	
	public HashMap(int capacity) {
		this.keys = (Key[]) new Object[Constants.TABLE_SIZE];
		this.values = (Value[]) new Object[Constants.TABLE_SIZE];
		this.capacity = capacity;
	}
	
	public void put(Key key, Value value) {
		
		if(key == null || value == null) return;
		
		// load balance is 0.75: so when the table is 75% full we resize it -> double its size
		// why? when it is nearly empty --> we waste a lot of memory for no reason
		// when it is nearly full --> there will be lots of collisions --> O(1) will 
		// reduce to O(N) or something like that			
		if(n >= capacity * 0.75)
			resize(2*capacity);
		
		int index = hash(key);
		
		// maybe there is a collision and there is already an item 
		// inserted to that given index, so we have to
		// find an empty slot --> hence the condition != null
		while(keys[index] != null) {
			// update
			if(keys[index].equals(key)) {
				values[index] = value;
				return;
			}
			
			index = (index + 1) % capacity;
		}
		
		// we have managed to found the array index 
		// where we can insert the value -> so update accordingly !!!
		keys[index] = key;
		values[index] = value;
		n++;		
	}
	
	private void resize(int i) {
		// TODO Auto-generated method stub
		
	}

	public Value get(Key key) {
		
		if(key == null) return null;
		
		// O(1) approach 
		int index = hash(key);
		
		// we have to consider the items right after each other because
		// the item could have been shifted down
		// because of the linear probing
		while(keys[index] != null) {
			if(keys[index].equals(key)) 
				return values[index];
			// have to check the next slot / array bucket
			index = (index + 1) % capacity;
		}
		
		// search miss: no value with the given key
		return null;
	}
	
	private int hash(Key key) {
		return Math.abs(key.hashCode()) % capacity;
	}
	
	public boolean isEmpty() {
		return this.n == 0;
	}
	
	public int size() {
		return this.n;
	}
}










