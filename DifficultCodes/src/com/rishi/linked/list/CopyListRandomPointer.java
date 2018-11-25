package com.rishi.linked.list;

import java.util.HashMap;
import java.util.Map;

/**
 * We need to deep copy a linked list with nodes of type RandomListNode, where apart from having
 * next it also has random pointer. This random points to any node in the linked list.
 * Idea is to:
 * 1. Create a map with key as existing nodes and values as new nodes with same value.
 * 2. Then in other iteration, add next and random pointers. Basically take items from map and
 * add next and random
 * @author rishi
 *
 */
public class CopyListRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		  
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
  
        // loop 1. copy all the nodes
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
	}
}
