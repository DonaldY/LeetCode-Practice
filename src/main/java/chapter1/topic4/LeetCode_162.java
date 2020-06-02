package chapter1.topic4;

/**
 * @author donald
 * @date 2020/6/2
 *
 * 162. Find Peak Element
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 * Follow up: Your solution should be in logarithmic complexity.
 *
 * 题意：
 * 找到波峰。
 *
 * 给你一个整数数组，数组中相邻的元素不相等，你要找到这个数组的波峰元素，然后返回它的下标。波峰元素指的是比左右相邻元素都要大的元素。
 *
 * 如果数组中包含多个波峰元素，则返回任意一个波峰元素的下标即可。你可以把数组左右边界之外的元素都看成负无穷大。
 *
 * 思路：
 * 1. 遍历一遍，若左增右减则说明是波峰
 *
 * 2. 二分查找
 *
 */
public class LeetCode_162 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public int findPeakElement(int[] nums) {

        if (null == nums || nums.length == 0) return -1;

        for (int i = 0; i < nums.length - 1; ++i) {

            if (nums[i] > nums[i + 1]) {

                return i;
            }
        }

        return nums.length -1;
    }
}
