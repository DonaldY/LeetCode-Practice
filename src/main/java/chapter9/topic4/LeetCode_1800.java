package chapter9.topic4;

/**
 * @author donald
 * @date 2022/10/07
 *
 * 1800. 最大升序子数组和
 *
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 *
 * 子数组是数组中的一个连续数字序列。
 *
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 *
 * 示例 1：
 * 输入：nums = [10,20,30,5,10,50]
 * 输出：65
 * 解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
 *
 *
 * 示例 2：
 * 输入：nums = [10,20,30,40,50]
 * 输出：150
 * 解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
 *
 *
 * 示例 3：
 * 输入：nums = [12,17,15,13,10,11,12]
 * 输出：33
 * 解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
 *
 *
 * 示例 4：
 * 输入：nums = [100,10,1]
 * 输出：100
 *
 *
 * 思路：
 * 1. 暴力法： 2层for
 * 2. 简单模拟
 */
public class LeetCode_1800 {

    // 方法一： 暴力法
    // Time: O(n), Space: O(1), Faster: 100.00%
    public int maxAscendingSum(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            int sum = nums[i], pre = nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] > pre) {
                    sum += nums[j];
                    pre = nums[j];
                } else {
                    break;
                }
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    // 方法二： 简单模拟
    // Time: O(n), Space: O(1), Faster: 100.00%
    public int maxAscendingSum2(int[] nums) {
        int ans = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) cur += nums[i];
            else cur = nums[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
