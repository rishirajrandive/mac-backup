package com.rishi.patterns.bridge;

/**
 * Handle/Body relationship. 
 * @author rishi
 *
 */
public class BrideDemo {

	public static void main(String[] args) {
		Stack[] stacks = { new Stack("java"), new Stack("mine"), new StackHanoi("java"), new StackHanoi("mine") };
		int[] arr = {2, 16, 23, 0, 4, 5, 36, 11, 2, 7, 1, 5, 1, 25, 27, 34, 37, 0, 39, 5};
		for (int i = 0, num; i < 20; i++) {
			num = arr[i];
			for (Stack stack : stacks) {
				stack.push(num);
			}
		}
		for (int i = 0, num; i < stacks.length; i++) {
			while (!stacks[i].isEmpty()) {
				System.out.print(stacks[i].pop() + "  ");
			}
			System.out.println();
		}
		System.out.println("total rejected is " + ((StackHanoi) stacks[3]).reportRejected());
	}
}
