package chapter2.topic1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author donald
 * @date 2020/6/10
 *
 * 202. Happy Number
 *
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 题意：
 * 给你一个整数 n，你要实现一个算法来判断它是否为快乐数。
 *
 * 快乐数的定义是：从任意正整数开始，将它变换为十进制位上各个数字的平方和。不断重复这个变换过程，如果最后数字可以变换成 1，那么这个数字就是快乐数；
 * 否则它会在一系列不包含 1 的数字之间循环变换，这样的数字不是快乐数。
 *
 * 反向思考：出口是什么， 出现重复的数。
 *
 * 思路：
 * 1. 暴力算法，每次都求和。
 *    用一个hashset保存结果
 *
 */
public class LeetCode_202 {

    // Time: O(n), Space: O(n), Faster: 17.45%
    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)) {

            set.add(n);

            int tmp = n, result = 0;

            while (tmp != 0) {

                int tmp2 = tmp % 10;
                tmp /= 10;
                result += tmp2 * tmp2;
            }

            if (result == 1) return true;

            n = result;
        }

        return false;
    }
}
