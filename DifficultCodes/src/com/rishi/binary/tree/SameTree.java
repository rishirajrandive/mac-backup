package com.rishi.binary.tree;

/**
 * Need to identify if the two given trees have identical structure and same values of each node.
 * @author rishi
 *
 */
public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        
        if(p == null || q == null){
            return false;
        }
        
        if(p.val != q.val){
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
	
	public static void main(String[] args) {
		TreeNode root2 = new TreeNode(1);
		
		TreeNode root = new TreeNode(1);
		TreeNode five = new TreeNode(5);
		TreeNode five1 = new TreeNode(5);
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
		
		five1.left = six;
	
		root2.left = two;
		root2.right = five1;
		
		SameTree obj = new SameTree();
		System.out.println("Result " + obj.isSameTree(root, root2));
	}
}
