package com.example.leetcode.challenge.test2020.november.week1;


/**
 * Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
 *
 * Return the power of the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 * Example 2:
 *
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 * Example 3:
 *
 * Input: s = "triplepillooooow"
 * Output: 5
 * Example 4:
 *
 * Input: s = "hooraaaaaaaaaaay"
 * Output: 11
 * Example 5:
 *
 * Input: s = "tourist"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s contains only lowercase English letters.
 */
public class ConsecutiveCharacters {
    public static void main(String[] args) {

    }

    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        char cur = chars[0];
        int res = 0;
        int count = 1;
        for (int i = 1; i < length; i++) {
            if(chars[i] != cur){
                res = Math.max(res,count);
                cur = chars[i];
                count = 1;
            } else {
                count++;
            }
        }
        res = Math.max(res,count);
        return res;
    }
}
