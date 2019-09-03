package bytedance.array;

/**
 *  数组与排序 - 搜索旋转排序数组
 *
 *  示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 题意：
 *
 * 思路： 查看 LeetCode 33
 */
public class SearchInRotatedSortedArray {

    public int search (int [] nums, int target) {

        if (nums == null || nums.length == 0) return -1;

        int low = 0, high = nums.length - 1;

        while (low <= high) {

            int mid = (high - low) / 2 + low;

            if (target == nums[mid]) return mid;

            if (nums[low] <= nums[mid]) {

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
