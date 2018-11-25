package com.rishi.linked.list;

/**
 * Similar to detecting the cycle, we need to return the node at which the cycle starts. So for given example
 * it starts at 3.
 * Idea is:
 * 1. Once we find we have cycle, break the loop
 * 2. Check if fast is null or fast.next == null
 * 3. If not, assign slow = head
 * 4. Check while slow != fast, and move both by one.
 * 
 * These will meet at the point where cycle start so return either fast or slow.
 * @author rishi
 *
 */
public class LinkedListCycleII {

	public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow){
                break;
            }
        }
        
        if(fast == null || fast.next == null){
            return null;
        }
        
        slow = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
	
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = three;
		
		System.out.println(detectCycle(one).val);
		
	}
}
