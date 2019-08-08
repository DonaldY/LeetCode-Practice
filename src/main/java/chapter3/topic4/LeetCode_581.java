package chapter3.topic4;

/**
 * 581. Shortest Unsorted Continuous Subarray
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 *
 * 题意：
 * 最长需要排序的子序列
 *
 * 思路：
 * 1. 直接查找
 * 2. 排序后，对比两个数组，不同的值，然后找出最小和最大
 */
public class LeetCode_581 {

    // Time: o(n ^ 2), Space: o(1), Faster: 5.04%
    public int findUnsortedSubarray(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int min = nums.length, max = 0;

        boolean flag = false;

        for (int i = 0; i < nums.length; ++i) {

            for (int j = i + 1; j < nums.length; ++j) {

                if (nums[i] > nums[j]) {

                    flag = true;
                    min = i < min ? i : min;
                    max = j > max ? j : max;
                }
            }
        }

        if (flag) {

            return 0;
        }

        return max - min + 1;
    }
}
