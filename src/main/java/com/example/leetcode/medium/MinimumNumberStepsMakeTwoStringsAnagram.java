package com.example.leetcode.medium;

/**
 * Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
 *
 * Return the minimum number of steps to make t an anagram of s.
 *
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 * Example 2:
 *
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 * Example 3:
 *
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * Explanation: "anagram" and "mangaar" are anagrams.
 * Example 4:
 *
 * Input: s = "xxyyzz", t = "xxyyzz"
 * Output: 0
 * Example 5:
 *
 * Input: s = "friend", t = "family"
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 50000
 * s.length == t.length
 * s and t contain lower-case English letters only.
 */
public class MinimumNumberStepsMakeTwoStringsAnagram {
    public static void main(String[] args) {
        String s = "friend";
        String t = "family";
        MinimumNumberStepsMakeTwoStringsAnagram minimumNumberStepsMakeTwoStringsAnagram = new MinimumNumberStepsMakeTwoStringsAnagram();
        minimumNumberStepsMakeTwoStringsAnagram.minSteps(s,t);
    }

    public int minSteps(String s, String t) {
        int res = 0;
        int[] count = new int[26];

        for (char c : s.toCharArray()){
            count[c-'a']++;
        }
        for (char c : t.toCharArray()){
            count[c-'a']--;
        }
        for (int value : count){
            if(value > 0)
                res += value;
        }
        return res;
    }
}
