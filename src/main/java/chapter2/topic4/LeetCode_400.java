package chapter2.topic4;

/**
 * @author donald
 * @date 2022/06/17
 *
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 *
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 * 题意： 找对应的位
 *
 * 思路：
 * 1. 暴力法： 一个个查找
 * 2. 先统计，再计算，在定位：
 *    1. 确定 n 所在 数字 的 位数, 记为 digit
 *      - 1   ~ 9   : 9个    有 9 位
 *      - 10  ~ 99  : 90个   有 180  位
 *      - 100 ~ 999 : 900个  有 2700 位
 *      - 1000~ 9999: 9000个 有 360000 位
 *      能推算公式出来： 9 * (位数) * 10 ^ (位数 - 1)
 *                    9 * digit * 10 ^ (digit - 1)
 *    2. 确定 n 所在的 数字 ，记为 num
 *      公式： num = start + (n - 1)
 *      n 是计算后的
 *    3. 确定 n 是 num 中的哪一数位，并返回结果
 *      (n - 1) % digit
 */
public class LeetCode_400 {

    // Time: O(logn), Space: O(logn), Faster: 100.00%
    public int findNthDigit(int n) {

        int digit = 1;
        long start = 1;
        long cnt = 9;
        while (n > cnt) {
            ++ digit;
            n -= cnt;
            start *= 10;
            cnt = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
