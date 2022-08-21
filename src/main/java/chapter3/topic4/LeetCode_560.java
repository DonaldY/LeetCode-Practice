package chapter3.topic4;

/**
 * @author donald
 * @date 2022/08/21
 *
 * 求和等于 K 的子数组数量
 *
 * 这个题目说的是，给你一个整数数组和一个整数 k，你要计算出求和等于 k 的子数组数量。注意，子数组要求是连续的。
 *
 * 比如说，给你的数组和 k 分别是：
 *
 * [1, 2, 1, -1]
 * k = 3
 *
 * 在给出的数组中，求和等于 3 的子数组有 3 个，分别是：
 *
 * [1, 2]
 * [2, 1]
 * [1, 2, 1, -1]
 *
 * 因此，你要返回满足条件的子数组数量就是 3。
 *
 *
 * 思路：
 * 1. 暴力法
 */
public class LeetCode_560 {

    // 方法一：暴力法
    // Time: O(n^2), Space: O(1), Faster: 5.78%
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int cnt = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            for (int j = i; j < n; ++j) {
                sum += nums[j];
                if (sum == k) ++cnt;
            }
        }
        return cnt;
    }
}
