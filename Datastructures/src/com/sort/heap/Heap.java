package com.sort.heap;

public class Heap {

	private Node[] heapArray;
	private int maxSize; // size of array
	private int currentSize;
	
	public Heap(int mx){
		maxSize = mx;
		currentSize = 0;
		heapArray = new Node[maxSize];
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	/**
	 * Deletes item with max key
	 * @return
	 */
	public Node remove(){
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}
	
	public void trickleDown(int index){
		int largerChild;
		Node top = heapArray[index]; // save root
		while(index < currentSize/2){ // while node has at
			// least one child,
			int leftChild = 2*index+1;
			int rightChild = leftChild+1;
			// find larger child
			if(rightChild < currentSize && // (rightChild exists?)
			heapArray[leftChild].getKey() <
			heapArray[rightChild].getKey()){
				largerChild = rightChild;
			}
			else{
				largerChild = leftChild;
			}
			// top >= largerChild?
			if( top.getKey() >= heapArray[largerChild].getKey()){
				break;
			}
			// shift child up
			heapArray[index] = heapArray[largerChild];
			index = largerChild; // go down
		} // end while
		heapArray[index] = top; // root to index
	}
	
	
	public void displayHeap(){
		System.out.print("heapArray: "); // array format
		for(int m=0; m<currentSize; m++){
			if(heapArray[m] != null){
				System.out.print( heapArray[m].getKey() + " ");
			}
			else{
				System.out.print( "-- ");
			}
		}
		System.out.println();
		// heap format
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0; // current item
		String dots = "...............................";
		System.out.println(dots+dots);
		
		while(currentSize > 0){ // for each heap item
			if(column == 0){ // first item in row?
				for(int k=0; k<nBlanks; k++){ // preceding blanks
					System.out.print(' ');
				}
			}
			// display item
			System.out.print(heapArray[j].getKey());
			
			if(++j == currentSize){ // done?
				break;
			}
			if(++column==itemsPerRow){ // end of row?			
				nBlanks /= 2; // half the blanks
				itemsPerRow *= 2; // twice the items
				column = 0; // start over on
				System.out.println(); // new row
			}
			else { // next item on row
				for(int k=0; k<nBlanks*2-2; k++){
					System.out.print(' '); // interim blanks
				}
			} // end for
		}
		System.out.println("\n"+dots+dots);
	}
	
	public void displayArray(){
		for(int j=0; j<maxSize; j++)
			System.out.print(heapArray[j].getKey() + " ");
		System.out.println("");
	}
	
	public void insertAt(int index, Node newNode){
		heapArray[index] = newNode;
	}
	
	public void incrementSize(){
		currentSize++;
	}
}
