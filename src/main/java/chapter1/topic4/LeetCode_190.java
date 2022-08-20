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
}
