package chapter2.topic1;

/**
 * 238. Product of Array Except Self
 *
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 * 题意： 除了自身元素的数组乘积
 * 给你一个大小为 n 的整数数组 nums，其中 n > 1。你要返回一个数组 output。
 * 其中，output(i) 是原数组中除了 nums(i) 以外，所有数字的乘积。
 * 注意，这道题目的求解过程不能使用除法。
 *
 * 思路：
 * 1. 用除法，要注意分母为0的情况。
 * 2. 两层for循环 O(n ^ 2)
 * 3. 遍历两次，记录乘积
 */
public class LeetCode_238 {

    // Time: O(n), Space: O(n), Faster: 100.00%
    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) return nums;

        int [] pre = new int[nums.length];
        pre[0] = 1;

        for (int i = 0, mul = 1; i < nums.length; ++i) {

            if (i != 0) pre[i] = mul;
            mul *= nums[i];
        }

        int [] last = new int[nums.length];
        last[nums.length - 1] = 1;

        for (int i = nums.length - 1, mul = 1; i >= 0; --i) {

            if (i != nums.length - 1)last[i] = mul;
            mul *= nums[i];
        }

        for (int i = 0; i < nums.length; ++i) {

            nums[i] = pre[i] * last[i];
        }

        return nums;
    }
}
