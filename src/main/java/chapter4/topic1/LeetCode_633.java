package chapter4.topic1;

/**
 * @author donald
 * @date 2020/5/30
 *
 * 633. Sum of Square Numbers
 *
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 *
 * Example 1:
 *
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 *
 *
 * Example 2:
 *
 * Input: 3
 * Output: False
 *
 * 题意：
 * 两个数的平方后相加，是否等于给定的数
 *
 *
 * 思路：
 * 1. 从 1 ～ 根号c，查找对比
 */
public class LeetCode_633 {

    // Time: O(根号 c), Space: O(1), Faster: 45.45%
    public boolean judgeSquareSum(int c) {

        int p = 0, q = (int) Math.sqrt(c);

        while (p <= q) {

            int sum = p * p + q * q;

            if (c == sum) return true;
            else if (c > sum) ++p;
            else --q;
        }

        return false;
    }
}
