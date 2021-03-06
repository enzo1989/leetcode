package com.example.leetcode.challenge.test2020.may.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.
 * For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 *
 *
 * Note:
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 */
public class IntervalListIntersections {
    public static void main(String[] args) {
        int[][] A = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] B = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        IntervalListIntersections intervalListIntersections = new IntervalListIntersections();
        int[][] result = intervalListIntersections.intervalIntersection(A,B);
        System.out.println(result);
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int lengthA =  A.length;
        int lengthB =  B.length;
        int indexA = 0;
        int indexB = 0;
        List<int[]> list = new ArrayList<>();
        while(indexA < lengthA && indexB < lengthB){
            int left = Math.max(A[indexA][0] , B[indexB][0]);
            int right = Math.min(A[indexA][1] , B[indexB][1]);
            if(right >= left)
                list.add(new int[]{left,right});

            if(A[indexA][1] < B[indexB][1]){
                indexA++;
            } else if(A[indexA][1] > B[indexB][1]){
                indexB++;
            } else {
                indexA++;
                indexB++;
            }

        }
        return list.toArray(new int[list.size()][2]);
    }
}
