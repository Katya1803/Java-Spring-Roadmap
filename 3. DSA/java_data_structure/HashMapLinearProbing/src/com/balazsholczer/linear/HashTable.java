package com.balazsholczer.linear;

public class HashTable {

	private static final int TABLE_SIZE = 10;
	private HashItem[] hashTable;
	// it tracks the number of key-value pairs already stored in the table
	private int counter;
	
	public HashTable() {
		hashTable = new HashItem[TABLE_SIZE];
	}
	
	// O(1) running time
	public int get(int key) {
		int index = hash(key);
		
		// BECAUSE OF COLLISION !!!
		// linear probing means we try the next index
		while(hashTable[index] != null && hashTable[index].getKey() != key)	
			index = (index+1) % TABLE_SIZE;		
		
		// search miss
		if(hashTable[index] == null)
			return -1;
		
		return hashTable[index].getValue();
	}
	
	// O(1) running time
	public void put(int key, int value) {
		if(counter >= TABLE_SIZE)
			return;
		
		int index = hash(key);
		
		// THIS IS COLLISION !!!
		// until we do not find an empty slot (null) we keep generating 
		// the next index (linear probing)
		while(hashTable[index] != null)
			index = (index+1) % TABLE_SIZE;	
		
		// we have found a valid index (with empty array bucket) for the item
		hashTable[index] = new HashItem(key, value);
		
		counter++;
	}
	
	// it transforms the key into an index of the underlying array
	// PRIME NUMBERS
	// O(1)
	private int hash(int key) {
		return key % TABLE_SIZE;
	}
}
