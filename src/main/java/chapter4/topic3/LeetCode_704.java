package chapter4.topic3;

/**
 * 704. Binary Search
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 */
public class LeetCode_704 {

    public static void main(String[] args) {

        LeetCode_704 leetCode_704 = new LeetCode_704();
    }

    // Time: o(log(n)) ,Space: o(1), Faster: 100.00%
    public int search(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        while (low <= high) {

            int index = (low + high) / 2;
            int num = nums[index];
            if (num == target) return index;
            if (target > num) low = index + 1;
            if (target < num) high = index - 1;
        }

        return -1;
    }
}

