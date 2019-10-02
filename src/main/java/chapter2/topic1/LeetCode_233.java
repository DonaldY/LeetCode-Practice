package chapter2.topic1;

/**
 * 233. Number of Digit One
 *
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 *
 * Example:
 *
 * Input: 13
 * Output: 6
 * Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 *
 * 题意：在[1, n], 位数上 1 出现的次数
 *
 * 思路：
 * 1. 每一个数字计算一遍 o(n * log10(n))
 * 2. 按位求数量
 *    abcde
 *    ab 为 high， de 为 low
 *    factor: 1/10/100 ...
 *    c == 0 => high * factor
 *    c == 1 => high * factor + low + 1
 *    else => (high + 1) * factor
 *
 */
public class LeetCode_233 {

    // Time: O(n * log10(n)), Space: O(1), Faster: Time Limit Exceeded
    public int countDigitOne(int n) {
        if (n <= 0) return 0;

        int result = 0;

        for (int i = 1; i <= n; ++i) {

            int cnt = countDigit(i);
            result += cnt;
        }

        return result;
    }

    private int countDigit(int n) {

        int cnt = 0;

        while (n != 0) {
            if (n % 10 == 1) ++cnt;
            n /= 10;
        }

        return cnt;
    }

    // Time: O(log10(n)), Space: O(1), Faster: 100.00%
    public int countDigitOneMath(int n) {
        if (n < 1) return 0;
        long count = 0, factor = 1;
        while (n / factor != 0) {
            long digit = (n / factor) % 10;
            long high = n / (10 * factor);
            if (digit == 0) {
                count += high * factor;
            } else if (digit == 1) {
                count += high * factor;
                count += (n % factor) + 1;
            } else {
                count += (high + 1) * factor;
            }
            factor = factor * 10;
        }
        return (int)count;
    }
}
