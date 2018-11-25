package com.sort.sel;

/**
 * Sort using selection sort method.
 * 
 * Invariant - data elements at indices less than or equal to out are sorted
 * 
 * Comparisons are same as Bubble sort so Big O(N2)
 * Swaps are less for example 10 item will require fewer than 10 swaps, however
 * for larger numbers comparisons will dominate.
 * 
 * So the Big O(N2) for Selection sort as well however it is faster than Bubble
 * wit fewer swaps.
 * @author rishi
 *
 */
public class SelectionArray {

	private long a[];
	private int nElem;
	
	public SelectionArray(int max){
		a = new long[max];
		System.out.println(a.length);
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
	
	public void selectionSort(){
		int min;
		for(int out=0; out<nElem; out++){
			min = out;
			for(int in=out+1; in<nElem; in++){
				if(a[in] < a[min]){
					min = in;
				}
				swap(min, out);
			}
		}
	}
	
	private void swap(int one, int two){
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}

