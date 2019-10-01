package chapter3.topic3;

/**
 * 509. Fibonacci Number
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 *
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * 题意： 求第n个斐波那契数
 *
 * 思路：
 * 1. 递归求解
 * 2. 数组保存中间值
 * 3. 用两个数来保存前两个节点
 */
public class LeetCode_509 {

    // Time: O(2 ^ n), Space: O(n), Faster: 26.11%
    public int fib(int N) {

        if (N == 0) return 0;
        if (N == 1) return 1;

        return fib(N - 1) + fib(N - 2);
    }

    // Time: O(n), Space:O(n), Faster: 100.00%
    public int fibWithArray(int N) {

        if (N < 0) return -1;

        if (N == 0) return 0;
        if (N == 1) return 1;

        int [] arr = new int[N + 1];
        arr[0] = 0; arr[1] = 1;

        for (int i = 2; i <= N; ++i) arr[i] = arr[i - 1] + arr[i - 2];

        return arr[N];
    }
}
