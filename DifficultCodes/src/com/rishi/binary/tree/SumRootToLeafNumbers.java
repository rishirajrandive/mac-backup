package com.rishi.binary.tree;

/**
 * If the given tree is:
 * 
 *  	  1
 *  	 / \
 *		2   5
 *	   / \ / \
 * 	  3  4 6  7
 * 
 * Then the numbers formed from root to leaf are: 123, 124, 156, and 157
 * We need to find the sum: 123+124+156+157 = 560
 * @author rishi
 *
 */
public class SumRootToLeafNumbers {

	public int sumNumbers(TreeNode root, int sum){
		if(root == null){
			return 0;
		}
		
		if(root.left == null && root.right == null){
			return 10*sum + root.val;
		}
		
		return sumNumbers(root.left, 10*sum+root.val) + sumNumbers(root.right, 10*sum+root.val);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode five = new TreeNode(5);
		TreeNode four = new TreeNode(4);
		TreeNode six = new TreeNode(6);
		TreeNode three = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(7);
		
		five.left = six;
		five.right = seven;
		two.left = three;
		two.right = four;
		root.left = two;
		root.right = five;
		
		SumRootToLeafNumbers obj = new SumRootToLeafNumbers();
		System.out.println("Result "+ obj.sumNumbers(root, 0));
	}
}
