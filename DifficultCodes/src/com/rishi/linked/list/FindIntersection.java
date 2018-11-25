package com.rishi.linked.list;

/**
 * Question is to find the intersecting node (by reference not by value)
 * 
 * Idea is to:
 * 1. Iterate over both lists to find length and tails
 * 2. Compare the tails if different return
 * 3. Get pointers to start of both list. 
 * 4. Skip the first few elements of the longer list
 * 5. Traverse each list till the pointers point to the same object.
 * @author rishi
 *
 */
public class FindIntersection {

	private ListNode getIntersectingNode(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null) {
			return null;
		}
		
		Result result1 = getTailAndSize(l1);
		Result result2 = getTailAndSize(l2);
		
		if(result1.tail != result2.tail) {
			return null;
		}
		
		ListNode longer = (result1.size < result2.size) ? l2 : l1;
		ListNode shorter = (result1.size < result2.size) ? l1 : l2;
		
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));
		
		while(shorter != longer) {
			longer = longer.next;
			shorter = shorter.next;
		}
		
		return longer;
	}
	
	ListNode getKthNode(ListNode node, int k) {
		ListNode curr = node;
		while(k > 0 && curr != null) {
			curr = curr.next;
			k--;
		}
		
		return curr;
	}
	
	class Result{
		public ListNode tail;
		public int size;
		
		public Result(ListNode tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}
	
	Result getTailAndSize(ListNode list) {
		if(list == null){
			return null;
		}
		
		int size = 1;
		ListNode curr = list;
		while(curr.next != null) {
			size++;
			curr = curr.next;
		}
		return new Result(curr, size);			
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(1);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(9);
		
		ListNode common = new ListNode(7);
		common.next = new ListNode(2);
		common.next.next = new ListNode(1);
		
		ListNode other = new ListNode(4);
		other.next = new ListNode(6);
		
		head.next.next.next.next = common;
		other.next.next = common;
		
		FindIntersection obj = new FindIntersection();
		System.out.println("Interesecting node is "+ obj.getIntersectingNode(head, other).val);
	}
}
