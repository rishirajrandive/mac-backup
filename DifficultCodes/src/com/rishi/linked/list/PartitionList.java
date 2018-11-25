package com.rishi.linked.list;

/**
 * Question is to Partition the linkedlist around the a pivot value. All values less than pivot
 * should come to left and values greater than pivot should come to right.
 * 
 * Idea is to:
 * 1. Have two lists left and right.
 * 2. Iterate over the given list, and if value is less append to left else to right list.
 * 3. Finally merge the two list and return.
 * @author rishi
 *
 */
public class PartitionList {

	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode left = new ListNode(0);
		ListNode right = new ListNode(0);
		ListNode leftHead = left;
		ListNode rightHead = right;

		ListNode curr = head;

		while (curr != null) {
			ListNode temp = curr;
			curr = temp.next;
			temp.next = null;

			if (temp.val < x) {
				left.next = temp;
				left = left.next;
			} else {
				right.next = temp;
				right = right.next;
			}
		}

		left.next = rightHead.next;
		return leftHead.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);

		ListNode result = partition(head, 3);

		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
	}
}
