package com.example.leetcode.challenge.test2020.August.week2;

/**
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 * Note:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */
public class RottingOranges {
    public static void main(String[] args) {

    }
    public int orangesRotting(int[][] grid) {
        int res = 0;
        int[][] gridTemp;
        int u = grid.length;
        int v = grid[0].length;
        boolean isRotten;

        do {
            isRotten = false;
            for (int i = 0; i < u; i++) {
                for (int j = 0; j < v; j++) {
                    if(grid[i][j] == 1){
                        if((i>0 && grid[i-1][j] == 2) || (i<u-1 && grid[i+1][j] == 2) || (j>0 && grid[i][j-1] == 2) || (j<v-1 && grid[i][j+1] == 2)){
                            grid[i][j] = 3;
                            isRotten = true;
                        }
                    }
                }
            }
            for (int i = 0; i < u; i++) {
                for (int j = 0; j < v; j++) {
                    if(grid[i][j] == 3){
                        grid[i][j] = 2;
                    }
                }
            }
            res++;
        }while (isRotten);
        for (int i = 0; i < u; i++) {
            for (int j = 0; j < v; j++) {
                if(grid[i][j] == 1){
                    return 0;
                }
            }
        }
        return res>0?res-1:res;
    }

}
