package chapter3.topic4;

import java.util.Arrays;

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
 * 3. 遍历两次，
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

    // Time: o(n * log(n)), Space: o(n), Faster:  44.39%
    public int findUnsortedSubarrayBySorting(int [] nums) {

        if (nums == null || nums.length == 0) return 0;
        int [] sorted = nums.clone();
        Arrays.sort(sorted);
        int i = 0, j = nums.length - 1;
        while (i < nums.length && nums[i] == sorted[i]) ++i;
        while (j >= 0 && nums[j] == sorted[j]) --j;
        return Math.max(j - i + 1, 0);
    }

    // Time: o(n), Space: o(n), Faster:  100.00%
    public int findUnsortedSubarrayTwoPass(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i < n-1 && nums[i] <= nums[i+1]) ++i;
        while (j > 0 && nums[j] >= nums[j-1]) --j;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int k = i; k <= j; ++k) {
            min = Math.min(min, nums[k]);
            max = Math.max(max, nums[k]);
        }
        // expand
        while (i >= 0 && min < nums[i]) --i;
        while (j < n && max > nums[j]) ++j;
        // i+1 ~ j-1
        return Math.max(j - i - 1, 0);
    }

    // Time: O(n), Space: O(1), Faster: 92.26%
    public int findUnsortedSubarrayOnePass(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int i = 0, j = -1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int k = 0; k < n; ++k) {
            max = Math.max(max, nums[k]);
            if (nums[k] != max) j = k;
            int p = n - 1 - k;
            min = Math.min(min, nums[p]);
            if (nums[p] != min) i = p;
        }
        return j - i + 1;
    }


}
