package com.rishi.arrays;

/**
 * Given two arrays gas = [1, 2] and cost = [2, 1] need to find if circuit is possible
 * based on the gas and its cost available. If yes return the start point else return -1
 * 
 * Again based on greedy algorithm
 * https://discuss.leetcode.com/topic/39755/proof-of-if-total-gas-is-greater-than-total-cost-there-is-a-solution-c/2
 * 
 * Link for details
 * 
 * Still need time to understand it
 * @author rishi
 *
 */
public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0;
		int end = gas.length - 1;
		int sum = gas[end] - cost[end];
		while (start < end) {
			if (sum >= 0) {
				sum += gas[start] - cost[start];
				start++;
			} else {
				end--;
				sum += gas[end] - cost[end];
			}
		}
		return sum >= 0 ? end : -1;
	}
	
	public static void main(String[] args) {
		GasStation obj = new GasStation();
		int gas[] = {1, 2, 0, 3, 5};
		int cost[] = {2, 0, 4, 1, 2};
		
		System.out.println(obj.canCompleteCircuit(gas, cost));
	}
}
