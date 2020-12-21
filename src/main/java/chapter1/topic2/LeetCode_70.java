package chapter1.topic2;

/**
 * 70. Climbing Stairs
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * 题意：有 1， 2 步数，有多少种不同走法
 *
 * 思路：
 * 1. 非伯纳且，第n项
 * 2. 排列组合
 *    (C n 0) ~ (C n n/2)
 *    可以容纳多少个2, 逐个减少1
 */
public class LeetCode_70 {

    public int climbStairs(int n) {

        int num1 = n, num2 = 0;

        // 可以容纳多少个2
        int pair = n / 2;

        int cnt = 0;

        for (int i = 0; i <= pair; ++i) {}

        return cnt;
    }

    // 超时
    public int climbstairsRecursive(int n) {

        if (n < 2) return 1;
        return climbstairsRecursive(n - 1) + climbstairsRecursive(n - 2);
    }

    // Space: o(1) Time: o(n) Faster: 100%
    public int climbstairsIterative(int n) {

        int first = 1, second = 1;

        for (int i = 1; i < n; ++i) {

            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}
