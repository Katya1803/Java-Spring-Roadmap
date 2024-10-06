package com.balazsholczer.map;

public class HashTable {

	private HashItem[] hashTable;
	
	public HashTable() {
		hashTable = new HashItem[Constants.TABLE_SIZE];
	}
	
	public int get(int key) {
		
		int index = hash(key);
		
		if( hashTable[index] == null ) 
			return -1;
		
			
		HashItem item = hashTable[index];
			
		while( item != null && item() != key ) 
			item = item.getNextItem();
		
			
		if( item == null ) 
			return -1;
			
		return item.getValue();	
	}
	
	public void put(int key, int value) {
		
		int index = hash(key);
		
		if( hashTable[index] == null ) {
			System.out.println("No collision simple insertion...");
			hashTable[index] = new HashItem(key, value);
		} else {
			
			System.out.println("Collision when inserting with key "+key);
			HashItem item = hashTable[index];
			
			while( item.getNextItem() != null )  {
				item = item.getNextItem();
				System.out.println("Considering the next item in linked list "+item.getValue());
			}
			
			System.out.println("Finally we have found the place to insert...");
			item.setNextItem(new HashItem(key, value));
		}
	}
	
	private int hash(int key) {
		return key % Constants.TABLE_SIZE;
	}
}
