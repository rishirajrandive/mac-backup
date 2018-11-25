package com.rishi.linked.list;

/**
 * Need to find out if the linked list has cycle. Example
 * 1 -> 2 -> 3 
 * 		|	 |
 * 		5 <- 4
 * Above should return true.
 * 
 * Idea is to have two pointers:
 * 1. Fast, such that fast = fast.next.next (moves 2 places)
 * 2. Slow, such that slow = slow.next (moves one place)
 * 
 * If there is a cycle in the linked list at some point slow wiil equal to fast.
 * Else not.
 * @author rishi
 *
 */
public class LinkedListCycle {
	public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		//head.next = head;
		
		System.out.println(hasCycle(head));
	}
}
