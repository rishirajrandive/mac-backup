package com.rishi.binary.tree;

/**
 * Recursion makes it easy for attaching the left and right nodes
 * @author rishi
 *
 */
public class ConvertSortedArrayToBST {
	
	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null)
			return null;
		return rec(nums, 0, nums.length);
	}

	public static TreeNode rec(int[] nums, int low, int high) {
		if (low == high)
			return null;

		int mid = (low + high) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = rec(nums, low, mid);
		root.right = rec(nums, mid + 1, high);

		return root;
	}
	
	public static void main(String[] args) {
		
	}
}
