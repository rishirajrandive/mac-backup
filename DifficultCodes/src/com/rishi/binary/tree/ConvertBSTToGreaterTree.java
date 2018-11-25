package com.rishi.binary.tree;

/**
 * This in-order traversal where we go to right first, visit the node and then go to left.
 * 
 * Idea is to:
 * 1. As it is BST, all the right nodes are greater
 * 2. So we start collecting the sum from right and keep adding as we come to left.
 * @author rishi
 *
 */
public class ConvertBSTToGreaterTree {

	private int sum;
	public TreeNode convertBST(TreeNode root) {
		sum = 0;
        rec(root);
        return root;
    }
	
	public void rec(TreeNode root){
		if(root == null){
			return;
		}
		
		rec(root.right);
		sum += root.val;
		root.val = sum;
		rec(root.left);
	}
	
	public static void main(String[] args) {
		TreeNode five = new TreeNode(5);
		TreeNode two = new TreeNode(2);
		TreeNode thirteen = new TreeNode(13);
		
		TreeNode one = new TreeNode(1);
		TreeNode three = new TreeNode(3);
		TreeNode elevan = new TreeNode(11);
		
		five.left = two;
		five.right = thirteen;
		
		two.left = one;
		two.right = three;
		
		thirteen.left = elevan;
		
		ConvertBSTToGreaterTree obj = new ConvertBSTToGreaterTree();
		
		System.out.println("Result " + obj.convertBST(five));
	}
}
