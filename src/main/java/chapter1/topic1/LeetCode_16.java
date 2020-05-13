package chapter1.topic1;

import java.util.Arrays;

/**
 * @author donald
 * @date 2020/5/13
 *
 * 16. 3Sum Closest
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * 题意：
 * 从数组中找到3个数，这3个数相加的值需要离目标值最近
 *
 * 思路：
 * 1. 暴力法：穷举每个例子
 *    3层for循环
 *
 * 2. 先排序。
 *    1. 先确定一个数字位置 k（可以是最大值，也可以是最小值）
 *    2. 两个指针 i（0），j（k - 1）
 *    3. 每次都记录最小值
 *
 *    -4 -1 1 2 4 5 6
 *     |  |         |
 *     k  i         j
 */
public class LeetCode_16 {

    // Time: O(n ^ 2), Space: O(1), Faster: 98.26%
    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length == 0) return 0;

        if (nums.length <= 3) {

            int sum = 0;

            for (int num : nums) sum += num;

            return sum;
        }

        Arrays.sort(nums);

        int result = 0, min = Integer.MAX_VALUE;

        for (int k = 0; k < nums.length - 2; ++k) {

            int i = k + 1;
            int j = nums.length - 1;

            while (i < j) {

                int sum = nums[k] + nums[i] + nums[j];

                if (sum == target) return sum;
                else if (sum < target) ++i;
                else --j;

                int diff = Math.abs(target - sum);
                if (diff < min) {
                    result = sum;
                    min = diff;
                }
            }
        }

        return result;
    }
}
