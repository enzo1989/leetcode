package com.example.leetcode.medium;

/**
 * You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.
 *
 * Return the number of servers that communicate with any other server.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: grid = [[1,0],[0,1]]
 * Output: 0
 * Explanation: No servers can communicate with others.
 * Example 2:
 *
 *
 *
 * Input: grid = [[1,0],[1,1]]
 * Output: 3
 * Explanation: All three servers can communicate with at least one other server.
 * Example 3:
 *
 *
 *
 * Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * Output: 4
 * Explanation: The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 *
 * [[1,0,0,1,0],[0,0,0,0,0],[0,0,0,1,0]]
 */
public class CountServersCommunicate {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,0,0,1,0},
                {0,0,0,0,0},
                {0,0,0,1,0}
        };
        CountServersCommunicate countServersCommunicate = new CountServersCommunicate();
        countServersCommunicate.countServers(grid);
    }


    public int countServers(int[][] grid) {
        int result = 0;
        int u = grid.length;
        int v = grid[0].length;
        int[] ulist = new int[u];
        int[] vlist = new int[v];
        for (int i = 0; i < u; i++) {
            for (int j = 0; j < v; j++) {
                if(grid[i][j] == 1){
                   ulist[i]++;
                   vlist[j]++;
                }
            }
        }
        for (int i = 0; i < u; i++) {
            for (int j = 0; j < v; j++) {
                if(grid[i][j] == 1){
                    if(ulist[i] > 1 || vlist[j] > 1)
                        result++;
                }
            }
        }
        return result;
    }

}
