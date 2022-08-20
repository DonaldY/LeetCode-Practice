package chapter1.topic4;

/**
 * @author donald
 * @date 2022/08/20
 *
 * 这个题目说的是，给你一个 32 位整数，你要翻转它的二进制位，然后将翻转二进制位后的整数返回。
 *
 * 比如说，给你的整数是 32，它的二进制如下：
 *
 * 00000000000000000000000000100000
 *
 * 将 32 的二进制表示左右翻转，得到：
 *
 * 00000100000000000000000000000000
 *
 * 这个二进制表示的数字是 67108864，因此你要返回这个整数。
 *
 *
 *
 */
public class LeetCode_190 {

    // Time: O(1), Space: O(1), Faster: 100.00%
    public int reverseBitsOneByOne(int n) {
        int result = 0;
        // int 有 32位
        for (int i = 0; i < 32; ++i) {
            // 结果先向左移一位
            // n & 1：表示最后一位
            // 最后 | 或， 有 1 则1
            result = (result << 1) | (n & 1);
            n >>= 1;
        }
        return result;
    }

    /**
     * 如果我们要翻转一个 32 位整数的二进制位，那么我们可以先以连续的16个二进制位为一组，然后交换相邻的两组二进制位。
     * 接着以连续的 8个二进制位为一组，同样再以 4 个二进制位为一组， 2个二进制位为一组，1个二进制位为一组，
     * 并和相邻的组进行交换。我们就可以得到翻转二进制位后的整数。
     */
    // Time: O(1), Space: O(1), Faster: 100.00%
    public int reverseBitsInterchanging(int n) {
        n = (n & 0x0000FFFF) << 16 | (n & 0xFFFF0000) >>> 16;
        n = (n & 0x00FF00FF) << 8 | (n & 0xFF00FF00) >>> 8;
        n = (n & 0x0F0F0F0F) << 4 | (n & 0xF0F0F0F0) >>> 4;
        n = (n & 0x33333333) << 2 | (n & 0xCCCCCCCC) >>> 2;
        n = (n & 0x55555555) << 1 | (n & 0xAAAAAAAA) >>> 1;
        return n;
    }
}
