package com.rishi.binary.tree;

/**
 * Question is to create a minimal height tree from the given array.
 * 
 * Idea is to:
 * For the tree to be minimal height tree, all the elements of array need to be added to the tree
 * such that left and right sub tree have almost same number of nodes.
 * 
 * 1. Create a recursive method where we calculate the mid of the array every time.
 * 2. And add node.left and right recursively.
 * 
 * Steps:
 * 1. Insert into the tree the middle element of the array
 * 2. Insert (into the left subtree) the left subarray elements
 * 3. Insert (into the right subtree) the right subarray elements
 * 4. Recurse
 * 
 * Example: Input arr - {1, 2, 3, 4, 5, 6, 7}
 * Output - 
 * 					4
 * 				  /   \
 * 				 2     6
 * 			    / \   / \
 * 			   1  3  5   7
 * @author rishi
 *
 */
public class MinimalHeightTreeFromArray {

	private static TreeNode createMinimalBST(int arr[]) {
		return createMinimalBST(arr, 0, arr.length - 1);
	}
	
	private static TreeNode createMinimalBST(int arr[], int start, int end) {
		if(end < start) {
			return null;
		}
		
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = createMinimalBST(arr, start, mid-1);
		node.right = createMinimalBST(arr, mid+1, end);
		
		return node;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		TreeNode minimalHeightTree = createMinimalBST(arr);
		System.out.println("Result " + minimalHeightTree);
	}
}
