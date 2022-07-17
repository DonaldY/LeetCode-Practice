package chapter1.topic4;

/**
 * 152. Maximum Product Subarray
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * 题意： 求连续子列，最大值
 *
 * 思路：
 * 1. 两层for循环 O(n ^ 2)
 * 2. 动态规划
 *
 */
public class LeetCode_152 {
    public static void main(String[] args) {
        LeetCode_152 leetCode_152 = new LeetCode_152();
    }

    // 方式一：暴力法//
    // Time: O(n ^ 2), Space: O(1), Faster: 5.01%
    public int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int sum = nums[i];
            max = Math.max(max, sum);
            for (int j = i + 1; j < nums.length; ++j) {
                sum *= nums[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    // 方式二：动态规划
    // Time: o(n), Space: o(1), Faster: 66.15%
    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int max = nums[0], currMax = nums[0], currMin = nums[0];

        for (int i = 1; i < nums.length; ++i) {

            int a = currMax * nums[i], b = currMin * nums[i], c = nums[i];

            currMax = max(a, b, c);

            currMin = min(a, b, c);

            max = Math.max(max, currMax);
        }

        return max;
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
