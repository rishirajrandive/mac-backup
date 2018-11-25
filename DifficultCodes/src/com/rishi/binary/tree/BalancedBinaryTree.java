package com.rishi.binary.tree;

/**
 * We need to find out if the tree is balanced by checking the height of left and right sub tree.
 * If it's the same then it's balanced. Or else the maximum difference can be 1.
 * Difference between the height is more than 1 then it's not balanced.
 * 
 * Write a function to return the height:
 * 1. If the difference is more than 1 we return -1
 * 2. If root is null we return 0
 * 3. If left and right are within permitted range we return left + right + 1
 * @author rishi
 *
 */
public class BalancedBinaryTree {

	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (getHeight(root) == -1)
			return false;

		return true;
	}

	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = getHeight(root.left);
		int right = getHeight(root.right);

		if (left == -1 || right == -1)
			return -1;

		if (Math.abs(left - right) > 1)
			return -1;

		return Math.max(left, right) + 1;
	}
	
	/**
	 * This is better approach with Time complexity O(N) and space O(H) where 
	 * H is height of the tree.
	 * We check for valid height on each level.
	 * @param root
	 * @return
	 */
	public static int checkHeight(TreeNode root) {
		if(root == null) {
			return -1;
		}
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		
		int heightDiff = Math.abs(leftHeight - rightHeight);
		if(heightDiff > 1) {
			return Integer.MIN_VALUE;
		}else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	public static boolean isBalancedBetter(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		TreeNode seven = new TreeNode(7);
		TreeNode five = new TreeNode(5);
		TreeNode four = new TreeNode(4);
		TreeNode six = new TreeNode(6);
		TreeNode three = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		TreeNode root = new TreeNode(1);
		
		two.left = three;
		two.right = four;
		
		five.left = six;
		five.right = seven;
		
		root.left = two;
		root.right = five;
		
		System.out.println("Result "+ isBalanced(root));
		System.out.println("Result better "+ isBalancedBetter(root));
		
	}
}
