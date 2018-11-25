package com.rishi.binary.tree;

/**
 * Need to find the minimum distance to leaf of all the paths to leaf
 * Idea is to, is to start with left and then write and keep comparing the min, however, we will have some 
 * checks instead of checking it directly
 * 1. If left and right both null return 1
 * 2. If left is not null and right is null, make recursive call with left +1
 * 4. If left is null and right is not null, make recursive call with right +1
 * 5. Else make recursive call Math.min
 * @author rishi
 *
 */
public class MinDepthOfBinaryTree {

	public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left != null && root.right == null){
            return minDepth(root.left)+1;
        }else if(root.left == null && root.right != null){
            return minDepth(root.right)+1;
        }else {
            return Math.min(minDepth(root.left), minDepth(root.right))+1;
        }
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
		
//		five.left = six;
		six.right = seven;
		seven.left = eight;
		seven.right = nine;
		
		root.left = two;
		root.right = five;
		
		MinDepthOfBinaryTree obj = new MinDepthOfBinaryTree();
		System.out.println("Result "+ obj.minDepth(root));
	}
}
