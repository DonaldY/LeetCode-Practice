package chapter1.topic1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15. 3Sum
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 题意：从数组找到3个数，且不重复，使其相加为0
 *
 * 思路：
 * 1. 暴力法，o(n ^ 3)
 * 2. 双指针
 */
public class LeetCode_15 {

    public List<List<Integer>> threeSum(int[] nums) {

        return Collections.emptyList();
    }

    // Time: o(n ^ 2), Space: o(1), Faster: 97.48%
    public List<List<Integer>> threeNumSumToZeroOn2(int [] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = nums.length - 1; k >= 2; --k) {
            if (nums[k] < 0) break;
            int target = -nums[k], i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (i < j && nums[i + 1] == nums[i]) ++i;
                    while (i < j && nums[j - 1] == nums[j]) --j;
                    ++i; --j;
                } else if (nums[i] + nums[j] < target) {
                    ++i;
                } else {
                    --j;
                }
            }
            while (k >= 2 && nums[k - 1] == nums[k]) --k;
        }

        return result;
    }
}
