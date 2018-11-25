package com.rishi.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the number n we need to generate all the possible valid parenthesis combinations
 * @author rishi
 *
 */
public class GenerateParantheses {

	private List<String> list = new ArrayList<>(); 
	public List<String> generateParenthesis(int n) {
		
        if(n > 0){
        	genParas("", n, 0, 0);
        }
        
        return list; 
    }
	
	public void genParas(String str, int n, int open, int close){
		if(n == close){
			list.add(str);
			return;
		}else {
			if(open > close){
				genParas(str+")", n, open, close+1);				
			}
			if(open < n){
				genParas(str+"(", n, open+1, close);
			}
		}
	}
	
	public static void main(String[] args) {
		GenerateParantheses obj = new GenerateParantheses();
		System.out.println("Result "+ obj.generateParenthesis(4));
	}
}
