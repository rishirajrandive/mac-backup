package com.rishi.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * We need to find if any sum of nodes from root to leaf is equal to sum. Note root to leaf
 * 
 * As we know that we need to root to leaf, hence we go till left and right are null. Then check the sum.
 * 
 * Had we need to check the sum of any nodes in the tree, we need to move the check in the final return statement
 * @author rishi
 *
 */
public class PathSum {
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        
        if(root.left == null && root.right == null){
            return root.val == sum;
        }
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val); // Add || root.val == sum
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode four = new TreeNode(4);
		TreeNode four1 = new TreeNode(4);
		TreeNode elevan = new TreeNode(11);
		TreeNode seven = new TreeNode(7);
		TreeNode two = new TreeNode(2);
		TreeNode eight = new TreeNode(8);
		TreeNode thirteen = new TreeNode(13);
		TreeNode one = new TreeNode(1);
		
		four.left = elevan;
		elevan.left = seven;
		elevan.right = two;
		
		eight.left = thirteen;
		eight.right = four1;
		four1.right = one; 
				
		root.left = four;
		root.right = eight;
		
		PathSum obj = new PathSum();
		System.out.println("Result "+ obj.hasPathSum(root, 29));
	}
}
