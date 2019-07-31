package chapter2.topic4;

/**
 * 283. Move Zeroes
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * 题意： 把数组中所有的 0 移至末尾
 *
 * 思路：
 * 1. 额外数组，存储非0值，之后赋值
 * 2. 直接在原数组上移动，这可能会多次copy
 */
public class LeetCode_283 {

    // Time: o(n), Space: o(n), Faster: 100.00%
    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) return;

        int [] temp = new int[nums.length];

        for (int i = 0, j = 0; i < nums.length; ++i) {

            if (nums[i] != 0) temp[j ++] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, nums.length);
    }
}
