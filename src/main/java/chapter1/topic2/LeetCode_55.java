package chapter1.topic2;

/**
 * 55. Jump Game
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 *
 * 题意： 根据所在位置的数值，可以选择跳的步数（3, 则可以跳 1 或 2 或 3 步）， 能否跳到数组某尾
 *
 * 思路：
 * 1. 贪心法
 */
public class LeetCode_55 {

    // Time: o(n), Space: o(1), Faster: 99.10%
    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) return false;

        int max = 0;
        for (int i = 0; i < nums.length; ++i) {

            if (max >= nums.length - 1) return true;
            // 可能碰到了 0, 卡住跳不动
            if (i > max) return false;
            // 不断计算能跳到的最远距离
            max = Math.max(max, i + nums[i]);
        }

        return false;
    }

    // Time: o(n), Space: o(1), Faster: 81.62%
    public boolean canJump2(int[] nums) {

        if (nums == null || nums.length == 0) return false;

        int farthest = 0;
        for (int i = 0; i < nums.length - 1; ++i) {

            // 不断计算能跳到的最远距离
            farthest = Math.max(farthest, i + nums[i]);

            // 可能碰到了 0, 卡住跳不动
            if (i >= farthest) return false;
        }

        return farthest >= nums.length - 1;
    }
}
