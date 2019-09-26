package chapter1.topic1;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * 题意： 在一个排序的数组中，找到给定数的开始位置和结束位置
 *
 * 思路：
 * 1. 二分法
 *    中中间开始找
 *    1. 若找到了， 则向左边继续找
 *    2. 若找到了， 则向右边继续找
 */
public class LeetCode_34 {

    public static void main(String[] args) {

        LeetCode_34 leetCode_34 = new LeetCode_34();

        leetCode_34.searchRange(new int[]{5,7,7,8,8,10}, 8);
    }

    // Time: O(log(n)), Space: O(1), Faster: 100.00%
    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int start = -1, end = -1;

        for (int left = 0, right = nums.length - 1; left <= right;) {

            int mid = (right + left) / 2;
            if (nums[mid] == target) {

                start = mid;
                break;
            } else if (target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }

        while (start >= 1 && nums[start] == nums[start - 1]) {
            --start;
        }

        for (int left = 0, right = nums.length - 1; left <= right;) {

            int mid = (right + left) / 2;
            if (nums[mid] == target) {

                end = mid;
                break;
            } else if (target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }

        while (end >= 0 && end <= nums.length - 2 && nums[end] == nums[end + 1]) {
            ++end;
        }

        return new int[]{start, end};
    }

    private int binarySearchLastOne(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < nums[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return high;
    }

    // Time: O(log(n)), Space: O(1)
    public int[] binarySearchFirstAndLastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int end = binarySearchLastOne(nums, target);
        int start = binarySearchLastOne(nums, target-1) + 1;
        if (start >= 0 && start <= end && end < nums.length)
            return new int[]{start, end};
        else return new int[]{-1, -1};
    }
}
