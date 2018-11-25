package com.rishi.binary.tree;

/**
 * Question is to find Successor and Predecessor of given node if they tree is inorder.
 * 
 * Idea is to:
 * 1. For successor we search the left most item in right subtree, if there is not right subtree the parent is its
 * 		successor
 * 2. For predecessor we search the right most item in the left subtree.
 * 3. Also in case the root.val is greater than val, we make the root as successor because when the val matches root.val
 * 		we might not have a right subtree.
 * 4. Similarly when root.val less than val, we make the root as predecessor because when val matches root.val we might not have 
 * 		the left subtree.
 * @author rishi
 *
 */
public class FindInOrderSuccessorAndPredecessor {

	private static int successor, predecessor;
	
	private static void findSuccessorAndPredecessor(TreeNode root, int val) {
		if(root != null) {
			if(root.val == val) {
				// Find successor by find the go to the leftmost element in right subtree
				if(root.right != null) {
					TreeNode t = root.right;
					while(t.left != null) {
						t = t.left;
					}
					successor = t.val;
				}
				
				// Find predecessor by going to the rightmost element of the left subtree
				if(root.left != null) {
					TreeNode t = root.left;
					while(t.right != null) {
						t = t.right;
					}
					
					predecessor = t.val;
				}
			}else if(root.val > val) {
				successor = root.val;
				findSuccessorAndPredecessor(root.left, val);
			}else if(root.val < val) {
				predecessor = root.val;
				findSuccessorAndPredecessor(root.right, val);
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode seven = new TreeNode(7);
		TreeNode five = new TreeNode(5);
		TreeNode four = new TreeNode(4);
		TreeNode six = new TreeNode(6);
		TreeNode three = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		
		TreeNode root = new TreeNode(1);
		
		four.left = two;
		four.right = six;
		
		two.left = root;
		two.right = three;
		
		six.left = five;
		six.right = seven;
		
		findSuccessorAndPredecessor(four, 6);
		System.out.println("Successor of 6 is "+ successor + " and predecessor " + predecessor);
		
		findSuccessorAndPredecessor(four, 7);
		System.out.println("Successor of 7 is "+ successor + " and predecessor " + predecessor);
		
		findSuccessorAndPredecessor(four,2);
		System.out.println("Successor of 2 is "+ successor + " and predecessor " + predecessor);
	}
}
