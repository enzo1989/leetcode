package com.example.leetcode.challenge.test2020.september.week2;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
        };
        int[] newInterval = new int[]{2,5};
        InsertInterval insertInterval = new InsertInterval();
        insertInterval.insert(intervals,newInterval);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> list = new ArrayList<>();
        int length = intervals.length;
        boolean newAdded = false;
        for (int i = 0; i < length; i++) {
            if(intervals[i][1] < newInterval[0]){
                list.add(new Interval(intervals[i][0],intervals[i][1]));
            } else if( intervals[i][0] > newInterval[1]){
                if(!newAdded){
                    list.add(new Interval(newInterval[0],newInterval[1]));
                    newAdded = true;
                }
                list.add(new Interval(intervals[i][0],intervals[i][1]));
            } else{
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            }
        }
        if(!newAdded){
            list.add(new Interval(newInterval[0],newInterval[1]));
        }
        int[][] res = new int[list.size()][2];
        int index = 0;
        for (Interval interval : list){
            res[index][0] = interval.start;
            res[index][1] = interval.end;
            index++;
        }
        return res;
    }

    public class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
