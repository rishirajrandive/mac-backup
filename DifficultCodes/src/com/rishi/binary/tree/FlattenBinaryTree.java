package com.rishi.binary.tree;
import java.util.LinkedList;
import java.util.Queue;


public class FlattenBinaryTree {

	private Queue<TreeNode> flatNodes;
	
	public void quickFlatten(TreeNode root){
		rec(root, null);
	}
	
	public TreeNode rec(TreeNode root, TreeNode list){
		if(root == null)
			return list;
		
		TreeNode right = rec(root.right, list);
		root.right = rec(root.left, right);
		root.left = null;
		
		return root;
	}
	
	public TreeNode flatten(TreeNode a) {
	   flatNodes = new LinkedList<>();
	   preOrderTraverse(a);
	   System.out.println("Printing flat nodes");
	   
	  
	   TreeNode node = flatNodes.remove();
	   TreeNode A = node;
	   TreeNode next;
	   while(!flatNodes.isEmpty()){
		   next = flatNodes.remove();
		   node.right = next;
		   node.left = null;
		   node = next;
	   }
	   
	   return A;
	}
	
	private void preOrderTraverse(TreeNode localRoot){
		if(localRoot != null){
			flatNodes.add(localRoot);
			preOrderTraverse(localRoot.left);
			preOrderTraverse(localRoot.right);
		}
	}
	
	public TreeNode createTree(int[] nodes, int index){
		TreeNode node = null;
		if(index < nodes.length && nodes[index] != -1){
			node = new TreeNode(nodes[index]);
			node.left = createTree(nodes, (2*index + 1));
			node.right = createTree(nodes, (2*index + 2));
		}
		return node;
	}
	public static void main(String[] args) {
		FlattenBinaryTree obj = new FlattenBinaryTree();
		
		int nodes[] = {127, 47, 42, 52, 41, 44, 50, 64, 40, -1, 43, 45, 49, 51, 63, 77, -1, -1, -1, -1, -1, 46, 48, -1, -1, -1, 55, -1, 75, 88, -1, -1, -1, -1, 53, 58, 69, 76, 81, 94, -1, 54, 56, 60, 68, 73, -1, -1, 79, 87, 92, 100, -1, -1, -1, 57, 59, 61, 66, -1, 72, 74, 78, 80, 85, -1, 89, 93, 96, 102, -1, -1, -1, -1, -1, 62, 65, 67, 71, -1, -1, -1, -1, -1, -1, -1, 84, 86, -1, 90, -1, -1, 95, 99, 101, -1, -1, -1, -1, -1, -1, -1, 70, -1, 83, -1, -1, -1, -1, 91, -1, -1, 98, -1, -1, -1, -1, -1, 82, -1, -1, -1, 97, -1, -1, -1, -1, -1};
		TreeNode finalNode = obj.createTree(nodes, 0);
		
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
		root.right = five;
		
		two.left = three;
		two.right = four;
		
		five.left = six;
		five.right = seven;
		
//		TreeNode result = obj.flatten(finalNode);
//		while(result != null){
//			System.out.println(result.val + " ");
//			result = result.right;
//		}
		
		obj.quickFlatten(root);
		while(root != null){
			System.out.print(root.val + " ");
			root = root.right;
		}
	}
}

//class TreeNode{
//	public TreeNode left;
//	public TreeNode right;
//	public int val;
//	
//	public TreeNode(int v){
//		val = v;
//		left = null;
//		right = null;
//	}
//}
