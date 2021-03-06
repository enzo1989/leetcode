package com.example.leetcode.medium;

/**
 * Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot, and two sightseeing spots i and j have distance j - i between them.
 *
 * The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) : the sum of the values of the sightseeing spots, minus the distance between them.
 *
 * Return the maximum score of a pair of sightseeing spots.
 *
 *
 *
 * Example 1:
 *
 * Input: [8,1,5,2,6]
 * Output: 11
 * Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 *
 * Note:
 *
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 */
public class BestSightseeingPair {
    public static void main(String[] args) {

    }

    public int maxScoreSightseeingPair(int[] A) {
        int length = A.length;
        int max = 0;
        int ret = 0;

        for (int i = 0; i < length ; i++) {
            ret = Math.max(ret, max + A[i] - i);
            max = Math.max(max, i + A[i]);
        }
        return ret;
    }


    /**
     * faster solution
     * @param A
     * @return
     */
    public int maxScoreSightseeingPairV1(int[] A) {
        if (A.length == 0)
            return 0;
        int max = A[0];
        int left = A[0];
        for (int i = 1; i < A.length; i++) {
            left--;
            int temp = left + A[i];
            if (temp > max) {
                max = temp;
            }
            if (left < A[i]) {
                left = A[i];
            }
        }
        return max;
    }
}
