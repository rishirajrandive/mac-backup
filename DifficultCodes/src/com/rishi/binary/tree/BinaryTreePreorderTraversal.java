package com.rishi.binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Pre, post, and in order traversals for binary tree.
 * Each method has explanation about the logic, especially for iterative ones
 * Recursive is simple to understand
 * @author rishi
 *
 */
public class BinaryTreePreorderTraversal {
	
	/**
	 * We need to maintain the stack for right nodes only.
	 * Idea is to:
	 * 1. Go to left of the tree while checking for right nodes
	 * 2. If right node is available push it stack.
	 * 3. And when we reach the leftmost node and stack is not empty, pop the stack
	 * 4. Do above steps till root != null
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null) {
        	list.add(root.val);
        	if(root.right != null) {
        		stack.push(root.right);
        	}
        	root = root.left;
        	if(root == null && !stack.isEmpty()) {
        		root = stack.pop();
        	}
        }
        
        return list;
    }
	
	public List<Integer> preorderRecurrsive(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		preorderRec(list, root);
		
		return list;
	}
	
	private void preorderRec(List<Integer> list, TreeNode root) {
		if(root == null) {
			return;
		}
		
		list.add(root.val);
		preorderRec(list, root.left);
		preorderRec(list, root.right);
	}
	
	/**
	 * Post order traversal idea is to do the following while stack is not empty OR
	 * root is not null:
	 * 1. If root has right child, push right to stack and then root. Point the root to left.
	 * 2. If root has no right child then push root and then point root to left
	 * 3. If root is null, pop the stack 
	 * 		a. if popped item is equal to stack top, pop next and point root to it
	 * 		b. else add item popped in #3 to list or print. And make root null
	 * 
	 */
	public List<Integer> postOrderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while(!stack.isEmpty() || root != null) {
        	if(root == null) {
        		TreeNode temp = stack.pop();
        		if(!stack.isEmpty() && temp.right == stack.peek()) {
        			root = stack.pop();
        			stack.push(temp);
        		}else {
        			list.add(temp.val);
        			root = null;
        		}
        	}else if(root.right != null) {
        		stack.push(root.right);
        		stack.push(root);
        		root = root.left;
        	}else if(root.right == null) {
        		stack.push(root);
        		root = root.left;
        	}
        }
        
        return list;
	}
	
	public List<Integer> postorderRecurrsive(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		postorderRec(list, root);
		
		return list;
	}
	
	private void postorderRec(List<Integer> list, TreeNode root) {
		if(root == null) {
			return;
		}
		postorderRec(list, root.left);
		postorderRec(list, root.right);
		list.add(root.val);
	}
	
	/**
	 * In-order idea is to go till left while adding elements to stack and then keep popping
	 * stack and print/add to list. If right is not null, go to left again while adding items to stack. 
	 * 1. Create an empty stack S.
	 * 2. Initialize current node as root
	 * 3. Push the current node to S and set current = current->left until current is NULL
	 * 4. If current is NULL and stack is not empty then 
	 * 		a. Pop the top item from stack.
	 * 		b. Print the popped item, set current = popped_item->right 
	 * 		c. Go to step 3.
	 * 5. If current is NULL and stack is empty then we are done.
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
		
		while(!stack.isEmpty()) {
			root = stack.pop();
			list.add(root.val);
			if(root.right != null) {
				root = root.right;
				while(root != null) {
					stack.push(root);
					root = root.left;
				}
			}
		}
		
		return list;
	}
	
	public List<Integer> inorderRecurrsive(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorderRec(list, root);
		
		return list;
	}
	
	private void inorderRec(List<Integer> list, TreeNode root) {
		if(root == null) {
			return;
		}
		inorderRec(list, root.left);
		list.add(root.val);
		inorderRec(list, root.right);
	}
	
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		
		one.left = two;
		one.right = three;
		
		two.left = four;
		two.right = five;
		
		three.left = six;
		three.right = seven;
		
		BinaryTreePreorderTraversal obj = new BinaryTreePreorderTraversal();
		obj.printData("Iterative pre-order", obj.preorderTraversal(one));
		obj.printData("Recursive pre-order", obj.preorderRecurrsive(one));
		
		obj.printData("Iterative post-order", obj.postOrderTraversal(one));
		obj.printData("Recursive post-order", obj.postorderRecurrsive(one));
		
		obj.printData("Iterative in-order", obj.inorderTraversal(one));
		obj.printData("Recursive in-order", obj.inorderRecurrsive(one));
	}
	
	private void printData(String msg, List<Integer> result){
		System.out.println(msg);
		for(Integer val : result) {
			System.out.print(val + " ");
		}
		System.out.println("");
		System.out.println("");
	}
}
