package chapter3.topic4;

import java.util.HashMap;
import java.util.Map;

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
 * 2. 两个前缀和的差
 *    sum(i~j) = sum(0~j) - sum(0~i-1)
 *             = s(j) - s(i-1)  = K
 *    s(j) - k = s(i-1)
 *    可以保存在 哈希表中
 *
 *    举栗子： 1 2 1 -1                 s(j)   cnt
 *    sum      sum-k      cnt          key    value
 *     0                   0            0      1
 *     1         -2        0            1      1
 *     3          0        1            3      1
 *     4          1        2            4      1
 *     3          0        3            3      2
 *
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

    // 方法二： 前缀和
    // Time: O(n), Space: O(n), Faster: 41.74%
    public int subarraySumPrefixSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        // s(j)  cnt
        // key   value
        //  0      1
        // 0 出现的次数为 1, 边界情况
        map.put(0, 1);
        int sum = 0, cnt = 0;
        for (int num : nums) {
            sum += num;
            cnt += map.getOrDefault(sum - k, 0);
            int sumCnt = map.getOrDefault(sum, 0);
            map.put(sum, sumCnt + 1);
        }
        return cnt;
    }
}
