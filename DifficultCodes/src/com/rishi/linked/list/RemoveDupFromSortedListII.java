package com.rishi.linked.list;

/**
 * This is similar to removing duplicates, only difference here is we need to remove the node which is duplicate
 * Idea is to have pointer to prev as well
 * 1. Do this till there are nodes in the list
 * 2. Do this till node.next.val = node.val
 * 3. Once the #2 completes we will be at node which is repeated so we take prev.next = curr.next
 * 4. In case prev == curr, we update the head and all pointers to point to curr.next
 * @author rishi
 *
 */
public class RemoveDupFromSortedListII {

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode curr = head;
		ListNode prev = head;

		while (curr != null && curr.next != null) {
			if(curr.next.val == curr.val){
				while (curr.next != null && curr.next.val == curr.val) {
					curr = curr.next;
				}
				if (prev.val != curr.val) {
					prev.next = curr.next;
					curr = curr.next;
				} else {
					head = curr.next;
					prev = curr.next;
					curr = curr.next;
				}
			}else {
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		// head.next.next = new ListNode(3);
		// head.next.next.next = new ListNode(3);
		// head.next.next.next.next = new ListNode(4);
		// head.next.next.next.next.next = new ListNode(4);
		// head.next.next.next.next.next.next = new ListNode(5);

		ListNode result = deleteDuplicates(head);
		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
	}
}
