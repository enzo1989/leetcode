package com.example.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 */
public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        FindAllDuplicatesInArray findAllDuplicatesInArray = new FindAllDuplicatesInArray();
        List<Integer> res = findAllDuplicatesInArray.findDuplicates(nums);
        System.out.println(res);
    }

    /**
     * https://www.cnblogs.com/grandyang/p/6209746.html
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0)
                res.add(idx + 1);
            nums[idx] = - nums[idx];
        }
        return res;
    }
}
