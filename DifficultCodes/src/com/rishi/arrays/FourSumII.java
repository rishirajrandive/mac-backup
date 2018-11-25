package com.rishi.arrays;

import java.util.HashMap;

/**
 * Question is to find tuples such that A[i] + B[j] + C[k] + D[l] = 0, given four arrays.
 * Also length of all the arrays is same and numbers are integers i.e. both -ve and +ve
 * Idea is to:
 * 1. Create a HashMap with key as sum (of two values in two different arrays) and value is how many times
 * 		that sum is found.
 * 2. We populate this map for two arrays first
 * 3. Then for the rest of the two arrays we check if negative of sum of two elements in these arrays is
 * 		present in map or not, 
 * 			a. if present use its value and add to result
 * 			b. else use 0 and add it to result.
 * 
 * Basically, for sum to be 0, if elements in first two array sum to 2 then elements of next two arrays
 * should sum to -2.
 * @author rishi
 *
 */
public class FourSumII {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0){
            return 0;
        }
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                sum = A[i] + B[j];
                hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            }
        }
        
        int res=0;
        for(int i=0; i<C.length; i++){
            for(int j=0; j<D.length; j++){
                res += hashMap.getOrDefault(-1 * (C[i] + D[j]), 0);
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		FourSumII obj = new FourSumII();
		int A[] = {1, 2};
		int B[] = {-2, -1};
		int C[] = {-1, 2};
		int D[] = {0, 2};
		System.out.println("Total tuples "+ obj.fourSumCount(A, B, C, D));
	}

}
