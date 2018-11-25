package com.rishi.stacks.queues;

import java.util.Stack;

/**
 * Check the notebook notes for details about what kind of paths are there and what is okay or not
 * https://unix.stackexchange.com/questions/125522/path-syntax-rules
 * 
 * We need to simplify the absolute paths.
 * Idea is to:
 * 1. Four components - /, drive or folder name, ., and ..
 * 2. We split by /, we have array of other three elements
 * 3. For name, we push the stack
 * 4. For .. we pop, rest we ignore
 * 5. Finally stack is our output
 * 
 * NOTE: Stack could be iterated like array
 * @author rishi
 *
 */
public class SimplifyPath {

	public static String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return path;
        }
        
        String[] elements = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for(int i=0; i<elements.length; i++){
            if(elements[i].equals("..")){
                if(!stack.isEmpty())
                	stack.pop();
            }else if(elements[i].length() > 0 && !elements[i].equals(".")) {
                stack.push(elements[i]);
            }
        }
        
        StringBuilder result = new StringBuilder();

        for(String s : stack){
        	result.append("/"+ s);
        }
        
        return result.length() == 0 ? "/" : result.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(simplifyPath("/home//foo/"));
	}
}
