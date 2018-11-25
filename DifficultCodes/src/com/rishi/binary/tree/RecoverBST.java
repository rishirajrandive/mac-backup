package com.rishi.binary.tree;

/**
 * Any two nodes in the BST are swapped, we need to swap them again to make the BST correct.
 * Example: 
 * 			5
 * 		4		2
 * 	6		3
 * 
 * In-order for above wrong BST is: 6, 4, 3, 5, 2
 * 
 * So we need to swap 6 and 2
 * Correct BST 
 * 			5
 * 		4		6
 * 	2		3
 * In-order for above is: 2, 4, 3, 5, 6
 * @author rishi
 *
 */
public class RecoverBST {

	private static TreeNode first;
	private static TreeNode second;
	private static TreeNode prev = new TreeNode(Integer.MIN_VALUE);
	
	public static void recoverTree(TreeNode root){
		inorderTraverse(root);
		
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}
	
	public static void inorderTraverse(TreeNode root){
		if(root == null){
			return;
		}
		
		inorderTraverse(root.left);
		
		if(first == null && prev.val >= root.val){
			first = prev;
		}
		
		if(first != null && prev.val >= root.val){
			second = root;
		}
		
		prev = root;
		
		inorderTraverse(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode five = new TreeNode(5);
		TreeNode four = new TreeNode(4);
		TreeNode six = new TreeNode(6);
		TreeNode three = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		
		five.left = four;
		five.right = six;
		
		four.left = two;
		four.right = three;
		
		recoverTree(five);
	}
}
