package com.rishi.sort;

/**
 * Insertion sor for linked list
 * @author rishi
 *
 */
public class InsertionSortLinkedList {

	public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;

        // Create a dummy node for future references
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        
        while(head.next != null){
        	// Check if the next value is greater i.e. in sequence
            if(head.next.val >= head.val){
                head = head.next;
            }else {
            	// If not take the next into temp and change the connections
            	// Temp would point to null for now
                ListNode temp = head.next;
                head.next = temp.next;
                temp.next = null;
                
                // To insert temp at correct location start from beginning
                ListNode ptr = dummy;
                // Go till we find a number whose next is smaller than temp
                while(ptr.next.val < temp.val){
                    ptr = ptr.next;
                }
                // Place temp at correct location
                temp.next = ptr.next;
                ptr.next = temp;
            }
        }
        return dummy.next;
    }
}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
