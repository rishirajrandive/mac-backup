package com.rishi.binary.tree;

/**
 * Tilt of tree is: absolute difference between sum of left and right subtree.
 * Example: 
 * 				1
 *             / \
 * 			  2	  3
 * 		     / 	 /
 * 		    4	5
 * For node 2, tilt is 4 - 0 = 4
 * And for 3 it's, 5 - 0 = 5
 * Total is 9.
 * Now for 1 it is we get the sum of left and right subtree
 * Left - 4+2 = 6
 * Right - 5 + 3 = 8
 * Tilt for 1 is: |6-8| = 2
 * 
 * Total = 9 + 2 = 11
 * 
 * @author rishi
 *
 */
public class BinaryTreeTilt {

	private int tilt;
	
	public int findTilt(TreeNode root) {
		tilt = 0;
        rec(root);
        return tilt;
    }
	
	public int rec(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int left = rec(root.left);
		int right = rec(root.right);
		tilt += Math.abs(left - right);
		
		return left + right + root.val;
	}
	
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		
		one.left = two;
		one.right = three;
		
		two.left = four;
		three.left = five;
		
		BinaryTreeTilt obj = new BinaryTreeTilt();
		System.out.println("Result " + obj.findTilt(one));
	}
}
