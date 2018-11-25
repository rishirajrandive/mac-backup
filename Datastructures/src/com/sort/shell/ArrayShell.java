package com.sort.shell;

public class ArrayShell {

	private long[] theArray;
	private int nElems;
	
	public ArrayShell(int max){
		theArray = new long[max];
		nElems = 0;
	}
	
	public void insert(long val){
		theArray[nElems] = val;
		nElems++;
	}
	
	public void display(){
		for(int i=0; i<nElems; i++){
			System.out.print(theArray[i] + " ");
		}
		System.out.println("");
	}
	
	public void shellSort(){
		int inner, outer;
		long temp;
		
		int h=1;
		
		while(h<=nElems/3){
			h = h*3 + 1;
		}
		System.out.println("value of h "+ h);
		while(h>0){
			for(outer=h; outer<nElems; outer++){
				temp = theArray[outer];
				inner = outer;
				
				while(inner > h-1 && theArray[inner-h] >= temp){
					theArray[inner] = theArray[inner-h];
					inner -= h;
				}
				theArray[inner] = temp;
			}
			h = (h-1)/3;
		}
	}
	
	public static void main(String[] args) {
		int maxSize = 6; // array size
		ArrayShell arr;
		arr = new ArrayShell(maxSize); // create the array
		for(int j=0; j<maxSize; j++) { // fill array with
			// random numbers
			long n = (int)(java.lang.Math.random()*99);
			arr.insert(n);
		}
		arr.display(); // display unsorted array
		arr.shellSort(); // shell sort the array
		arr.display();
	}
}
