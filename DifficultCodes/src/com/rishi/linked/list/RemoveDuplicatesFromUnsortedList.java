package com.rishi.linked.list;

import java.util.HashSet;

/**
 * Question is to remove duplicated values from unsorted list.
 * 
 * Two methods:
 * 1. Using runner pointer which will move fast. This has time complexity O(n2)
 * 2. Using HashSet to check if there is a duplicate, and skip if any. Time complexity is O(n2) but 
 * 		needs temporary buffer;
 * @author rishi
 *
 */
public class RemoveDuplicatesFromUnsortedList {

	public static ListNode deleteDups(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode current = head;
		
		while(current != null) {
			ListNode runner = current;
			while(runner.next != null){
				if(runner.next.val == current.val){
					// Skip to next.next
					runner.next = runner.next.next;
				}else {
					// Go to next
					runner = runner.next;
				}
			}
			current = current.next;
		}
		return head;
	}
	
	public static ListNode deleteDupsBetter(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		
		HashSet<Integer> set = new HashSet<>();
		ListNode previous = null;
		ListNode resultHead = head;
		while(head != null) {
			if(set.contains(head.val)) {
				previous.next = head.next;
			}else {
				set.add(head.val);
				previous = head;
			}
			head = head.next;
		}
		return resultHead;
	}
	
	public static void main(String[] args) {		
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);
		
		ListNode result = deleteDupsBetter(head);
		while(result != null){
			System.out.print(result.val + "->");
			result = result.next;
		}
	}
}
