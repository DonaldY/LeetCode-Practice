package chapter2.topic1;

import java.util.Arrays;

/**
 * 213. House Robber II
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 *
 * 题意：
 * 1. 求间隔数字之间最大值， 首尾是相连的
 *
 * 思路：
 * 1. 按照之前 leetcode 198思路
 *    然后去掉尾，抢一次
 *    然后去掉首，抢一次
 *    取这两次的最大值
 *
 */
public class LeetCode_213 {

    // Time: o(n), Space: o(n), Faster: 100.00%
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        int withoutTailResult = this.robInternal(Arrays.copyOfRange(nums, 0, nums.length - 1));

        int withoutHeadResult = this.robInternal(Arrays.copyOfRange(nums,1 , nums.length));

        return Math.max(withoutHeadResult, withoutTailResult);
    }

    private int robInternal(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        int d1 = nums[0];

        int d2 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; ++i) {

            int temp = d2;

            d2 = Math.max(d1 + nums[i], d2);

            d1 = temp;
        }

        return d2;
    }


    private int rob(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;
        for (int i = start; i <= end; ++i) {
            int cur = Math.max(prev1, prev2+nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }

    // Time: O(n), Space: O(1)
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
    }

}
