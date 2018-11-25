package com.rishi.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Here we need to find which histogram bars each with width 1 form the rectangle with max area.
 * Histograms connected to each other will only be able to form such rectangle. 
 * Idea is to:
 * 1. Have a another array with length+1 than the given array
 * 2. Create a stack to keep the indices
 * 3. Iterate over the array and
 * 		a. Push the index in the stack if the stack is either empty or element at top index 
 * 			is <= current index element
 * 		b. Else pop the element calculate the max area using height at top index 
 * @author rishi
 *
 */
public class LargestRectangleInHistogram {

	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int i=0;
        int maxArea = 0;
        int[] h = new int[heights.length+1];
        h = Arrays.copyOf(heights, heights.length+1);
       
        while(i < h.length) {
            if(stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i-stack.peek() - 1));
            }
        }
        return maxArea;
	}
	
	public static void main(String[] args) {
		LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
		int[] input = {2,1,5,6,7,2,3};
//		int[] input = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		
		System.out.println("Result "+ obj.largestRectangleArea(input));
	}
}
