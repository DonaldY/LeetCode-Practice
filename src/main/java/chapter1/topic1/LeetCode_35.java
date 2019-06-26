package chapter1.topic1;

/**
 * 35. Search Insert Position
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * 题意：给一个数，找出这个数在这个数组的位置，若这个位置没有则返回此数应插入的下标
 *
 * 思路：
 * 1. 二分查找
 */
public class LeetCode_35 {

    public int searchInsert(int[] nums, int target) {

        if (nums == null) return -1;

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < nums[mid]) high = mid - 1;
            else if (target > nums[mid]) low = mid + 1;
            else return mid;
        }
        return low;
    }
}
