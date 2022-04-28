package chapter5.topic3;

/**
 * @author donald
 * @date 2022/04/28
 *
 * 905. 按奇偶排序数组
 *
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 *
 * 返回满足此条件的 任一数组 作为答案。
 *
 *  
 * 示例 1：
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[0]
 *
 * 题意： 偶数排前面
 *
 * 思路：注意： 偶数比奇数小时，找下一个偶数
 */
public class LeetCode_905 {

    // Time: O(n), Space: O(1), Faster: 70.29%
    public int[] sortArrayByParity(int[] nums) {

        int odd = 0, even = 0;
        while (odd < nums.length && even < nums.length) {
            while (odd < nums.length && nums[odd] % 2 ==0) ++odd;
            if (odd >= nums.length) break;
            while (even < nums.length && nums[even] % 2 != 0) ++even;
            if (even >= nums.length) break;
            if (even < odd) {
                ++even;
                continue;
            }
            int tmp = nums[odd];
            nums[odd] = nums[even];
            nums[even] = tmp;
        }

        return nums;
    }
}
