package com.example.leetcode.medium;


import java.util.Stack;

/**
 * Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.
 *
 *
 *
 * Example 1:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * Example 2:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 *
 *
 * Note:
 *
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed is a permutation of popped.
 * pushed and popped have distinct values.
 */
public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,3,5,1,2};
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        boolean result = validateStackSequences.validateStackSequences(pushed,popped);
        System.out.println(result);

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int indexOfPushed = 0;
        int indexOfPoped = 0;
        while (indexOfPushed<pushed.length){
            stack.push(pushed[indexOfPushed]);
            indexOfPushed++;
            while (!stack.empty() && stack.peek() == popped[indexOfPoped]){
                stack.pop();
                indexOfPoped++;
            }
        }
        return stack.empty();
    }


    /**
     * faster solution
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequencesV2(int[] pushed, int[] popped) {
        if (pushed.length < 3) {
            return true;
        }
        int i = 0, j = 0;
        for (int newElement : pushed) {
            pushed[i++] = newElement;
            while (i > 0 && pushed[i - 1] == popped[j]) {
                i--;
                j++;
            }
        }
        return i == 0;
    }

}
