package com.rishi.binary.tree;

/**
 * Unique BST is same as finding the Catalan's number for n. Catalan's number could be found out using the
 * Binomial coefficient.
 * Here we are using DP to save the old state and compute the catalan's number for input n or total number of 
 * Unique BSTs could be formed using n.
 * @author rishi
 *
 */
public class UniqueBST {

	public static int numTrees(int n){
		int[] result = new int[n+1];
		result[0] = 1;
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=i; j++){
				result[i] += result[j-1] * result[i-j];
			}
		}
		
		return result[n];
	}
	
	public static void main(String[] args) {
		System.out.println("Result "+ numTrees(3));
	}
}
