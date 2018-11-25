package com.rishi.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Cloning the given input graph to create same different object. Concept could be applied when 
 * serializing and de-serializing objects
 * We will either be given a serialized input in code form for example:
 * {0,1,2#1,2#2,2} where # separates two nodes and , gives the neighboring nodes
 * 
 * Or else we would given the Head for the start
 * 
 * Idea is to:
 * 1. Have a map to store the main node and its neighbors
 * 2. Queue used for BFS approach.
 * 3. Add the first head in the queue, and iterate over the queue till its empyt
 * 		a. Pop the node and get neighbors
 * 		b. Check if neighbor is already in the map if not add it and update the curr nodes neigbors
 * 		c. If the node is new and not in map, we also add it in the queue
 * 
 * @author rishi
 *
 */
public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode head = new UndirectedGraphNode(node.label);

		queue.add(node);
		map.put(node, head);

		while (!queue.isEmpty()) {
			UndirectedGraphNode curr = queue.pop();
			List<UndirectedGraphNode> currNeighbors = curr.neighbors;

			for (UndirectedGraphNode neighbor : currNeighbors) {
				if (!map.containsKey(neighbor)) {
					UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
					map.put(neighbor, newNode);
					map.get(curr).neighbors.add(newNode);
					queue.add(neighbor);
				} else {
					map.get(curr).neighbors.add(map.get(neighbor));
				}
			}
		}
		return head;
	}

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
	
	public static void main(String[] args) {
		CloneGraph obj = new CloneGraph();
		
		UndirectedGraphNode one = obj.new UndirectedGraphNode(1);
		UndirectedGraphNode zeor = obj.new UndirectedGraphNode(0);
		UndirectedGraphNode two = obj.new UndirectedGraphNode(2);
		
		List<UndirectedGraphNode> neighborsZero = new ArrayList<>();
		neighborsZero.add(one);
		neighborsZero.add(two);
		zeor.neighbors = neighborsZero;
		
		List<UndirectedGraphNode> neighborsOne = new ArrayList<>();
		neighborsOne.add(two);
		one.neighbors = neighborsOne;
		
		List<UndirectedGraphNode> neighborsTwo = new ArrayList<>();
		neighborsTwo.add(two);
		two.neighbors = neighborsTwo;
		
		UndirectedGraphNode newNode = obj.cloneGraph(zeor);
		System.out.println("Done");
	}
}
