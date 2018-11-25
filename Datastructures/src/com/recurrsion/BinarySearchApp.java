package com.recurrsion;

public class BinarySearchApp {

	private long a[] = new long[100];
	
	public void insertItems(){
		a[0] = 10;
		a[1] = 20;
		a[2] = 23;
		a[3] = 32;
		a[4] = 40;
	}
	
	public int recFind(long searchKey, int lowerBound, int upperBound){
		int curIn;
		
		curIn = (lowerBound + upperBound) /2;
		
		if(a[curIn] == searchKey){
			return curIn;
		}else if(lowerBound > upperBound){
			return a.length;
		}else{
			if(a[curIn] < searchKey){
				return recFind(searchKey, curIn + 1, upperBound);
			}else{
				return recFind(searchKey, lowerBound, curIn-1);
			}
		}
	}
	
	public static void main(String[] args) {
		BinarySearchApp app = new BinarySearchApp();
		app.insertItems();
		
		System.out.println("Found at "+ app.recFind(23, 0, 4));
	}
}
