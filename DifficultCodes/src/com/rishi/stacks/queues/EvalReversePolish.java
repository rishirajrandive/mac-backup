package com.rishi.stacks.queues;

import java.util.Stack;

/**
 * Simple postfix notation evalution code
 * @author rishi
 *
 */
public class EvalReversePolish {

	public static int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();
		int sec = 0;
		int first = 0;
		for (int i = 0; i < tokens.length; i++) {
			if (!isOperator(tokens[i])) {
				try{
					stack.push(Integer.parseInt(tokens[i]));
				}catch(NumberFormatException ex){
					System.out.println("Illegal expression given "+ ex.getMessage());
					return Integer.MIN_VALUE;
				}
				
			} else {
				if (stack.size() < 2) {
					return Integer.MIN_VALUE;
				} else {
					switch (tokens[i]) {
					case "+":
						sec = stack.pop();
						first = stack.pop();
						stack.push(first + sec);
						break;
					case "-":
						sec = stack.pop();
						first = stack.pop();
						stack.push(first - sec);
						break;
					case "*":
						sec = stack.pop();
						first = stack.pop();
						stack.push(first * sec);
						break;
					case "/":
						sec = stack.pop();
						first = stack.pop();
						stack.push(first / sec);
						break;
					default:
						System.out.println("Illegal expression");
					}
				}
			}
		}
		return stack.pop();
	}

	private static boolean isOperator(String str) {
		str.trim();
		return str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*");
	}
	
	public static void main(String[] args) {
		String str[] = {"2", "1", "=", "3", "*"};
		System.out.println(evalRPN(str));
	}
}
