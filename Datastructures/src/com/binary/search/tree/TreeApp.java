package com.binary.search.tree;

public class TreeApp {

	public static void main(String[] args) {
		int value;
		Tree theTree = new Tree();
		theTree.insert(50, 1.5);
		theTree.insert(25, 1.2);
		theTree.insert(75, 1.7);
		theTree.insert(12, 1.5);
		theTree.insert(37, 1.2);
		theTree.insert(43, 1.7);
		theTree.insert(30, 1.5);
		theTree.insert(33, 1.2);
		theTree.insert(87, 1.7);
		theTree.insert(93, 1.5);
		theTree.insert(97, 1.5);
		
//		Node node = theTree.find(43);
//		System.out.println(node.iData + ", " + node.dData);
		theTree.displayTree();
		theTree.traverse();
	}
}
