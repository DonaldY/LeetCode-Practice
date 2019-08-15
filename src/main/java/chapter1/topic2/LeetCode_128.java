package chapter1.topic2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * 题意：
 * 最长的连续子序列，时间复杂度 o(n)
 *
 * 思路：
 * 1. 用一个数组记录是否存在
 * 2. 排序
 * 3. 辅助set，来对比
 *
 */
public class LeetCode_128 {

    public int longestConsecutive(int[] nums) {

        return 0;
    }

    // Time: O(n*log(n)), Space: O(1)
    public int lengthOfLongestConsecutiveSequenceSorting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 0, p = 0;

        while (p < nums.length) {
            int len = 1;
            while (p < nums.length-1) {
                if (nums[p+1] - nums[p] > 1) break;
                if (nums[p+1] - nums[p] == 1) ++len;
                ++p;
            }
            max = Math.max(max, len);
            ++p;
        }
        return max;
    }

    // Time: O(n), Space: O(n), Faster: 60.22%
    public int lengthOfLongestConsecutiveSequenceSet(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int num: nums) set.add(num);

        for (int i = 0; i < nums.length && !set.isEmpty(); ++i) {
            set.remove(nums[i]);
            int low = nums[i], high = nums[i];
            while (set.contains(--low)) set.remove(low);
            while (set.contains(++high)) set.remove(high);
            max = Math.max(max, high - low - 1);
        }
        return max;
    }
}
