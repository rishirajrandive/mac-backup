package com.rishi.binary.tree;

/**
 * Using in-order for Binary search tree would give us the linked list. However, here we need to do the opposite.
 * 
 * There are two methods using recursion
 * #1 This is one is faster.
 * Here, we pass start and end to the recursive method and every time we find the mid of start and end
 * create the node with mid and the do same for left and then right.
 * 
 * #2 Idea is similar to #1, only difference is we pass n (length of linked list)
 * For left we call it using n/2
 * For right we call it using n-n/2-1
 * In between we create the tree node using head and forward head
 * @author rishi
 *
 */
public class ConvertSortedListToBST {
	
	private static ListNode head;
	public static TreeNode sortedListToBST(ListNode head) {
		return rec(head, null);
	}
	
	public static TreeNode rec(ListNode start, ListNode end){
		if(start == end){
			return null;
		}
		
		ListNode mid = start;
		ListNode fast = start;
		
		while(start != end && start.next != end){
			mid = mid.next;
			fast = fast.next.next;
		}
		
		TreeNode root = new TreeNode(mid.val);
		root.left = rec(start, mid);
		root.right = rec(mid.next, end);
		
		return root;
	}
	
	public static TreeNode rec2(int n){
		if(n <= 0){
			return null;
		}
		
		TreeNode left = rec2(n/2);
		TreeNode root = new TreeNode(head.val);
		root.left = left;
		head = head.next;
		root.right = rec2(n - n/2 - 1);
		
		return root;
	}
	
	
	public static void main(String[] args) {
		ListNode root = new ListNode(0);
		ListNode two = new ListNode(1);
		ListNode three = new ListNode(2);
		ListNode four = new ListNode(3);
		ListNode five = new ListNode(4);
		ListNode six = new ListNode(5);
		
		root.next = two;
		root.next.next = three;
		root.next.next.next = four;
		root.next.next.next.next = five;
		root.next.next.next.next.next = six;
		
		sortedListToBST(root);
	}
}
