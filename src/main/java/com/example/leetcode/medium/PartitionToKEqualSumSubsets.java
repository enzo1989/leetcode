package com.example.leetcode.medium;

import java.util.Arrays;

/**
 * Given an array of integers nums and a positive integer k,
 * find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 *
 *
 * Note:
 *
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */
public class PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        PartitionToKEqualSumSubsets partitionToKEqualSumSubsets = new PartitionToKEqualSumSubsets();
        boolean result = partitionToKEqualSumSubsets.canPartitionKSubsets(nums,k);
        System.out.println(result);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean result = false;
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0){
            return false;
        }

        return result;
    }
}
