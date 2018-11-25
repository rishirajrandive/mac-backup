package com.rishi.bit.manipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class A {

	public A() {
		System.out.println("A constructor");
	}
	
	public void print(){
		System.out.println("Print A");
	}
	
	public static void main(String[] args) {
		int[] nums = {1,4,3,2,4};
		 TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
	        for(int i=0; i<nums.length; i++) {
	        	if(!map.containsKey(Integer.bitCount(nums[i]))) {
	        		ArrayList<Integer> arr = new ArrayList<>();
	        		arr.add(nums[i]);
	        		map.put(Integer.bitCount(nums[i]), arr);
	        	}
	            map.get(Integer.bitCount(nums[i])).add(nums[i]);
	        }
	        
	        
	        for(Entry<Integer, ArrayList<Integer>> list : map.entrySet()) {
	        	Collections.sort(list.getValue(), new Comparator<Integer>() {
	        		public int compare(Integer o1, Integer o2) {
	        			return o1.compareTo(o2);
	        		}
				});
	        }
	        
	        
	        
	        int result[] = new int[nums.length];
	        int i=0;
	        for(Entry<Integer, ArrayList<Integer>> list : map.entrySet()) {
	            for(Integer val : list.getValue()) {
	            	System.out.println(val);
	            }
	        }
	        
	}
}
