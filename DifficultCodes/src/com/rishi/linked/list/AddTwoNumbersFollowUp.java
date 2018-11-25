package com.rishi.linked.list;

/**
 * This is a follow up question for Add two numbers. Here, the numbers are in there natural
 * sequence. Where left is largest place value and right is unit value. In this case we need to add
 * the two numbers.
 * 
 * Idea is to:
 * 1. First pad the list with length less that other with 0.
 * 2. Recursively go to the last two unit places and
 * 3. Keep forwarding the carry to next sum
 * 4. Every time the sum calculated we save append it to list but before everything.
 *  
 * Using a class wrapper for wrapping the sum and carry.
 * @author rishi
 *
 */
public class AddTwoNumbersFollowUp {

	class PartialSum {
		public ListNode sum = null;
		public int carry =0;
	}
	
	ListNode addLists(ListNode l1, ListNode l2) {
		int len1 =4;
		int len2 = 3;
		
		if(len1 < len2) {
			l1 = padList(l1, len2 - len1);
		}else {
			l2 = padList(l2, len1- len2);
		}
		
		PartialSum sum = addListHelper(l1, l2);
		
		if(sum.carry == 0) {
			return sum.sum;
		}else {
			ListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
	
	PartialSum addListHelper(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		
		PartialSum sum = addListHelper(l1.next, l2.next);
		int val = sum.carry + l1.val + l2.val;
		
		ListNode fullResult = insertBefore(sum.sum, val%10);
		sum.sum = fullResult;
		sum.carry = val/10;
		
		return sum;
	}
	
	ListNode padList(ListNode l, int padding) {
		ListNode head = l;
		for(int i=0; i<padding; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}
	
	ListNode insertBefore(ListNode list, int data) {
		ListNode node = new ListNode(data);
		if(list != null) {
			node.next = list;
		}
		return node;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);
		
		AddTwoNumbersFollowUp obj = new AddTwoNumbersFollowUp();
		ListNode result = obj.addLists(l1, l2);
		while(result != null){
			System.out.print(result.val + " -> ");
			result = result.next;
		}
	}
}
