package com.rishi.linked.list;

import java.util.HashSet;

/**
 * We need to reorder the list for example:
 * Original list - 1 -> 2 -> 3 -> 4
 * Reordered list - 1 -> 4 -> 2 -> 3
 * 
 * Approach #1:
 * 1. Reverse the list
 * 2. Now we have two list
 * 3. Iterate and for even values take first list and odd take reverse list
 * 4. Here we need extra memory
 * 
 * Approach #2
 * 1. Without create any extra ListNode
 * 2. Use slow and fast pointers and proceed till fast.next != null
 * 3. Assign slow.next to other ListNode and make slow.next = null
 * 4. Reverse the other ListNode
 * 5. Now use two ListNodes p1 and p2, assigned to head and reverse list respectively
 * 6. Proceed with p2 != null
 * 7. temp = p1.next and temp1 = p2.next, p1.next = p2 and p2.next = temp
 * 8. p1 = temp and p2 = temp1
 * 9. 
 * @author rishi
 *
 */
public class ReorderList {

	public static ListNode reorderList(ListNode head) {
		HashSet<Integer> set = new HashSet<>();
		
		if (head == null || head.next == null) {
			return head;
		}

		ListNode reverse = new ListNode(0);
		ListNode temp = null;
		ListNode curr = head;

		int len = 0;

		while (curr != null) {
			len++;
			ListNode newNode = new ListNode(curr.val);
			reverse.next = newNode;
			newNode.next = temp;
			temp = newNode;
			curr = curr.next;
		}

		ListNode result = new ListNode(0);
		reverse = reverse.next;
		curr = head;
		head = result;

		for (int i = 0; i < len; i++) {
			temp = null;
			if (i % 2 == 0) {
				temp = new ListNode(curr.val);
				curr = curr.next;
			} else {
				temp = new ListNode(reverse.val);
				reverse = reverse.next;
			}
			result.next = temp;
			result = result.next;
		}
		return head.next;
	}

	public static void reorderList2(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode second = slow.next;
		slow.next = null;
		second = reverseOrder(second);

		ListNode p1 = head;
		ListNode p2 = second;

		while (p2 != null) {
			ListNode temp1 = p1.next;
			ListNode temp2 = p2.next;

			p1.next = p2;
			p2.next = temp1;

			p1 = temp1;
			p2 = temp2;
		}
	}

	public static ListNode reverseOrder(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		// head.next.next.next.next = new ListNode(4);
		// head.next.next.next.next.next = new ListNode(4);
		// head.next.next.next.next.next.next = new ListNode(5);

		reorderList2(head);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
}
