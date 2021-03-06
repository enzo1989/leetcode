package com.example.leetcode.challenge.test2020.april.week4;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * If there is no common subsequence, return 0.
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "def";
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();

        int result = longestCommonSubsequence.longestCommonSubsequence(text1,text2);
        System.out.println(result);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                int isLastEqual = text1.charAt(i - 1) == text2.charAt(j - 1) ? 1 : 0;
                f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + isLastEqual);
            }
        }
        return f[m][n];
    }

    /**
     * faster solution
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequenceV2(String text1, String text2) {
        char[] t1 = text1.toCharArray(), t2 = text2.toCharArray();
        int dp[] = new int[t2.length+1];
        for(int i = 1; i <= t1.length; i++) {
            int prev = 0;
            for(int j = 1; j <= t2.length; j++) {
                int tmp = dp[j];
                if(t1[i-1] == t2[j-1])
                    dp[j] = prev + 1;
                else
                    dp[j] = Math.max(dp[j], dp[j-1]);
                prev = tmp;
            }
        }
        return dp[t2.length];
    }
}
