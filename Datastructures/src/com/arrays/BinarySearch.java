package com.arrays;

/**
 * Implementation for ordered array. Useful when searches 
 * are frequent whereas insert and delete are less frequent.
 * 
 * Big O(log N) is the for finding and insertion.
 * However, for an unordered array it is O(1)
 * 
 * @author rishi
 *
 */
public class BinarySearch {
	private long a[];
	private int nElements;
	
	public BinarySearch(int max){
		a = new long[max];
		nElements = 0;
	}
	
	public int size(){
		return nElements;
	}
	
	public int find(long searchKey){
		int lowerBound = 0;
		int upperBound = nElements -1;
		int currIn;
		
		while(true){
			currIn = (lowerBound + upperBound) /2;
			if(a[currIn] == searchKey){
				return currIn;
			}else if(lowerBound > upperBound){
				return nElements;
			}else {
				if(a[currIn] < searchKey){
					lowerBound = currIn + 1;
				}else {
					upperBound = currIn - 1;
				}
			}
		}
	}
	
	public void insert(long value){
		int j;
		for(j=0; j<nElements; j++){
			if(a[j] > value){
				break;
			}
		}
		
		for(int k=nElements; k>j; k--){
			a[k] = a[k-1];
		}
		
		a[j] = value;
		nElements++;
	}
	
	public boolean delete(long value){
		int j = find(value);
		if(j == nElements){
			return false;
		}else {
			for(int k=j; k<nElements; k++){
				a[k] = a[k+1];
			}
			nElements--;
			return true;
		}
	}
	
	public void display(){
		for(int i=0; i<nElements; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}

}
