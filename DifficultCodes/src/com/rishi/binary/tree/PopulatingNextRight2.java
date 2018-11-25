package com.rishi.binary.tree;

/**
 * Similar to Populating Next Right but there is no guarantee that tree will be balanced.
 * 
 * 
 * @author rishi
 *
 */
public class PopulatingNextRight2 {

	public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode prev = dummy;
        
        for(TreeLinkNode curr = root; curr != null; curr = curr.next){
            if(curr.left != null){
                prev.next = curr.left;
                prev = prev.next;
            }
            
            if(curr.right != null){
                prev.next = curr.right;
                prev = prev.next;
            }
        }
        
        connect(dummy.next);
    }
}
