package com.rishi.hash;

import java.util.HashMap;

/**
 * Deep copy - Instead of just equating the old value to new, we create a new object, so that it has its own copy and
 * not refer to other's copy
 * 
 * 
 * @author rishi
 *
 */
public class CopyListWithRandomPointer {

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;

		RandomListNode node = new RandomListNode(head.label);
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		map.put(head, node);

		RandomListNode curr = head;

		while (curr.next != null) {
			RandomListNode temp = new RandomListNode(curr.next.label);
			map.put(curr.next, temp);
			map.get(curr).next = map.get(curr.next);
			curr = curr.next;
		}

		curr = head;
		while (curr != null) {
			if (curr.random != null) {
				map.get(curr).random = map.get(curr.random);
			} else {
				map.get(curr).random = null;
			}
			curr = curr.next;
		}

		return node;
	}
}
