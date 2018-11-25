package spring2017;

import java.util.Stack;

public class LinkedListAddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
}
