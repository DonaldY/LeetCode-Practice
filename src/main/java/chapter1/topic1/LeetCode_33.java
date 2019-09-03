package chapter1.topic1;

/**
 * 33. Search in Rotated Sorted Array
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * 题意：
 * 在旋转有序数组里找到对应的值，并返回下标，时间复杂度在 o(log(n)), 数组元素都唯一的
 *
 * 思路：
 * 1. 将圆转化为直线，然后二分查找， 判断是否左右两边是否递增
 * 2. 按找正常中位数查找（主要是判断）
 *    I. 先确保局部整体是否有序
 *    II.再确保目标值在这局部中的位置
 */
public class LeetCode_33 {

    // Time: o(log(n)), Space: o(1), Faster: 100.00%
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) return mid;
            if (nums[mid] >= nums[low]) {
                if (target < nums[mid] && target >= nums[low]) high = mid - 1;
                else low = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
