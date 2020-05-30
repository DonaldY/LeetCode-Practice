package chapter4.topic1;

import java.util.HashSet;
import java.util.Set;

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
 *
 * 2. 平方和定理：
 *    对于一个大于 1 的整数，当且仅当它的质因数分解中，所有形入 4k + 3
 *    的质因数都是偶数次幂，它才可以表示成两个完全平方数的和。
 */
public class LeetCode_633 {

    // Time: O(c ^ 1/2), Space: O(c ^ 1/2)
    public boolean judgeSquareSumHashSet(int c) {
        int x = (int) Math.sqrt(c);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= x; ++i) {
            set.add(i * i);
            if (set.contains(c - i*i))
                return true;
        }
        return false;
    }

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

    // Time: O(c ^ 1/2), Space: O(1), Faster: 97.09%
    public boolean judgeSquareSumMath(int c) {
        for (int i = 2; i*i <= c; ++i) {
            int cnt = 0;
            while (c % i == 0) {
                ++cnt;
                c /= i;
            }
            if (i % 4 == 3 && (cnt & 1) == 1) return false;
        }
        return c % 4 != 3;
    }
}
