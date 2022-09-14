package chapter9.topic1;

import java.util.Arrays;

/**
 * @author donald
 * @date 2022/09/14
 *
 * 删除某些元素后的数组均值
 *
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
 * 与 标准答案 误差在 10-5 的结果都被视为正确结果。
 *
 * 示例 1：
 * 输入：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
 * 输出：2.00000
 * 解释：删除数组中最大和最小的元素后，所有元素都等于 2，所以平均值为 2 。
 *
 * Tips:
 * - arr.length 是 20 的 倍数
 * - 20 <= arr.length <= 1000
 *
 *
 * 思路：
 * 1. 模拟： 先排序，用 5% 开有，用 95%结尾，最后用上 90% 的长度
 */
public class LeetCode_1619 {

    // Time: O(nlog(n)), Space: O(1), Faster: 99.73%
    public double trimMean(int[] arr) {
        if (null == arr || arr.length == 0) return 0;
        double ans = 0;
        Arrays.sort(arr);
        // 开头： arr.length / 20
        // 结尾： arr.length * 19 / 20
        for (int i = arr.length / 20; i < arr.length * 19 / 20; i++) {
            ans += arr[i];

        }
        return ans / (arr.length * 9 / 10);
    }
}
