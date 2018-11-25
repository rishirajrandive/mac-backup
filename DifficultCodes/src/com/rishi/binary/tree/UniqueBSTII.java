package com.rishi.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTII {

	public static List<TreeNode> generateTrees(int n) {
        return rec(1, n);
    }
	
	public static List<TreeNode> rec(int start, int end){
		List<TreeNode> result = new ArrayList<>();
		if(start > end){
			result.add(null);
			return result;
		}
		
		for(int i=start; i<=end; i++){
			List<TreeNode> lefts = rec(start, i-1);
			List<TreeNode> rights = rec(i+1, end);
			
			for(TreeNode left : lefts){
				for(TreeNode right : rights){
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					result.add(node);
				}
			}
		}
		return result;
	}
	
}
