package chapter1.topic1;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 *
 * 题意：计算某一个数的次方
 *
 * 思路：
 * 1. 调API
 * 2. 手动计算，循环相乘
 * 3. 位运算 x^11 = x^8 x^2 X^1
 *
 */
public class LeetCode_50 {

    public static void main(String[] args) {

        LeetCode_50 leetCode = new LeetCode_50();
        System.out.println(leetCode.myPow(2, 10));
        System.out.println(leetCode.myPow(2.1, 3));
        System.out.println(leetCode.myPow(2, -2));
        System.out.println(leetCode.myPow(2, 0));
    }

    // Time: o(n) Space: o(1) faster:100%
    public double myPow(double x, int n) {

        return Math.pow(x, n);
    }

    // Time: O(n), Space: O(1)
    public double pow(double x, int n) {
        double result = 1;
        long N = Math.abs((long)n);

        for (int i = 0; i < N; ++i)
            result *= x;
        return n < 0 ? 1/result : result;
    }

    // Time: O(log(n)), Space: O(1)
    public double powFast(double x, int n) {
        double result = 1;
        long N = Math.abs((long)n);

        while (N != 0) {
            if ((N & 1) == 1) result *= x;
            x *= x;
            N >>= 1;
        }
        return n < 0 ? 1/result : result;
    }
}
