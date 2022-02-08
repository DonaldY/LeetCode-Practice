package chapter11.topic1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2022/02/09
 *
 * 2006. 差的绝对值为 K 的数对数目
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 *
 * |x| 的值定义为：
 *
 * - 如果 x >= 0 ，那么值为 x 。
 * -  如果 x < 0 ，那么值为 -x 。
 *
 * 示例 1：
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 *
 *
 * 示例 2：
 * 输入：nums = [1,3], k = 3
 * 输出：0
 * 解释：没有任何数对差的绝对值为 3 。
 *
 *
 * 示例 3：
 * 输入：nums = [3,2,1,5,4], k = 2
 * 输出：3
 * 解释：差的绝对值为 2 的数对为：
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 *
 * 题意：找对比
 *
 * 思路：
 * 1. 暴力法：2层for
 * 2. 先排序
 */
public class LeetCode_2006 {

    // Time: O(n ^ 2), Space: O(1), Faster: 49.49%
    public int countKDifference(int[] nums, int k) {
        if (null == nums || nums.length == 0) return 0;

        int ans = 0;

        for (int i = 0; i < nums.length - 1; ++i) {

            for (int j = i + 1; j < nums.length; ++j) {

                int abs = Math.abs(nums[j] - nums[i]);

                if (k == abs) {
                    ++ans;
                }
            }
        }

        return ans;
    }

    // Time: O(n), Space: O(n), Faster: 75.04%
    public int countKDifference2(int[] nums, int k) {
        int res = 0, n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int j = 0; j < n; ++j) {
            res += cnt.getOrDefault(nums[j] - k, 0)
                    + cnt.getOrDefault(nums[j] + k, 0);
            cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
        }
        return res;
    }
}
