package chapter1.topic4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 167. Two Sum II - Input array is sorted
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * 题意：与leetcode 1 相似，只是 nums 为有序，并且下标要加1
 *
 * 思路：
 * 1. 按照 leetcode 1的思路
 *
 * 2. 二分法
 */
public class LeetCode_167 {

    public static void main(String[] args) {

        LeetCode_167 leetCode = new LeetCode_167();

        System.out.println(Arrays.toString(leetCode.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    // Time: o(n), Space: o(n), faster: 29.79%
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numberIndicesMap = new HashMap<Integer, Integer>(nums.length);

        for (int i = 0; i < nums.length; ++i) {

            int needNum = target - nums[i];

            if (numberIndicesMap.containsKey(needNum)) {

                return new int[] {numberIndicesMap.get(needNum) + 1, i + 1};
            }

            numberIndicesMap.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }

    // 方法二： 双指针
    // TimeL: o(n) Space: o(1) faster:  100.00%
    public int[] twoSum2(int[] nums, int target) {

        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] > target) --j;
            else if (nums[i] + nums[j] < target) ++i;
            else return new int[]{i + 1, j + 1};
        }
        return new int[]{-1, -1};
    }

    // 方法二： 双指针
    // Time: o(n) Space: o(1) faster:  44.73%
    public int[] twoSum3(int[] numbers, int target) {
        if (null == numbers || numbers.length == 0) return new int[0];
        for (int left = 0, right = numbers.length - 1; left < right; ) {
            int leftNum = numbers[left];
            int rightNum = numbers[right];
            if (leftNum + rightNum == target) {
                return new int[] {left, right};
            } else if (leftNum + rightNum < target) {
                ++left;
            } else if (leftNum + rightNum > target) {
                --right;
            }
        }
        return new int[] {-1, -1};
    }

    // 方法三： 双指针 + 二分查找
    // Time: o(nlogn) Space: o(1) faster:  18.06%
    public int[] twoSum4(int[] numbers, int target) {
        if (null == numbers || numbers.length == 0) return new int[0];
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (numbers[mid] == target - numbers[i]) return new int[] {i, mid};
                else if (numbers[mid] < target - numbers[i]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }
}
