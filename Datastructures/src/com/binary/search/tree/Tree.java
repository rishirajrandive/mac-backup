package com.binary.search.tree;

import java.util.Stack;

public class Tree {

	private Node root;
	
	public Tree() {
		root = null;
	}
	
	public Node find(int key){
		// (assumes non-empty tree)
		Node current = root; // start at root
		while(current.iData != key) // while no match,
		{
			if(key < current.iData){ 
				// go left?
				current = current.leftChild;
			}
			else{
				// or go right?
				current = current.rightChild;
			}

			if(current == null) {
				// if no child,
				return null; // didn’t find it
			}
		}
		return current; // found it
	} // end find()
	
	
	public void insert(int id, double dd){
		Node newNode = new Node(); // make new node
		newNode.iData = id; // insert data
		newNode.dData = dd;
		if(root==null){
			// no node in root
			root = newNode;
		}
		else {
			// root occupied
			Node current = root; // start at root
			Node parent;
			while(true){ 
				// (exits internally)
				parent = current;
				if(id < current.iData){ 
					// go left?
					current = current.leftChild;
					if(current == null){ // if end of the line,
						// insert on left
						parent.leftChild = newNode;
						return;
					}
				} // end if go left
				else{
					// or go right?
					current = current.rightChild;
					if(current == null){
						// if end of the line
						// insert on right
						parent.rightChild = newNode;
						return;
					}
				} // end else go right
			} // end while
		} // end else not root
	} // end insert()
	
	/**
	 * Returns node with next-highest value after delNode
 	 * goes to right child, then right child’s left descendents
	 * @param delNode
	 * @return
	 */
	private Node getSuccessor(Node delNode){
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		
		if(successor != delNode.rightChild){
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		
		return successor;
	}
	
	public boolean delete(int key){
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.iData != key){
			parent = current;
			if(key < current.iData){
				isLeftChild = true;
				current = current.leftChild;
			}else{
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null){
				return false;
			}
		}
		
		// No children
		if(current.leftChild == null && current.rightChild == null){
			if(current == root){
				root = null;
			}else if(isLeftChild){
				parent.leftChild = null;
			}else{
				parent.rightChild = null;
			}
		}else if(current.rightChild == null){
			if(current == root){
				root = current.leftChild;
			}else if(isLeftChild){
				parent.leftChild = current.leftChild;
			}else {
				parent.rightChild = current.leftChild;
			}
		}else if(current.leftChild == null){
			if(current == root){
				root = current.rightChild;
			}else if(isLeftChild){
				parent.leftChild = current.rightChild;
			}else {
				parent.rightChild = current.rightChild;
			}
		}else {
			Node successor = getSuccessor(current);
			
			if(current == root){
				root = successor;
			}else if(isLeftChild){
				parent.leftChild = successor;
			}else{
				parent.rightChild = successor;
			}
			
			successor.leftChild = current.leftChild;
		}
		return true;
	}
	
	public void traverse(){
		System.out.println("Preorder:");
		preOrderTraverse(root);
		System.out.println("");
		System.out.println("Postorder:");
		postOrderTraverse(root);
		System.out.println("");
		System.out.println("Inorder:");
		inOrderTraverse(root);
	}
	
	public void preOrderTraverse(Node localRoot){
		if(localRoot != null){
			System.out.print(localRoot.iData + " ");
			preOrderTraverse(localRoot.leftChild);
			preOrderTraverse(localRoot.rightChild);
		}
	}
	
	public void inOrderTraverse(Node localRoot){
		if(localRoot != null){
			inOrderTraverse(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrderTraverse(localRoot.rightChild);
		}
	}
	
	public void postOrderTraverse(Node localRoot){
		if(localRoot != null){
			postOrderTraverse(localRoot.leftChild);
			postOrderTraverse(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}
	
	public void displayTree()
	{
	Stack globalStack = new Stack();
	globalStack.push(root);
	int nBlanks = 32;
	boolean isRowEmpty = false;
	System.out.println("......................................................");
	while(isRowEmpty==false){
		Stack localStack = new Stack();
		isRowEmpty = true;
		for(int j=0; j<nBlanks; j++)
			System.out.print(' ');
		while(globalStack.isEmpty()==false){
			Node temp = (Node)globalStack.pop();
			if(temp != null){
				System.out.print(temp.iData);
				localStack.push(temp.leftChild);
				localStack.push(temp.rightChild);
				if(temp.leftChild != null ||
						temp.rightChild != null)
					isRowEmpty = false;
			}
			else{
				System.out.print("--");
				localStack.push(null);
				localStack.push(null);
			}
			for(int j=0; j<nBlanks*2-2; j++)
				System.out.print(' ');
		} // end while globalStack not empty
		System.out.println();
		nBlanks /= 2;
		while(localStack.isEmpty()==false)
			globalStack.push( localStack.pop() );
	} // end while isRowEmpty is false
	System.out.println("......................................................");
	} // end displayTree()
	
	
	
	
}
