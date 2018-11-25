package com.rishi.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(List<Integer> innerList : triangle) {
        	for(Integer val : innerList) {
        		min = Math.min(min, val);
        	}
        	sum += min;
        	min = Integer.MAX_VALUE;
        }
        
        return sum;
    }
	
	public int minimumTotalCorrect(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] minlen = new int[n + 1];
		for (int layer=n-1; layer >= 0; layer--) { // For each layer
			for (int i = 0; i < triangle.get(layer).size(); i++) { // Check its every 'node'
				// Find the lesser of its two children, and sum the current
				// value in the triangle with it.
				minlen[i] = Math.min(minlen[i], minlen[i + 1]) + triangle.get(layer).get(i);
			}
		}
		return minlen[0];
	}
	
	public static void main(String[] args) {
		List<List<Integer>> finalList = new ArrayList<>();
		List<Integer> first = new ArrayList<>();
//		first.add(2);
		first.add(-1);
		
		List<Integer> sec = new ArrayList<>();
//		sec.add(3);
//		sec.add(4);
		sec.add(2);
		sec.add(3);
		
		List<Integer> third = new ArrayList<>();
//		third.add(6);
//		third.add(5);
//		third.add(7);
		third.add(1);
		third.add(-1);
		third.add(-3);
		
//		List<Integer> fourth = new ArrayList<>();
//		fourth.add(4);
//		fourth.add(1);
//		fourth.add(8);
//		fourth.add(3);
		
		finalList.add(first);
		finalList.add(sec);
		finalList.add(third);
//		finalList.add(fourth);
		
		Triangle obj = new Triangle();
		System.out.println("Result " + obj.minimumTotalCorrect(finalList));
	}
}
