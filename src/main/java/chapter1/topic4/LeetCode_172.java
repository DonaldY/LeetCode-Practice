package chapter1.topic4;

/**
 * @author donald
 * @date 2020/6/9
 *
 * 172. Factorial Trailing Zeroes
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 *
 * 题意：
 * 给你一个整数 n，你要计算 n! 的结果末尾有多少个 0。
 *
 * 思路：
 * 1. 先求出整数，再求得0的个数
 *
 * 2. 取决于5的个数
 *
 */
public class LeetCode_172 {

    // Time: O(log(n)), Space: O(1), Faster: 21.13%
    public int trailingZeroes(int n) {

        int cnt = 0;

        while (n > 0) {

            n /= 5;
            cnt += n;
        }

        return cnt;
    }
}
