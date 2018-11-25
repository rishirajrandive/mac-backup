package com.rishi.linked.list;

/**
 * We need to remove node at n from the end. Example: 1 -> 2 -> 3 -> 4 -> 5 and n=2
 * After removal, 1 -> 2 -> 3 -> 5
 * Idea is to:
 * 1. Create a dummy node
 * 2. Start two far and near nodes from dummy
 * 3. Take far till value n
 * 4. Then while far.next != null, proceed far and near
 * 5. #4 makes sure that there is always distance of n between near and far
 * 6. So when far reaches end, near would be the node which needs to be removed
 * 7. Skip next for near and assign next to next
 * 8. Return dummy.next
 * 
 * @author rishi
 *
 */
public class RemoveNthNodeFromEnd {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode near = dummy;
		ListNode far = dummy;
		
		for(int i=0; i<n; i++){
			far = far.next;
		}
		
		while(far.next != null){
			far = far.next;
			near = near.next;
		}
		
		near.next = near.next.next;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		//head.next = new ListNode(3);
		//head.next.next = new ListNode(2);
		// head.next.next.next = new ListNode(3);
		// head.next.next.next.next = new ListNode(4);
		// head.next.next.next.next.next = new ListNode(4);
		// head.next.next.next.next.next.next = new ListNode(5);

		ListNode result = removeNthFromEnd(head, 1);
		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
	}
}
