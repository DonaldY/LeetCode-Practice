package chapter2.topic2;

/**
 * @author donald
 * @date 2020/5/1
 *
 * 279. Perfect Squares
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 *
 *
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 * 题意：
 * 一个数可以分解为多少个完全平方数的和
 *
 * 思路：
 * 1. i 表示这个数， d[i] 表示表达这个数需要几个
 *
 * 2. 拉格朗日四平方和定理：
 *    每个正整数都可以表示为4个整数的平方和。
 *    即： n = a^2 + b^2 + c^2 + d^2
 *
 *    勒让德三平方和定理：
 *    在满足一个前提条件的情况下，每个正整数都可以表示为3个整数的平方和。
 *    这个前提条件是，正整数 n 不可以表示为 4^a * (8b + 7) 这个形式。
 *    其中， a 和 b 都为整数
 *
 */
public class LeetCode_279 {

    // Time: O(n ^ 3/2), Space: O(n), Faster: 69.37%
    public int numSquaresDP(int n) {
        int[] d = new int[n+1];
        d[0] = 0;
        for (int i = 1; i <= n; ++i) {
            d[i] = i;
            for (int j = 1; j * j <= i; ++j)
                d[i] = Math.min(d[i], d[i - j*j] + 1);
        }
        return d[n];
    }

    // Time: O(n ^ 1/2), Space: O(1), Faster: 99.91%
    public int numSquaresMath(int n) {
        if (isSquare(n)) return 1;
        for (int i = 1; i * i <= n; ++i)
            if (isSquare(n - i*i))
                return 2;
        while (n % 4 == 0) n /= 4;
        if (n % 8 != 7) return 3;
        return 4;
    }

    // Math.sqrt 时间复杂度是 O(1)
    // 参考链接：https://stackoverflow.com/questions/35524072/worst-case-time-complexity-of-math-sqrt-in-java
    private boolean isSquare(int n) {
        int a = (int) Math.sqrt(n);
        return a * a == n;
    }
}
