
public class MaxDepth {
	public int maxDepth(TreeNode current, int depth){
        if(current != null){
        	System.out.println("Node "+ current.val);
            int depth1 = maxDepth(current.left, depth+1);
            int depth2 = maxDepth(current.right, depth+1);
            
            return depth1>depth2 ? depth1 : depth2;
        }else {
        	System.out.println("Node "+ current);
        }
        return depth;
    }
	public int maxDepth(TreeNode a) {
	    return maxDepth(a, 0);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		TreeNode ten = new TreeNode(10);
		
		root.left = two;
		root.right = three;
		
		two.left = six;
		two.right = seven;
		
		seven.left = eight;
		seven.right = nine;
		
		three.left = four;
		
		four.right = five;
		
		five.left = ten;
		MaxDepth obj = new MaxDepth();
		
		System.out.println(obj.maxDepth(root));
	}
}
