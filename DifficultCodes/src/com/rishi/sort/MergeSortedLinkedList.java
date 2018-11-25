package com.rishi.sort;

import java.util.List;

public class MergeSortedLinkedList {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
            
        ListNode newList = new ListNode(Integer.MIN_VALUE);
        ListNode current = newList;
        
        while(l1 != null || l2 != null){
            if(l1 == null){
            	current.next = new ListNode(l2.val);
                l2 = l2.next;
            }else if(l2 == null){
            	current.next = new ListNode(l1.val);
                l1 = l1.next;
            }else if(l1.val <= l2.val){
            	current.next = new ListNode(l1.val);
                current = current.next;
                current.next = new ListNode(l2.val);
                l1 = l1.next;
                l2 = l2.next;
            }else {
                current.next = new ListNode(l2.val);
                current = current.next;
                current.next = new ListNode(l1.val);
                l1 = l1.next;
                l2 = l2.next;
            }
            
            current = current.next;
        }
        return newList.next;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(3);
		ListNode l2 = new ListNode(1);
		
		mergeTwoLists(l1, l2);
	}
}
