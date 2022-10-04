package chapter2.topic1;

/**
 * @author donald
 * @date 2022/10/04
 *
 * 209. 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 * 题意：
 *
 * 思路：
 * 1. 滑动窗口
 * 2. 前缀和
 *    1. 先遍历一遍，计算前缀和
 *    2. 再前缀相减
 */
public class LeetCode_209 {
    // 方法一： 滑动窗口
    // Time: O(n), Space: O(n), Faster: 99.98%
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, start = 0, end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (target <= sum) {
                ans = Math.min(end - start + 1, ans); // 更新值： 注意这里是长度
                sum -= nums[start];
                ++start;
            }
            ++end;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans; // 需要判断是否有可行解
    }
    // 方法二： 前缀和 + 二分搜索
    // Time: O(n), Space: O(n), Faster:
    public int minSubArrayLenSum(int target, int[] nums) {
        int[] sumArr = new int[nums.length + 1];
        // 1. 计算前缀和
        for (int i = 1; i <= nums.length; ++i) {
            sumArr[i] = sumArr[i - 1] + nums[i - 1];
        }
        return 0;
    }
}
