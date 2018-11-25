package com.rishi.linked.list;

/**
 * Similar to reversing nodes, in the given list we need to swap node pairs.
 * Example: 1->2->3->4; result => 2->1->4->3
 * 
 * Idea is to:
 * 1. Create a dummy node and assign dummy.next = head
 * 2. Start with dummy 
 * 3. Check next and next.next and swap these two
 * @author rishi
 *
 */
public class SwapNodePairs {

	public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        
        while(curr.next != null && curr.next.next != null){
            ListNode n1 = curr.next;
            ListNode n2 = curr.next.next;
            
            n1.next = n2.next;
            n2.next = n1;
            curr.next = n2;
            curr = n1;
        }
        return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode result = swapPairs(head);
		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
	}
}
