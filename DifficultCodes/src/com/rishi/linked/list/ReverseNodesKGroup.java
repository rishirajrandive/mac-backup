package com.rishi.linked.list;

/**
 * Given 1->2->3->4->5 and k = 2, we need to reverse the nodes in group of 2. So the output should be
 * 2->1->4->3->5 (note: 5 left as it is as no group formed)
 * 
 * Idea is to:
 * 1. Have two nodes and proceed 2nd node till the count = k
 * 2. When count = k, reverse the list between head and tail
 * 3. Return the reversed list, proceed to next till count
 * 4. Do it till the second list is not equal to null
 * 5. Return the result
 * @author rishi
 *
 */
public class ReverseNodesKGroup {

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return head;

		if (k <= 1)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode p1 = dummy;
		ListNode p2 = head;
		int count = 0;

		while (p2 != null) {
			count++;
			ListNode next = p2.next;
			if (count == k) {
				p1 = reverse(p1, next);
				for(int i=0; i<count-1; i++)
					p1 = p1.next;
				count = 0;
			}
			p2 = next;
		}
		return dummy.next;
	}

	private static ListNode reverse(ListNode head, ListNode tail) {
		ListNode prev = tail;
		ListNode curr = head.next;

		while (curr != tail) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			if(temp == tail){
				break;
			}
			curr = temp;
		}
		head.next = curr;
		return curr;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode result = reverseKGroup(head, 3);
		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
	}
}
