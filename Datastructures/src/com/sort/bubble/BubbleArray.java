package com.sort.bubble;

/**
 * Sorts data by comparing the neighbouring elements and swapping if required.
 * 
 * Invariant - data elements to the right are always sorted
 * 
 * Total comparisons for N item is propotional to N2/2
 * Total swaps for N items is propotional to N2/4 (assuming only half of time swaps are required)
 * Hence both swaps and comparisons are propotional to N2, giving us Big O(N2)
 * 
 * Also, whenever there are nested loops the Big O(N2) is there.
 * @author rishi
 *
 */
public class BubbleArray {

	private long a[];
	private int nElem;
	
	public BubbleArray(int max){
		a = new long[max];
		nElem = 0;
	}
	
	public void insert(long val){
		a[nElem] = val;
		nElem++;
	}
	
	public void display(){
		for(int i=0; i<nElem; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	public void bubbleSort(){
		for(int out=nElem-1;  out>0; out--){
			for(int in=0; in<out; in++){
				if(a[in] > a[in+1]){
					swap(in, in+1);
				}
			}
		}
	}
	
	private void swap(int one, int two){
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}

