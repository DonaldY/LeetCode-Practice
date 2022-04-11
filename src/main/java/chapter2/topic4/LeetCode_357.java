package chapter2.topic4;

/**
 * @author donald
 * @date 2022/04/11
 *
 * 357. 统计各位数字都不同的数字个数
 *
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：91
 * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：1
 *
 * 题意： 求数
 *
 * 思路：
 * 1. 遍历每一位
 */
public class LeetCode_357 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public int countNumbersWithUniqueDigits(int n) {

        if (0 == n) return 1;

        int ans = 10; // 1位时
        for (int i = 2, num = 9; i <= n; ++i) {

            int cur = num * (10 - i + 1);
            ans += cur;
            num = cur;
        }

        return ans;
    }
}
