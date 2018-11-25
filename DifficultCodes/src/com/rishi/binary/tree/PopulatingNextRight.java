package com.rishi.binary.tree;

/**
 * Given:
 * 
 * 				  1
 * 			2			3
 * 		4		5	4		7
 * 
 * We need to point to the right:
 * 				  1 -> NULL
 * 			2    ->		3 -> NULL
 * 		4	->	5 -> 4  ->	7 -> NULL
 * 
 * The tree is balanced. Idea is to:
 * 1. Check left and point its next to right
 * 2. Check if right and next exists and point right's next to next's left
 * 4. Recursive call to left and then to right 
 * @author rishi
 *
 */
public class PopulatingNextRight {

	public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        
        if(root.left != null){
            root.left.next = root.right;
        }
        
        if(root.right != null && root.next != null){
            root.right.next = root.next.left;
        }
        
        connect(root.left);
        connect(root.right);
    }
    
    
    
    public static void main(String[] args) {
    	TreeLinkNode root = new TreeLinkNode(0);
    	
    	TreeLinkNode five = new TreeLinkNode(5);
    	TreeLinkNode four = new TreeLinkNode(4);
    	TreeLinkNode six = new TreeLinkNode(6);
    	TreeLinkNode three = new TreeLinkNode(3);
    	TreeLinkNode two = new TreeLinkNode(2);
    	TreeLinkNode one = new TreeLinkNode(1);
		
		two.left = five;
		two.right = six;
		
		one.left = three;
		one.right = four;
		
		root.left = one;
		root.right = two;
		
		PopulatingNextRight obj = new PopulatingNextRight();
		obj.connect(root);
	}
}
