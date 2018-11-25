package com.rishi.stacks.queues;

import java.util.Stack;

public class SortStack {

	private static Stack<Integer> sortStack(Stack<Integer> input) {
		Stack<Integer> result = new Stack<>();
		
		while(!input.isEmpty()) {
			int temp = input.pop();
		
			while(!result.isEmpty() && temp > result.peek()) {
				input.push(result.pop());
			}
			
			result.push(temp);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Stack<Integer> input = new Stack<>();
		input.push(8);
		input.push(3);
		input.push(2);
		input.push(1);
		input.push(5);
		input.push(3);
		
		Stack<Integer> result = sortStack(input);
		
		while(!result.isEmpty()) {
			System.out.print(result.pop() + " ");
		}
	}
	
}
