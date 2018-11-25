package com.rishi.binary.tree;

/**
 * Idea is to:
 * Do a post order traversal recursively and keep checking the if the value is equal to 
 * either. So we get values for left and right. Conditions can occur:
 * 1. Both the nodes are in different subtrees (common is returned)
 * 2. Both are in same subtree (The node appear first is returned)
 * 3. Only one is present (returns null, as other is not present)
 * 4. Both the nodes are same (return the same)
 * @author rishi
 *
 */
public class LCABinaryTree {

	private boolean isLeft = false;
	private boolean isRight = false;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		/**
		 * Short version of the code, but ignores the condition when one of the
		 * node is not available, still returns the other
		 */
//		if (root == null || root == p || root == q) {
//			return root;
//		}
//		TreeNode left = lowestCommonAncestor(root.left, p, q);
//		TreeNode right = lowestCommonAncestor(root.right, p, q);
//		if (left == null) {
//			return right;
//		} else if (right == null) {
//			return left;
//		} else {
//			return root;
//		}
		if(p == q){
			return p;
		}
		 isLeft = false;
		 isRight = false;
		
		 TreeNode lca = lca(root, p, q);
		
		 if(isLeft && isRight){
		 return lca;
		 }
		
		 return null;
	}

	public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);

		if (root == p) {
			isLeft = true;
			return root;
		}

		if (root == q) {
			isRight = true;
			return root;
		}

		if (left != null && right != null) {
			return root;
		}

		return (left != null) ? left : right;
	}

	public static void main(String[] args) {
//		TreeNode seven = new TreeNode(7);
//		TreeNode five = new TreeNode(5);
//		TreeNode four = new TreeNode(4);
//		TreeNode six = new TreeNode(6);
//		TreeNode three = new TreeNode(3);
//		TreeNode two = new TreeNode(2);
		TreeNode one = new TreeNode(3);
		TreeNode zero = new TreeNode(5);
		TreeNode eight = new TreeNode(1);

//		two.left = seven;
//		two.right = four;
//
//		five.left = six;
//		five.right = two;
//
//		one.left = zero;
//		one.right = eight;
//
//		three.left = five;
//		three.right = one;
		one.left = zero;
		zero.left = eight;

		LCABinaryTree obj = new LCABinaryTree();
		System.out.println("Result " + obj.lowestCommonAncestor(one, zero, eight).val);
	}
}
