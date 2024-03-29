package chapter7.topic3;

/**
 * @author donald
 * @date 2022/02/01
 *
 * 1342. 将数字变成 0 的操作次数
 *
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。
 * 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 *
 * 示例 1：
 * 输入：num = 14
 * 输出：6
 * 解释：
 * 步骤 1) 14 是偶数，除以 2 得到 7 。
 * 步骤 2） 7 是奇数，减 1 得到 6 。
 * 步骤 3） 6 是偶数，除以 2 得到 3 。
 * 步骤 4） 3 是奇数，减 1 得到 2 。
 * 步骤 5） 2 是偶数，除以 2 得到 1 。
 * 步骤 6） 1 是奇数，减 1 得到 0 。
 *
 *
 * 示例 2：
 * 输入：num = 8
 * 输出：4
 * 解释：
 * 步骤 1） 8 是偶数，除以 2 得到 4 。
 * 步骤 2） 4 是偶数，除以 2 得到 2 。
 * 步骤 3） 2 是偶数，除以 2 得到 1 。
 * 步骤 4） 1 是奇数，减 1 得到 0 。
 *
 *
 * 题意： 计算次数
 *
 *
 * 思路：
 * 1. 模拟
 * 2. 数学：
 *    如果当前的 num 最低位不为 1（偶数），则不断进行右移，直到最低位为 1（奇数），然后再对最低位的 11 进行消减，
 *    直到二进制表示中的所有 1 均被消减完（结果为 00），模拟过程结束。
 *
 *    换句话说，总的操作次数为 = 右移次数 + 消减次数 ：
 *    - 右移次数：num 中最高位 11 的所在的位置；
 *    - 消减次数：num 中 11 的个数。
 */
public class LeetCode_1342 {

    // 方法一：模拟
    // Time: O(n), Space: O(1), Faster: 100.00%
    public int numberOfSteps(int num) {
        int ans = 0;
        while (num != 0 && ++ans >= 0) num = num % 2 == 0 ? num / 2 : num - 1;
        return ans;
    }


    // 方法二：数学
    // Time: O(n), Space: O(1), Faster: 100.00%
    public int numberOfSteps2(int num) {
        int ret = 0;
        while (num > 0) {
            ret += (num > 1 ? 1 : 0) + (num & 0x01);
            num >>= 1;
        }
        return ret;
    }
}
