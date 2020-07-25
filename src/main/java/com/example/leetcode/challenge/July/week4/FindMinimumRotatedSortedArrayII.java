package com.example.leetcode.challenge.July.week4;

import java.lang.reflect.Array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 *
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 *
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 * [3,3,1,3]
 */
public class FindMinimumRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = new int[]{3,3,1,3};
        FindMinimumRotatedSortedArrayII findMinimumRotatedSortedArrayII  = new FindMinimumRotatedSortedArrayII();
        int res = findMinimumRotatedSortedArrayII.findMin(nums);
        System.out.println(res);
    }

    public int findMin(int[] nums) {
        int left = 0, right =  nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else if (nums[mid] < nums[right])
                right = mid;
            else
                --right;
        }
        return nums[right];
    }
}
