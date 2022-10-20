package chapter3.topic3;

/**
 * 540. Single Element in a Sorted Array
 *
 * Example 1:
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 *
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 * 题意： 找到数组中只出现过一次的数
 *
 * 思路：
 * 1. 位运算，异或(两个相同的数异或为 0)
 * 2. 因为数组有序，所以相同的必定在旁边
 *
 */
public class LeetCode_540 {

    // Time: o(n), Space: o(1), Faster: 100.00%
    public int singleNonDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) {

            return 0;
        }

        int result = 0;

        for (int num : nums) {

            result ^= num;
        }

        return result;
    }

    // Time: o(log(n)), Space: o(1), Faster: 100.00%
    public int singleNumInSortedArrayBinarySearch(int [] nums) {

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                --mid;
            } else if (mid + 1 < nums.length && nums[mid + 1] == nums[mid]) {
            } else {
                return nums[mid];
            }
            if ((mid - low) % 2 == 1) high = mid - 1;
            else low = mid + 2;
        }
        return -1;
    }

    // 方法三：开区间
    // Time: o(log(n)), Space: o(1), Faster: 100.00%
    public int singleNonDuplicate2(int[] nums) {
        int n = nums.length;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < n - 1 && nums[mid] == nums[mid + 1]) { // 处理右半边
                if (mid % 2 == 1) {  // mid 奇, mid + 1偶
                    right = mid - 1;
                } else {
                    left = mid + 2;
                }
            } else if (mid > 0 && nums[mid] == nums[mid - 1]) { // 处理左半边
                if (mid % 2 == 1) { // mid 偶, mid -1 奇
                    left = mid + 1;
                } else {
                    right = mid - 2;
                }
            } else {
                return nums[mid]; // 找到答案
            }
        }
        return -1;
    }
}
