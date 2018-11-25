package com.rishi.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        pathSum(root, sum, finalList, innerList);
        
        return finalList;
    }
    
    public void pathSum(TreeNode root, int sum, List<List<Integer>>finalList, List<Integer> innerList){
    	if(root == null){
    		return;
    	}
    	
    	innerList.add(root.val);
    	sum -= root.val;
    	
    	if(sum == 0){
    		List<Integer> temp = new ArrayList<>(innerList);
    		finalList.add(temp);
    	}
    	
    	pathSum(root.right, sum, finalList, innerList);
    	pathSum(root.left, sum, finalList, innerList);
    	
    	innerList.remove(innerList.size()-1);
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode four = new TreeNode(4);
		TreeNode four1 = new TreeNode(4);
		TreeNode elevan = new TreeNode(4);
		TreeNode seven = new TreeNode(7);
		TreeNode two = new TreeNode(2);
		TreeNode eight = new TreeNode(8);
		TreeNode thirteen = new TreeNode(13);
		TreeNode one = new TreeNode(1);
		
		four.left = elevan;
		elevan.left = seven;
		elevan.right = two;
		
		eight.left = thirteen;
		eight.right = four1;
		four1.right = one; 
				
		root.left = four;
		root.right = eight;
		
		PathSumII obj = new PathSumII();
		System.out.println("Result "+ obj.pathSum(root, 13));
	}
}
