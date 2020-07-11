package com.example.leetcode.biweeklycontest.contest30;

import java.util.*;

/**
 * 5445. Range Sum of Sorted Subarray Sums
 * User Accepted:265
 * User Tried:284
 * Total Accepted:265
 * Total Submissions:302
 * Difficulty:Medium
 * Given the array nums consisting of n positive integers. You computed the sum of all non-empty continous subarrays from the array and then sort them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.
 *
 * Return the sum of the numbers from index left to index right (indexed from 1), inclusive,
 * in the new array. Since the answer can be a huge number return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4], n = 4, left = 1, right = 5
 * Output: 13
 * Explanation: All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4.
 * After sorting them in non-decreasing order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10].
 * The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13.
 * Example 2:
 *
 * Input: nums = [1,2,3,4], n = 4, left = 3, right = 4
 * Output: 6
 * Explanation: The given array is the same as example 1.
 * We have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10].
 * The sum of the numbers from index le = 3 to ri = 4 is 3 + 3 = 6.
 * Example 3:
 *
 * Input: nums = [1,2,3,4], n = 4, left = 1, right = 10
 * Output: 50
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^3
 * nums.length == n
 * 1 <= nums[i] <= 100
 * 1 <= left <= right <= n * (n + 1) / 2
 */
public class RangeSumSortedSubarraySums {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int n = 4;
        int left = 1;
        int right = 5;
        RangeSumSortedSubarraySums rangeSumSortedSubarraySums = new RangeSumSortedSubarraySums();
        rangeSumSortedSubarraySums.rangeSum(nums,n,left,right);
    }

    int modulo = 100000007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new LinkedList<>();
        int count;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = i; j < n; j++) {
                count += nums[j];
                list.add(count);
            }
        }
        int res = 0;
        int index = 1;
        Collections.sort(list);
        for (Integer val : list){
            if(index >= left){
                res += val;
                if(res > modulo)
                    res = res % modulo;
            }
            index++;
            if(index > right)
                break;
        }
        return res;
    }
}
