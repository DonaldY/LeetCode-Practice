package chapter3.topic3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2022/08/21
 *
 * 子数组求和是否为 K 的整数倍
 *
 * 这个题目说的是，给你一个非负整数数组和一个整数 k，你要判断这个数组中是否存在一个长度至少为 2 的子数组，它的元素之和是 k 的整数倍。
 *
 * 注意，子数组要求是连续的。
 *
 * 比如说，给你的数组是：
 *
 * 1, 3, 4, 8, 1
 *
 * 给你的整数 k 是：
 *
 * k = 6
 *
 * 在给出的数组中，存在子数组 [4,8]，它的元素之和等于 12，是 6 的倍数。因此你要返回 true。
 *
 *
 * 思路：
 * 1. 暴力法
 * 2. 同余的概念： 当两个整数除以同一个数字，得到的余数相同，那么这个两个整数同余
 *    a % k == b % k  => a - b = m * k
 *                      s(i) - s(j)
 *                      sum(j+1 ~ i)
 *
 */
public class LeetCode_523 {

    // 方法一： 暴力法
    // Time: O(n ^ 2), Space: O(1), Faster: 超出时间
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        for (int i = 0; i < nums.length; ++i) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
                sum += nums[j];
                if ((k == 0 && sum == 0) || (k != 0 && sum % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 方法二：
    // Time: O(n), Space: O(k), Faster: 15.71%
    public boolean checkSubarraySumMod(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        // key 余数， value 对应下标
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            int mod = k == 0 ? sum : sum % k;
            Integer j = map.get(mod);
            if (j != null) {
                // 连续
                if (i - j > 1) return true;
            } else map.put(mod, i);
        }
        return false;
    }
}
