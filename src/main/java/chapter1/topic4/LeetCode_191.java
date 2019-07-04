package chapter1.topic4;

/**
 * 191. Number of 1 Bits
 *
 * Example 1:
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 *
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 *
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 * 题意： 一个数字转换为二进制，有多少个1
 *
 * 思路：
 * 1. 按位与，直至超出，即32次
 * 2. 计数器法
 *
 *    1100
 *    1011
 * 就为
 *    1000
 */
public class LeetCode_191 {

    public int hammingWeight(int n) {

        return 0;
    }

    // Time: o(m), Space: o(1), Faster: 24.17%
    public int numberOfOneWithMask(int n) {
        int mask = 1, count = 0;
        while (mask != 0) {
            if ((n & mask) != 0) ++count;
            mask <<= 1;
        }
        return count;
    }

    // Time: o(k), Space: o(1), Faster:100.00%
    public int numberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n &= (n - 1);
        }
        return count;
    }
}
