package com.rishi.arrays;

/**
 * Problem could be understood from https://leetcode.com/problems/teemo-attacking/#/description
 * 
 * Idea is to:
 * 1. Have pointers start and end, initially start = [0] and end = [0] + duration
 * 2. In case the end is greater than the current number, we keep the start same and update the 
 * end with current + duration.
 * 3. In case current is greater than end we update the start as well with current.
 * 4. Once all the elements are done, we subtract start from end (end - start)
 * @author rishi
 *
 */
public class TeemoAttacking {

	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if (timeSeries == null || timeSeries.length == 0 || duration == 0) {
			return 0;
		}

		int result = 0, start = timeSeries[0], end = timeSeries[0] + duration;

		for (int i = 1; i < timeSeries.length; i++) {
			if (timeSeries[i] > end) {
				result += end - start;
				start = timeSeries[i];
			}
			end = timeSeries[i] + duration;
		}

		result += end - start;
		return result;
	}

	public static void main(String[] args) {
		TeemoAttacking obj = new TeemoAttacking();
		// int[] timeSeries = {1, 2};
		int[] timeSeries = { 1, 2, 3, 4, 5 };
		int dur = 5;

		System.out.println("Result " + obj.findPoisonedDuration(timeSeries, dur));

	}
}
