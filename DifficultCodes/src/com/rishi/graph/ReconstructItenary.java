package com.rishi.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Idea is to:
 * 1. Have map with priority queue (to keep the values lexically sorted)
 * 2. Populate this with key as 0th column and values in the priority queue would be of 1st column
 * 3. Then there are two ways,
 * 		a. Recursion
 * 		b. Iterative
 * @author rishi
 *
 */
public class ReconstructItenary {
	
	private Map<String, PriorityQueue<String>> map;
	private LinkedList<String> list;
	private Stack<String> stack;
	
	public List<String> findItinerary(String[][] tickets){
		map = new HashMap<>();
		list = new LinkedList<>();
		
		for(String[] ticket : tickets){
			map.putIfAbsent(ticket[0], new PriorityQueue<>());
			map.get(ticket[0]).add(ticket[1]);
		}
		
		
//		dfs("JFK");
		dfsIter("JFK", tickets);
		return list;
	}
	
	public void dfs(String departure){
		PriorityQueue<String> arrivals = map.get(departure);
		while(arrivals != null && !arrivals.isEmpty()){
			dfs(arrivals.poll());
		}
		list.addFirst(departure);
	}
	
	public void dfsIter(String departure, String[][] tickets){
		stack = new Stack<>();
		for(int i=0; i<tickets.length; i++){
			while(!map.containsKey(departure) || map.get(departure).isEmpty()){
				stack.push(departure);
				departure = list.removeLast();
			}
			
			list.add(departure);
			departure = map.get(departure).poll();
		}
		list.add(departure);
		while(!stack.isEmpty()){
			list.add(stack.pop());
		}
	}
	
	public static void main(String[] args) {
//		String[][] in = {{"MUC", "LHR"}, 
//				{"JFK", "MUC"}, 
//				{"SFO", "SJC"}, 
//				{"LHR", "SFO"}};
		
//		String[][] in = {{"JFK","SFO"}, 
//				{"JFK","ATL"}, 
//				{"SFO","ATL"}, 
//				{"ATL","JFK"},
//				{"ATL","SFO"}};
		
		String[][] in = {{"JFK","KUL"}, 
				{"JFK","NRT"}, 
				{"NRT","JFK"}};
		
		System.out.println(in.length);
		ReconstructItenary obj = new ReconstructItenary();
		
		System.out.println("Result "+ obj.findItinerary(in));
	}
}
