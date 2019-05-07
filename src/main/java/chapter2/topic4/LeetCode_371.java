package chapter2.topic4;

/**
 * 371. Sum of Two Integers
 *
 * Input: a = 1, b = 2
 * Output: 3
 *
 * Input: a = -2, b = 3
 * Output: 1
 *
 * 题意：不是使用 + - 完成计算
 *
 * 思路：
 * 1. 转换为原始的，进行位运算
 *
 * 方法：
 * 1. 递归
 * 2.
 */
public class LeetCode_371 {

    public int getSum(int a, int b) {

        return getSumRecursive(a, b);
    }

    // Time : o(m) Space: o(1) faster: 100%
    private int getSumRecursive(int a, int b) {

        return b == 0 ? a : getSumRecursive(a ^ b, (a & b) << 1 );
    }

    // Time : o(m) Space: o(1) faster: 100%
    private int getSumIterative(int a, int b) {

        while (b != 0) {

            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
