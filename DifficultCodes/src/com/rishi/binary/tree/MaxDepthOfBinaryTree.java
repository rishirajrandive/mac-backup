package com.rishi.binary.tree;

/**
 * Need to find the max depth of the tree
 * Idea is to:
 * 1. Go left till null which will contribute 0 to height
 * 2. Then go to right till null
 * 3. Once both left and right and are done, take max at that node and return that.
 * 4. Do this recursively
 * 
 * @author rishi
 *
 */
public class MaxDepthOfBinaryTree {

	private int max;
	
	public int maxDepth(TreeNode root) {
        max = Integer.MIN_VALUE;
        rec(root, 0);
        return max;
    }
	
	public void rec(TreeNode root, int height){
		if(root == null)
			return;
		
		height++;
		rec(root.left, height);
		max = Math.max(max, height);
		rec(root.right, height);
	}
	
	public int maxDepthShort(TreeNode root){
		if(root == null)
			return 0;
		
		return Math.max(maxDepthShort(root.left), maxDepthShort(root.right))+1;
	}
	
	public static void main(String[] args) {
		TreeNode seven = new TreeNode(7);
		TreeNode five = new TreeNode(5);
		TreeNode four = new TreeNode(4);
		TreeNode six = new TreeNode(6);
		TreeNode three = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		TreeNode root = new TreeNode(1);
		
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		
		two.left = three;
		two.right = four;
		
		five.left = six;
		six.right = seven;
		seven.left = eight;
		seven.right = nine;
		
		root.left = two;
		root.right = five;
		
		MaxDepthOfBinaryTree obj = new MaxDepthOfBinaryTree();
		System.out.println("Result "+ obj.maxDepth(root));
	}
}
