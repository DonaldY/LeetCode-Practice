package chapter2.topic1;

import java.util.TreeSet;

/**
 * @author donald
 * @date 2021/04/17
 *
 * LeetCode 220. 存在重复元素 III
 *
 * 给你一个整数数组 nums 和两个整数 k 和 t 。
 * 请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 * ```
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 *
 *
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 *
 *
 * 示例 3：
 *
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 * ```
 *
 * 题意： 比较
 *
 * 思路：
 * 方法1：暴力法, 2层for
 */
public class LeetCode_220 {

    // 方法一： 暴力法
    // Time: O(n ^ 2), Space: O(1), Faster: 超时
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (null == nums || nums.length == 0) return false;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (Math.abs((long)nums[i] - (long)nums[j]) <= t && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    // 方法二：
    // Time: O(nlogn), Space: O(n), Faster: 69.80%
    public boolean containsNearbyAlmostDuplicateWithTree(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);  // 找到下一个比这小的数
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) { // 超出范围，将区间外的移除
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
