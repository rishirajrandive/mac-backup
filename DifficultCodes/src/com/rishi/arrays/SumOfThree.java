package com.rishi.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Ex: [-1, 0, 1, 2, -1, -4] Two solutions - [-1, -1, 2] and [-1, 0, 1]
 * 
 * Possible requirement questions: 1. Is array sorted? 2. Should I consider both
 * +ve and -ve, of course integers means both.
 * 
 * Follow up questions: 1. Change it to give group of 4 or 5 or maybe 2. 2. Sum
 * could be changed to any other number other than 0. 3. Can ask for return
 * duplicates as well or only duplicates.
 * 
 * @author rishi
 *
 */
public class SumOfThree {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> sets;
		if (nums == null || nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);

		int left, right;

		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] > nums[i - 1]) {
				left = i + 1;
				right = nums.length - 1;

				while (left < right) {
					int sum = nums[i] + nums[left] + nums[right];
					if (sum == 0) {
						sets = new ArrayList<>();
						sets.add(nums[i]);
						sets.add(nums[left]);
						sets.add(nums[right]);
						result.add(sets);
						left++;
						right--;

						while (left < right && nums[right] == nums[right + 1]) {
							right--;
						}
						while (left < right && nums[left] == nums[left - 1]) {
							left++;
						}

					} else if (sum < 0) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		return result;
	}

	/**
	 * Changes:
	 * 1. What if there are two nos such that both are at equal distance from target (ruled out by saying
	 * 	it has only one solution)
	 * 2. Find the second closest
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return 0;
		}
		Arrays.sort(nums);
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int len = nums.length;
		for (int i = 0; i < len - 2; i++) {
			int low = i + 1;
			int high = len - 1;

			while (low < high) {
				int tempSum = nums[i] + nums[low] + nums[high];
				int diff = Math.abs(tempSum - target);
				if (diff < min) {
					sum = tempSum;
					min = diff;

				}
				if (tempSum < target) {
					low++;
				} else {
					high--;
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		SumOfThree obj = new SumOfThree();
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		// int[] nums = {0, 0, 0, 0};
		List<List<Integer>> res = obj.threeSum(nums);

		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.println("");
		}

	}
}
