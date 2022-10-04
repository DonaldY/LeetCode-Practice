package chapter4.topic3;

/**
 * @author donald
 * @date 2022/10/04
 *
 * 713. 乘积小于 K 的子数组
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 *  
 *
 * 示例 1：
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 *
 *
 * 思路： 滑动窗口
 */
public class LeetCode_713 {

    // 滑动窗口方法：
    // Time: O(n), Space: O(1), Faster: 100.00%
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int ans = 0;
        int mul = 1;
        for (int left = 0, right = 0; right < nums.length; ++right) {
            mul *= nums[right];
            while (mul >= k) {
                mul /= nums[left];
                ++left;
            }
            // 重点在这： 每增加1个right，共有 right - left + 1 个组合。
            ans += right - left + 1;
        }
        return ans;
    }
}
