package com.example.leetcode.challenge.test2020.november.week3;


/**
 * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
 *
 * B.length >= 3
 * There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * (Note that B could be any subarray of A, including the entire array A.)
 *
 * Given an array A of integers, return the length of the longest mountain.
 *
 * Return 0 if there is no mountain.
 *
 * Example 1:
 *
 * Input: [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 * Example 2:
 *
 * Input: [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 * Note:
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * Follow up:
 *
 * Can you solve it using only one pass?
 * Can you solve it in O(1) space?
 * [0,1,2,3,4,5,4,3,2,1,0]
 * [9,8,7,6,5,4,3,2,1,0]
 * [0,0,1,0,0,1,1,1,1,1]
 */
public class LongestMountainArray {
    public static void main(String[] args) {
        int[] A = new int[]{2,2,2};
        LongestMountainArray longestMountainArray = new LongestMountainArray();
        int res = longestMountainArray.longestMountain(A);
        System.out.println(res);
    }

    public int longestMountain(int[] A) {
        int length = A.length;
        if(length <= 2)
            return 0;

        int max = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 1; i < length; i++) {
            if(A[i] > A[i-1]){
                if(count2 != 0){
                    max = Math.max(max,count1 + count2 + 1);
                    count1 = 1;
                    count2 = 0;
                } else {
                    count1++;
                }
            } else if(A[i] < A[i-1]){
                if(count1 > 0)
                    count2++;
            } else {
                max = Math.max(max,count1 + count2);
                count1 = 0;
                count2 = 0;
            }
        }
        if(count2 != 0 && count1 != 0){
            max = Math.max(max,count1 + count2 + 1);
        }
        return max;
    }
}
