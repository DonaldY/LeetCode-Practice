package chapter2.topic2;

/**
 * 263. Ugly Number
 *
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example 1:
 *
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 *
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 *
 * 题意： 一个数只能被 2 或 3 或 5 整除
 *
 * 思路：
 * 1. 一个数质因分解， 看这个数中是否有除 2 3 5之外的数
 * 2. 是否为 2, 3, 5的倍数，或两个组合的倍数，或2 3 5的倍数
 */
public class LeetCode_263 {

    // Time: o(m + n +1) , Space: o(1), Faster: 99.72%
    public boolean isUgly(int num) {

        if (num <= 0) return false;
        while(num % 2 == 0) num /= 2;
        while(num % 3 == 0) num /= 3;
        while(num % 5 == 0) num /= 5;
        return num == 1;
    }
}
