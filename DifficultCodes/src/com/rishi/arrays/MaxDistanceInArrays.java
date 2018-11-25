package com.rishi.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Need to find the maximum difference between the elements in the different arrays.
 * All the arrays are sorted.
 * 
 * Idea is to:
 * 1. As the arrays are sorted, we just need to find the difference between the ends.
 * 2. Take the min and max of first array, loop over all other
 * 3. For each array, take max difference between the "min and current array's max" and "max and current
 * array's min"
 * 4. Update the min and max based on the current array's values.
 * 
 * @author rishi
 *
 */
public class MaxDistanceInArrays {
	public static int maxDistance(List<List<Integer>> arrays) {
        if(arrays == null || arrays.size() == 0){
        	return 0;
        }
        
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int min = arrays.get(0).get(0);
        int res = Integer.MIN_VALUE;
        
        for(int i=1; i<arrays.size(); i++){
        	res = Math.max(res,  Math.abs(arrays.get(i).get(0) - max));
        	res = Math.max(res, Math.abs(arrays.get(i).get(arrays.get(i).size()-1) - min));
        	max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
        	min = Math.min(min,arrays.get(i).get(0));
        }
        
        return res;
    }
	
	
	public static void main(String[] args) {
//		List<Integer> f1 = Arrays.asList(1, 2, 3);
//		List<Integer> f2 = Arrays.asList(4, 5);
//		List<Integer> f3 = Arrays.asList(1, 2, 3);
		
		List<Integer> f1 = Arrays.asList(-8,-7,-7,-5,1,1,3,4);
		List<Integer> f2 = Arrays.asList(-2);
		List<Integer> f3 = Arrays.asList(-10,-10,-7,0,1,3);
		List<Integer> f4 = Arrays.asList(2);
//		List<Integer> f1 = Arrays.asList(2);
//		List<Integer> f2 = Arrays.asList(-1);
		int i = -1;
		System.out.println(++i);
		System.out.println(i);
		List<List<Integer>> arr = new ArrayList<>();
		arr.add(f1);
		arr.add(f2);
		arr.add(f3);
		arr.add(f4);
		System.out.println("Result "+ maxDistance(arr));
	}
	
}
