package chapter2.topic2;

import java.util.Arrays;

/**
 * 287. Find the Duplicate Number
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * 题意： 查找重复数字， 数字范围在 [1, n]
 *
 * 思路：
 * 1. 暴力法： 2次循环
 * 2. 二分搜索变种
 * 3. 双指针
 */
public class LeetCode_287 {

    // Time: O(n * log(n)), Space: O(1), Faster: 8.00%
    public int findDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) return -1;

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; ++i) {

            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return -1;
    }

    // 方法一：暴力法
    // Time: O(n^2), Space: O(1), Faster： 超出时间限制
    public int findDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i+1; j < nums.length; ++j) {
                if (nums[i] == nums[j]) return nums[i];
            }
        }

        return -1;
    }

    // 方法二： 二分搜索变种
    // Time: O(n*log(n)), Space: O(1), Faster: 33.66%
    public int findDuplicateBinarySearch(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num: nums)
                if (num <= mid)
                    ++count;
            if (count > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // 方法三： 双指针
    // Time: O(n), Space: O(1), Faster: 93.12%
    public int findDuplicateTwoPointer(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int p = 0;
        while (slow != p) {
            slow = nums[slow];
            p = nums[p];
        }
        return slow;
    }
}
