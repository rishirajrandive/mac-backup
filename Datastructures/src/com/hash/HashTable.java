package com.hash;

public class HashTable {

	private DataItem[] hashArray; // array holds hash table
	private int arraySize;
	private DataItem nonItem;
	
	public HashTable(int size){
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1); // deleted item key is -1
	}
	
	public void displayTable(){
		System.out.print("Table: ");
		for(int j=0; j<arraySize; j++){
			if(hashArray[j] != null)
				System.out.print(hashArray[j].getKey() + " ");
			else
				System.out.print("** ");
		}
		System.out.println("");
	}
	
	public int hashFunc(int key){
		return key % arraySize; // hash function
	}
	
	public int hashFunc1(int key){
		// non-zero, less than array size, different from hF1
		// array size must be relatively prime to 5, 4, 3, and 2
		return 5 - key % 5;
	}
	
	public void insert(DataItem item){
		int key = item.getKey(); // extract key
		int hashVal = hashFunc(key); // hash the key
		// until empty cell or -1,
		while(hashArray[hashVal] != null &&
		hashArray[hashVal].getKey() != -1)
		{
			++hashVal; // go to next cell
			hashVal %= arraySize; // wraparound if necessary
		}
		hashArray[hashVal] = item; // insert item
		
	} // end insert()
	
	//DOuble hashing
	public void insertForDouble(DataItem item){
		int key = item.getKey(); // extract key
		int hashVal = hashFunc(key); // hash the key
		int stepSize = hashFunc1(key);
		// until empty cell or -1,
		while(hashArray[hashVal] != null &&
		hashArray[hashVal].getKey() != -1)
		{
			hashVal = hashVal + stepSize;
			hashVal %= arraySize; // wraparound if necessary
		}
		hashArray[hashVal] = item; // insert item
		
	} // end insert()
	
	public DataItem delete(int key) {
		int hashVal = hashFunc(key); // hash the key
		while(hashArray[hashVal] != null) // until empty cell,
		{ // found the key?
			if(hashArray[hashVal].getKey() == key)
			{
				DataItem temp = hashArray[hashVal]; // save item
				hashArray[hashVal] = nonItem; // delete item
				return temp; // return item
			}
		++hashVal; // go to next cell
		hashVal %= arraySize; // wraparound if necessary
		}
		return null; // can’t find item
	} // end delete()
	
	public DataItem find(int key){
		int hashVal = hashFunc(key); // hash the key
		while(hashArray[hashVal] != null) // until empty cell,
		{ // found the key?
			if(hashArray[hashVal].getKey() == key)
				return hashArray[hashVal]; // yes, return item
			++hashVal; // go to next cell
			hashVal %= arraySize; // wraparound if necessary
		}
		return null; // can’t find item
	}
}
