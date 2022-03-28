package chapter4.topic2;

/**
 * @author donald
 * @date 2022/03/28
 *
 * 693. 交替位二进制数
 *
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 *
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 *
 * 示例 3：
 *
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 *
 * 题意： 是否交替出现
 *
 * 思路：
 * 判断位运算
 */
public class LeetCode_693 {

    // Faster: 100.00%
    public boolean hasAlternatingBits(int n) {

        int p = (n & 1) == 0 ? 0 : 1;
        for (int i = 1; i < 32; ++i) {

            long now = 1 << i;
            if (now > n) break;

            int tmp = (n & (1 << i)) != 0 ? 1 : 0;
            if (tmp == p) return false;
            p = tmp;
        }
        return true;
    }
}
