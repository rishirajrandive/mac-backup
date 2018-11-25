package com.rishi.linked.list;

/**
 * Rotate the list to right. Example: 1->2->3->4->5 and k = 2; output should be
 * 4->5->1->2->3
 * 
 * Idea is to:
 * 1. Take a pointer to end of the list while calculating the length
 * 2. Find k %= length, if k = 0, return head
 * 3. Else point the last node to head
 * 4. Move the head to next till i < length - k -1
 * 5. Assign temp = head.next
 * 6. head.next = null
 * 7. Return temp 
 * @author rishi
 *
 */
public class RotateList {

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return head;
		if (k == 0)
			return head;

		ListNode fast = head;
		ListNode slow = head;
		int length = 0;
		
		while(fast != null){
			fast = fast.next;
			length++;
		}

		
		k = k%length;
		
		if(k == 0){
			return head;
		}
		
		int i =0;
		fast = head;
		
		while (fast.next != null) {
			i++;
			fast = fast.next;
			if(i > k)
				slow = slow.next;
		}

		ListNode temp = slow.next;
		slow.next = fast.next;
		fast.next = head;
		head = temp;

		return head;
	}
	
	public static ListNode betterRotateRight(ListNode head, int k){
		if(head == null)
			return head;
		
		ListNode curr = head;
		int len = 1;
		
		while(curr.next != null){
			len++;
			curr = curr.next;
		}
		
		curr.next = head;
		k %= len;
		
		for(int i=0; i<len-k-1; i++){
			head = head.next;
		}
		ListNode temp = head.next;
		head.next = null;
		
		return temp;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

//		ListNode result = rotateRight(head, 20000);
		ListNode result = betterRotateRight(head, 20000);
		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
	}
}
