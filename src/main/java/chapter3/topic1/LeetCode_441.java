package chapter3.topic1;

/**
 * 441. Arranging Coins
 *
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。
 * 对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 *
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 *
 * 思路：
 * 1. 暴力法：一层一层相减
 * 2. 数学公式法1：等差数列(高斯求和)
 *    - 如果完整的行有 i 行, 对前i行求和, sum = (0 + i) × (i - 0 + 1) / 2 <= n
 *    - 然后逐个遍历即可
 *    - 要防止整型溢出, 使用long long
 * 3. 数学公式法2：一元二次方程，求得 root
 *    求和公式：n = x * (x + 1) / 2
 *    因 x >=0，解不等式：
 *    求根公式可得：x = ((sqrt(1 + 8 * n)) - 1) / 2
 */
public class LeetCode_441 {

    // 1. 暴力法
    // Time: o(n), Space: o(1), Faster: 17.84%
    public int arrangeCoins(int n) {
        if (n <= 0) return 0;
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            n -= i;
            if (n == 0) {
                return res + 1;
            } else if (n < 0) {
                return res;
            } else {
                ++res;
            }
        }
        return res;
    }

    // 2. 数学公式：等差数列
    // Time: o(n), Space: o(1), Faster: 17.84%
    public int arrangeCoins2(int n) {
        long i = 0;
        while ((long)(i * (i + 1)) < (long) (2 * n)) {
            ++i;
        }
        if ((long)(i * (i + 1)) == (long) (2 * n)) return (int)i;
        return (int)i - 1;
    }

    // 3. 数学公式：
    // Time: o(n), Space: o(1), Faster: 17.84%
    public int arrangeCoins3(int n) {
        return (int)((Math.sqrt(1 + 8 * n) - 1) / 2);
    }
}
