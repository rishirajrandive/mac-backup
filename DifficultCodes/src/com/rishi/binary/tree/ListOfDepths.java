package com.rishi.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Question is to create linked list for each depth level of binary tree.
 * 
 * There are two solutions
 * 1. Recursive
 * 		1. Pass the level + 1 for each recursive call
 * 		2. Check list corresponds to the same level (if result list size == level)
 * 		3. If yes, create new list and add it to result list, and add root (current node) to the new list
 * 		4. If no, then get the list out of the result list for that level and add root (current node) to the list
 * 		5. Make recursive call for left and right nodes.
 * 
 * 2. Iterative
 * 		1. Have result list and current list.
 * 		2. Add root to the current list and then iterate over current list till size > 0
 * 		3. Add this list to result list and reinitialize the current list
 * 		4. Iterate over the parents (current list previous value) and left and right to current.
 * 		
 * @author rishi
 *
 */
public class ListOfDepths {

	private static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
		createLevelLinkedList(root, result, 0);
		
		return result;
	}
	
	private static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> result, int level) {
		if(root == null) {
			return;
		}
		
		LinkedList<TreeNode> list = null;
		if(result.size() == level) {
			list = new LinkedList<>();
			result.add(list);
		}else {
			list = result.get(level);
		}
		
		list.add(root);
		createLevelLinkedList(root.left, result, level+1);
		createLevelLinkedList(root.right, result, level+1);
	}
	
	private static ArrayList<LinkedList<TreeNode>> iterativeCreateLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
		LinkedList<TreeNode> current = new LinkedList<>();
		
		if(root != null) {
			current.add(root);
		}
		
		while(current.size() > 0) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<>();
			
			for(TreeNode parent : parents) {
				if(parent.left != null) {
					current.add(parent.left);
				}
				if(parent.right != null) {
					current.add(parent.right);
				}
				
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		TreeNode seven = new TreeNode(7);
		TreeNode five = new TreeNode(5);
		TreeNode four = new TreeNode(4);
		TreeNode six = new TreeNode(6);
		TreeNode three = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		
		TreeNode root = new TreeNode(1);
		
		four.left = two;
		four.right = six;
		
		two.left = root;
		two.right = three;
		
		six.left = five;
		six.right = seven;
		
		printResult(createLevelLinkedList(four));
		printResult(iterativeCreateLevelLinkedList(four));
		
		
	}
	
	private static void printResult(ArrayList<LinkedList<TreeNode>> result) {
		for(LinkedList<TreeNode> items : result) {
			System.out.println("");
			for(TreeNode node : items) {
				System.out.print(node.val + "->");
			}
		}
	}
}
