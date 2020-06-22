package com.example.leetcode.challenge.may.week3;

/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * Example 2:
 *
 * Input: matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 */
public class CountSquareSubmatriceswithAllOnes {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };
        CountSquareSubmatriceswithAllOnes countSquareSubmatriceswithAllOnes = new CountSquareSubmatriceswithAllOnes();
        countSquareSubmatriceswithAllOnes.countSquaresV2(matrix);
    }

    public int countSquares(int[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1){
                    int min = Math.min(matrix.length - i,matrix[0].length - j);
                    result++;
                    for (int k = 1; k < min ; k++) {
                        boolean isSquare = true;
                        for (int l = 0; l <= k && isSquare; l++) {
                            for (int m = 0; m <= k && isSquare; m++) {
                                if(matrix[i+l][j+m] == 0)
                                    isSquare = false;
                            }

                        }
                        if(isSquare) {
                            result++;
                        }
                    }
                }
            }
        }

        return result;
    }


    /**
     * faster solution
     * @param matrix
     * @return
     */
    public int countSquaresV2(int[][] matrix) {
        if(matrix.length==0)
            return 0;

        int r = matrix.length;
        int c = matrix[0].length;

        int[][] dp = new int[r][c];
        int sum=0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==1){
                    if(i==0 || j==0)
                        dp[i][j] =1;

                    else
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;

                    sum+=dp[i][j];
                }
            }
        }

        return sum;
    }
}
