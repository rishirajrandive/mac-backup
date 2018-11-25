package com.rishi.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Cloning the given input graph to create same different object. Concept could be applied when 
 * serializing and de-serializing objects
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
