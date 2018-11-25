package com.recurrsion;

public class MergeSortApp {
	
	private int[] arrayFinal = {7, 23, 14, 81, 47};
	public void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC){
		int dexA=0, dexB=0, dexC=0;
		
		while(dexA < sizeA && dexB < sizeB){
			if(arrayA[dexA] < arrayB[dexB]){
				arrayC[dexC++] = arrayA[dexA++];
			}else {
				arrayC[dexC++] = arrayB[dexB++];
			}
		}
		
		while(dexA < sizeA){
			arrayC[dexC++] = arrayA[dexA++];
		}
		
		while(dexB < sizeB){
			arrayC[dexC++] = arrayB[dexB++];
		}
	}
	
	public void display(int[] arrayC){
		for(int i=0; i<arrayC.length; i++){
			System.out.print(arrayC[i] + " ");
		}
		System.out.println("");
	}
	
	public void display(){
		for(int i=0; i<arrayFinal.length; i++){
			System.out.print(arrayFinal[i] + " ");
		}
		System.out.println("");
	}
	
	public void merge(int[] workspace, int lowPtr, int highPtr, int upperBound){
		int j = 0;
		int lowerBound = lowPtr;
		int mid = highPtr-1;
		int n = upperBound-lowerBound+1;
		
		while(lowPtr <= mid && highPtr <= upperBound){
			if(arrayFinal[lowPtr] < arrayFinal[highPtr]){
				workspace[j++] = arrayFinal[lowPtr++];
			}else{
				workspace[j++] = arrayFinal[highPtr++];
			}
		}
		
		while(lowPtr <= mid){
			workspace[j++] = arrayFinal[lowPtr++];
		}
		
		while(highPtr <= upperBound){
			workspace[j++] = arrayFinal[highPtr++];
		}
		
		for(j=0; j<n; j++){
			arrayFinal[lowerBound+j] = workspace[j];
		}
	}
	
	public void recMergeSort(int[] workspace, int lowerBound, int upperBound){
		if(lowerBound == upperBound){
			return;
		}else{
			int mid = (lowerBound + upperBound) /2;
			
			recMergeSort(workspace, lowerBound, mid);
			recMergeSort(workspace, mid+1, upperBound);
			merge(workspace, lowerBound, mid+1, upperBound);
		}
	}
	
	public static void main(String[] args) {
		int[] arrayA = {23, 47, 81, 95};
		int[] arrayB = {7, 14, 39, 55, 62, 74};
		int[] arrayC = new int[10];
		
		MergeSortApp app = new MergeSortApp();
		//app.merge(arrayA, arrayA.length, arrayB, arrayB.length, arrayC);
		//app.display(arrayC);
		
		int[] workspace = new int[10];
		app.recMergeSort(workspace, 0, 4);
	}
}
