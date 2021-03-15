package chapter2.topic1;

/**
 * @author donald
 * @date 2021/03/15
 *
 * LeetCode 231. Power of Two
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 *
 *
 * ```
 * Example 1:
 *
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 *
 *
 * Example 2:
 *
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 *
 *
 * Example 3:
 *
 * Input: n = 3
 * Output: false
 *
 *
 * Example 4:
 *
 * Input: n = 4
 * Output: true
 *
 *
 * Example 5:
 *
 * Input: n = 5
 * Output: false
 * ```
 *
 * Constraints: -231 <= n <= 231 - 1
 *
 * 题意： 这个题目说的是，给你一个整数 n，你要写一个函数来判断它是否为 2 的幂。
 *
 * 思路：
 * 1. 暴力法：不断除 2，看是不是最后为 1
 * 2. 位操作
 */
public class LeetCode_231 {

    // Time: O(log(n)), Space: O(1), Faster: 100.00%
    public boolean isPowerOfTwoBruteForce(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0)
            n /= 2;
        return n == 1;
    }

    // Time: O(1), Space: O(1), Faster: 100.00%
    public boolean isPowerOfTwoBit(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
