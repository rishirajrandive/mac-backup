package com.sort.insert;

/**
 * Sort using insertion sort method.
 * 
 * Invariant - data items at smaller indices than out are partially sorted
 * 
 * Comparisons - on each pass an average of half of maximum items are compared, so 
 * so it can be given as N2/4
 * 
 * Swaps or copies - same as number of comparisons however it is faster than
 * swaps.
 * 
 * Hence the Big O(N2) but still it is faster than Selection and Bubble for random data.
 * For partially sorted it works much better and faster, as while condition is not true for 
 * lesser indices
 * However it is no better than Bubble and selection in case of reverse sorted elements.
 * it requires same number of comparisons.
 * 
 * @author rishi
 *
 */
public class InsertionArray {

	private long a[];
	private int nElem;
	
	public InsertionArray(int max){
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
	
	public void insertionSort(){
		int in;
		for(int out=0; out<nElem; out++){
			long temp = a[out];
			in = out;
			
			while(in>0 && a[in - 1] >= temp){
				a[in] = a[in -1];
				--in;
			}
			a[in] = temp;
		}
	}

}

