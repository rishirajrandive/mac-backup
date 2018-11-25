package com.rishi.stacks.queues;

import java.util.Arrays;
import java.util.Stack;

/**
 * Check https://leetcode.com/problems/largest-rectangle-in-histogram/#/description for graphic explanation
 * Simple idea is:
 * 1. Push elements to stack if its empty or top element of stack is <= current
 * 2. When #1 is not true, pop item from stack and find area
 * 3. Area is calculated using two method:
 * 		a. If stack is empty; element at index top in given array * current index i
 * 		b. Else, current index - top - 1
 * 4. Keep max area and repeat till end of array
 * @author rishi
 *
 */
public class LargestRectHistogram {

	public static int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length+1);
        
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            } else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() -1));
            }
        }
        return maxArea;
    }
	
	public static void main(String[] args) {
		int[] h = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(h));
	}
}
