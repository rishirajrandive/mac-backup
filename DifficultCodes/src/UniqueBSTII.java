import java.util.ArrayList;
import java.util.List;

public class UniqueBSTII {

	public static void main(String[] args) {
		UniqueBSTII obj = new UniqueBSTII();
		System.out.println(obj.generateTrees(4).size());
		
		
	}
	
	public List<TreeNode> generateTrees(int n) {
        
        if(n == 0) {
            return new ArrayList<TreeNode>();
        }
        
        return gen(1, n);
    }

	 List<TreeNode> gen(int start, int end) {
		 System.out.println("Start "+ start + " end " + end);
	        ArrayList<TreeNode> heads = new ArrayList<TreeNode>();
	        if(start > end) {
	            heads.add(null);
	            return heads;
	        }
	        
	        for(int i = start; i <= end; i++) {
	            
	            List<TreeNode> lefts = gen(start, i - 1);
	            List<TreeNode> rights = gen(i + 1, end);
	            
	            for(TreeNode left : lefts) {
	                for(TreeNode right : rights) {
	                    TreeNode head = new TreeNode(i);
	                    head.left = left;
	                    head.right = right;
	                    heads.add(head);
	                }
	            }
	        }
	        
	        return heads;
	    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
