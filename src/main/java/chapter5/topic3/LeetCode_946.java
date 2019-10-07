package chapter5.topic3;

import java.util.Stack;

/**
 * 946. Validate Stack Sequences
 *
 * Given two sequences pushed and popped with distinct values,
 * return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.
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
 *
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
 *
 * 题意： 题意以一定入栈顺序校验出栈顺序是否正确
 *
 * 思路：
 * 1. 模拟
 *
 */
public class LeetCode_946 {

    // 空间复杂度为 2n，计算下就可以了。
    // Time: O(n), Space: O(n), Faster: 51.30%
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed == null || popped == null) return false;

        if (pushed.length != popped.length) return false;

        int index = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < pushed.length; ++i) {

            stack.push(pushed[i]);

            while (!stack.isEmpty() && stack.peek() == popped[index]) {

                stack.pop();
                ++index;
            }
        }

        return stack.isEmpty();

    }

    // Time: O(n), Space: O(n), Faster: 98.43%
    public boolean validateStackSequencesArray(int[] pushed, int[] popped) {
        if (pushed == null || popped == null
                || pushed.length != popped.length)
            return false;

        int[] stack = new int[pushed.length];

        int p = 0, top = -1;

        for (int num: pushed) {
            stack[++top] = num;
            while (top != -1 && stack[top] == popped[p]) {
                --top;
                ++p;
            }
        }
        return top == -1;
    }
}
