package com.rishi.linked.list;

import java.util.Stack;

/**
 * Question is to find if the list is palindrome or not
 * 
 * Two solutions:
 * 1. Get the reverse of the list and then compare the original with reversed. 
 * 2. Use stack to push the values till middle of the list and then compare the rest of list with values poppping
 * from the stack.
 * @author rishi
 *
 */
public class CheckPalindrome {

	private static boolean isPalindromeUsingReverse(ListNode head) {
		ListNode reversed = null;
		ListNode original = head;
		
		while(head != null) {
			ListNode newNode = new ListNode(head.val);
			newNode.next = reversed;
			reversed = newNode;
			
			head = head.next;
		}
		
		while(original != null && reversed != null) {
			if(original.val != reversed.val) {
				return false;
			}
			original = original.next;
			reversed = reversed.next;
		}
		
		return original == null && reversed == null;
	}
	
	private static boolean isPalindromeUsingStack(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		Stack<Integer> stack = new Stack<>();
		
		while(fast != null && fast.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// Odd number, so skip the middle one
		if(fast != null) {
			slow = slow.next;
		}
		
		while(slow != null) {
			int top = stack.pop().intValue();
			
			if(top != slow.val) {
				return false;
			}
			slow = slow.next;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next = new ListNode(0);
		
		System.out.println("Is palindrome using reverse "+ isPalindromeUsingReverse(head));
		System.out.println("Is palindrome using stack "+ isPalindromeUsingStack(head));
	}
	
}
