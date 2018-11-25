package com.rishi.linked.list;

/**
 * Add two linked list starting from heads and proceed the carry to end.
 * Idea is to:
 * 1. Have a head and l3 nodes with 0 value.
 * 2. Loop over l1 and l2 while l1 != null || l2 != null
 * 3. Add the values to carry and create new node with carry%10
 * 4. Update carry with carry/10
 * 5. End check if carry!=0 and add last node.
 * 6. Return head.next;
 * @author rishi
 *
 */
public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        
        while(l1 != null || l2 != null){
            if(l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }
            
            ListNode newNode = new ListNode(carry % 10);
            l3.next = newNode;
            l3 = newNode;
            
            carry /= 10;
        }
        
        if(carry != 0){
            ListNode lastNode = new ListNode(carry);
            l3.next = lastNode;
            l3 = lastNode;
        }
        return head.next;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode result = addTwoNumbers(l1, l2);
		while(result != null){
			System.out.print(result.val + " -> ");
			result = result.next;
		}
	}
	
}
