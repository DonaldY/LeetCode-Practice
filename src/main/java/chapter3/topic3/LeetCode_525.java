package chapter3.topic3;

import chapter1.topic2.LeetCode_52;

/**
 * @author donald
 * @date 2022/10/04
 *
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 示例 2：
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 *  
 * 提示：
 * - 1 <= nums.length <= 105
 * - nums[i] 不是 0 就是 1
 *
 * 思路：
 * 1. 暴力法：
 * 2.
 */
public class LeetCode_525 {

    public static void main(String[] args) {
        LeetCode_525 leetCode_525 = new LeetCode_525();
        System.out.println(leetCode_525.findMaxLength(new int[]{0, 1, 1}));
    }

    // 方法一： 暴力法
    // Time: O(n ^ 2), Space: O(1), Faster: 超时
    public int findMaxLength(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; ++i) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < preSum.length; ++i) {
            for (int j = i + 1; j < preSum.length; ++j) {
                int len = j - i;
                if (len % 2 == 1) continue; // 跳过奇数长度
                int num = preSum[j] - preSum[i];
                if (num == len / 2) {
                    ans = Math.max(len, ans);
                }
            }
        }
        return ans;
    }
}
