package com.rishi.linked.list;

import java.util.ArrayList;
import java.util.Random;

/**
 * Remove duplicates and keep just one instance of the element.
 * 1 -> 2 -> 2 -> 3 -> 4 Output should be 1 -> 2 -> 3 -> 4
 * 
 * Idea:
 * 1. Create one more list and skip the element equal to current, don't add them. Add the not equal ones.
 * 2. To not use extra space we could do this can comparing, next and next.next. In case equal skip it else continue.
 * @author rishi
 *
 */
public class RemoveDupFromSortedList {

	private static ArrayList<Integer> nums = new ArrayList<>();
	/**
	 * With extra space
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		while (head == null || head.next == null) {
			return head;
		}

		ListNode result = new ListNode(head.val);
		ListNode finalHead = result;

		while (head != null) {
			if (result.val != head.val) {
				result.next = new ListNode(head.val);
				result = result.next;
			}
			head = head.next;
		}
		return finalHead;
	}

	/**
	 * Without using extra space
	 * @param head
	 * @return
	 */
	public static ListNode deleteDups(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode current = head;
		
		while(current.next != null){
			if(current.next.val == current.val){
				// Skip to next.next
				current.next = current.next.next;
			}else {
				// Go to next
				current = current.next;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(1);
//		head.next.next = new ListNode(2);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(6);
//		
//		ListNode result = deleteDups(head);
//		while(result != null){
//			System.out.print(result.val + "->");
//			result = result.next;
//		}
		
		int num = getRandomNumber();
		nums.add(num);
		System.out.println("First "+ num);
		num = getRandomNumber();
		nums.add(num);
		System.out.println("Second "+ num);
		num = getRandomNumber();
		nums.add(num);
		System.out.println("Third "+ num);
		num = getRandomNumber();
		nums.add(num);
		System.out.println("Fourth "+ num);
		
	}
	
	private static int getRandomNumber(){
        Random r = new Random();
        int num = r.nextInt((4 - 1) + 1) + 1;
        return !nums.contains(num) ? num : getRandomNumber();
    }
}
