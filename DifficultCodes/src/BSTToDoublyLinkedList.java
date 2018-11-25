/**
 * This is nothing but converting a tree into inorder representation.
 * For tree structure like:
 * 							4
 * 					2				5
 * 				1		3
 * 
 * The inorder traverse is - 1,  2, 3, 4, 5
 * Postorder traverse is - 1, 3, 2, 5, 4
 * Preorder traverse is - 4, 2, 1, 3, 5
 * @author rishi
 *
 */
public class BSTToDoublyLinkedList {

	TreeNode current;
	TreeNode previous;
	TreeNode head;
	public void convertToDoublyLL(TreeNode node){
		if(node == null){
			return;
		}
		convertToDoublyLL(node.left);
		if(current == null){
			current = node;
			head = current;
		}else {
			previous = current;
			current = node;
			current.left = previous;
			previous.right = current;
		}
		convertToDoublyLL(node.right);
		
		// Connects both ends making it circular
		if(current.right == null){
			head.left = current;
			current.right = head;
		}
	}

	public TreeNode createTree(int[] nodes, int index){
		TreeNode root = null;
		if(index < nodes.length && nodes[index] != -1){
			root = new TreeNode(nodes[index]);
			root.left = createTree(nodes, (2*index + 1));
			root.right = createTree(nodes, (2*index + 2));
		}
		return root;
	}
	
	public void printList() {
        TreeNode current = head;
        
        while (current != null) {
            System.out.print(Integer.toString(current.val) + " ");
            current = current.right;
            if (current == head) break;
        }
        
        System.out.println();
    }
	
	public static void printList(TreeNode head) {
        TreeNode current = head;
        
        while (current != null) {
            System.out.print(Integer.toString(current.val) + " ");
            current = current.right;
            if (current == head) break;
        }
        
        System.out.println();
    }
	
	
	/*
    helper function -- given two list nodes, join them
    together so the second immediately follow the first.
    Sets the .next of the first and the .previous of the second.
   */
   public static void join(TreeNode a, TreeNode b) {
       a.right = b;
       b.left = a;
   }

   
   /*
    helper function -- given two circular doubly linked
    lists, append them and return the new list.
   */
   public static TreeNode append(TreeNode a, TreeNode b) {
       // if either is null, return the other
       if (a==null) return(b);
       if (b==null) return(a);
       
       // find the last node in each using the .previous pointer
       TreeNode aLast = a.left;
       TreeNode bLast = b.left;
       
       // join the two together to make it connected and circular
       join(aLast, b);
       join(bLast, a);
       
       return(a);
   }

   /*
    --Recursion--
    Given an ordered binary tree, recursively change it into
    a circular doubly linked list which is returned.
   */
   public static TreeNode treeToList(TreeNode root) {
       // base case: empty tree -> empty list
       if (root==null) return(null);
       
       // Recursively do the subtrees (leap of faith!)
       TreeNode aList = treeToList(root.left);
       TreeNode bList = treeToList(root.right);
       
       // Make the single root node into a list length-1
       // in preparation for the appending
       root.left = root;
       root.right = root;
       
       // At this point we have three lists, and it's
       // just a matter of appending them together
       // in the right order (aList, root, bList)
       aList = append(aList, root);
       aList = append(aList, bList);
       
       return(aList);
   }
	
	public static void main(String[] args) {
		System.out.println("Start of the program");
		BSTToDoublyLinkedList obj = new BSTToDoublyLinkedList();
		
		int[] nodes = {4, 2, 5, 1, 3, -1, -1};
		TreeNode root = obj.createTree(nodes, 0);
		
		//obj.convertToDoublyLL(root);
		//obj.printList();
		TreeNode newRoot = treeToList(root);
		printList(newRoot);
		
		
	}
}
