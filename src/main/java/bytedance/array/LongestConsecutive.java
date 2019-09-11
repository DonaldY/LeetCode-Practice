package bytedance.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组与排列 - 最长连续序列
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 题意: 查找最长连续序列的长度
 *
 * 思路:
 * 1. 排序, 后查找, o(logn)
 * 2. 扩展法, 找到一个数, 向前和向后查找, 递归寻找
 */
public class LongestConsecutive {

    // Time: o(n), Space: o(n)
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>(nums.length);

        for (int num : nums) set.add(num);

        int max = 1 ;

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
