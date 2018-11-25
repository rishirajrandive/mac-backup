package com.rishi.binary.tree;

/**
 * Validates if the given BST is valid
 * @author rishi
 *
 */
public class ValidBST {

	public static boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isValidRec(root, Long.MAX_VALUE, Long.MIN_VALUE);
	}

	public static boolean isValidRec(TreeNode root, long max, long min) {
		if (root == null) {
			return true;
		}

		if (root.val <= min || root.val >= max) {
			return false;
		}

		return isValidRec(root.left, root.val, min) && isValidRec(root.right, max, root.val);
	}
}
