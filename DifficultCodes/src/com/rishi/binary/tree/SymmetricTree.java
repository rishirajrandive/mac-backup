package com.rishi.binary.tree;

/**
 * Figure out if the tree is symmetric:
 * Below tree is symmetric tree
 *  	  1
 *  	 / \
 *		2   2
 *	   / \ / \
 * 	  3  4 4  3
 * 
 * Idea is to divide the given tree and keep comparing the right and left recursively.
 * @author rishi
 *
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    public boolean isMirror(TreeNode p, TreeNode q){
         if(p == null && q == null){
            return true;
        }
        
        if(p == null || q == null){
            return false;
        }
        
        if(p.val != q.val){
            return false;
        }
        
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}
