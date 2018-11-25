package com.rishi.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Here n and k is passed and we need to find out the kth permutation in a sequence with n numbers.
 * Example: n=3, sequence would be = {123}, {132}, {213}, {231}, {312}, {321}
 * So if k = 4, we need to return the sequence {231}.
 * 
 * Steps:
 * 1. Calculate and store all the factorial values till n (for 0, 1, 2, 3,..). In this case it would be
 * 		[1, 1, 2, 6, 24...]
 * 2. Store all the numbers in an ArrayList
 * 3. Subtract 1 from k, to consider 0. So for k = 4, actually the sequence would be considered starting from
 * 		0, hence 3 would be right index.
 * 4. Iterate over all numbers till i <= n
 * 		1. Find index such that, index = k / (n-1)!
 * 		2. Append the number from ArrayList to result string
 * 		3. Remove the number from ArrayList
 * 		4. Find new value for k, because now only n-1 elements left. k = k - index*(n-1)!
 * 5. Return the result
 * @author rishi
 *
 */
public class PermutationSeq {
	
	public static String permutationSeq(int n, int k){
		
		List<Integer> numbers = new ArrayList<>();
		int[] factorials = new int[n+1];
		StringBuffer result = new StringBuffer();
		
		int sum = 1;
		factorials[0] = 1;		
		for(int i=1; i <= n; i++){
			sum *= i;
			factorials[i] = sum;
		}
		if(factorials[n] < k){
			return "";
		}
		for(int i=1; i<=n; i++){
			numbers.add(i);
		}
		
		k--;
		
		for(int i=1; i<=n; i++){
			int index = k/factorials[n-i];
			result.append(numbers.get(index));
			numbers.remove(index);
			k = k - index*factorials[n-i];
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(permutationSeq(3, 7));
	}

}
