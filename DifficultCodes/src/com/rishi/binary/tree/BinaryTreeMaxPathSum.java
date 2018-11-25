package com.rishi.binary.tree;

/**
 * 
 * @author rishi
 *
 */
public class BinaryTreeMaxPathSum {

	public static int maxPathSum(TreeNode root){
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		
		return max[0];
	}
	
	public static int calculateSum(TreeNode root, int[] max){
		if(root == null){
			return 0;
		}
		
		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);
		
		int current = Math.max(0, Math.max(left, right) + root.val);
		max[0] = Math.max(max[0], Math.max(current, left + root.val + right));
		
		return current;
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
//		root.right = five;
		
		System.out.println("Result "+ maxPathSum(root));
	}
}
