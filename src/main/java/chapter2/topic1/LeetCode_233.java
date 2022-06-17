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
 * 1. 暴力法：每一个数字计算一遍 o(n * log10(n))
 * 2. 按位求数量
 *    abcde
 *    ab 为 high， de 为 low
 *    factor: 1/10/100 ...
 *    c == 0 => high * factor
 *    c == 1 => high * factor + low + 1
 *    else => (high + 1) * factor
 *
 * 3. 方法三：找规律
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
        return (int) count;
    }

    // 方法三： 找规律
    public int countDigitOne3(int n) {
        return f(n);
    }

    // 先求高位，在求低位
    private int f(int n) {
        // 上一级递归 n = 20、10之类的整十整百之类的情况；以及n=0的情况
        if (n == 0) return 0;
        // n < 10 即为个位，这样子只有一个1
        if (n < 10) return 1;

        String s = String.valueOf(n);
        //长度：按例子来说是4位
        int length = s.length();

        // 这个base是解题速度100%的关键，本例中的是999中1的个数：300
        // 99的话就是20 ; 9的话就是1 ; 9999就是4000 这里大家应该发现规律了吧。
        int base = (length - 1) * (int) Math.pow(10, length - 2);

        // high就是最高位的数字
        int high = s.charAt(0) - '0';
        // cur就是当前所数量级，即1000
        int cur = (int) Math.pow(10, length - 1);
        if (high == 1) {

            // 最高位为1，1+n-cur就是1000~1234中由千位数提供的1的个数，
            // 剩下的f函数就是求1000~1234中由234产生的1的个数
            return base + 1 + n - cur + f(n - high * cur);
        } else {
            // high：代表有多少个
            // base：计算(999) 的多少个 × 总共有几个
            return base * high + cur + f(n - high * cur);
        }
    }
}
