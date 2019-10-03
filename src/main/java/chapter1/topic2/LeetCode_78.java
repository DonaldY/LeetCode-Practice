package chapter1.topic2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 78. Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 题意： 找到数组的所有子集, 2 ^ 3 = 8
 *
 * 思路：
 * 1. 回溯法（递归）
 * 2. 位运算
 */
public class LeetCode_78 {

    // Time: O(2 ^ n), Space: O(n), Faster: 100.00%
    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> elem = new ArrayList<>();

        subsetsRecursive(nums, 0, elem, result);

        return result;
    }

    private void subsetsRecursive(int[] nums, int start, List<Integer> elem, List<List<Integer>> result) {
        result.add(new ArrayList<>(elem));
        for (int i = start; i < nums.length; ++i) {
            elem.add(nums[i]);
            subsetsRecursive(nums, i + 1, elem, result);
            elem.remove(elem.size() - 1);
        }
    }

    // Time: O(n * 2 ^ n), Space: O(1), Faster: 41.71%%
    public List<List<Integer>> subsetsBit(int[] nums) {

        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        int N = (int)Math.pow(2, n);

        for (int i = 0; i < N; ++i) {
            List<Integer> elem = new ArrayList<>();
            for (int j = 0; j < n; ++j)
                if (((i >> j) & 1) == 1) // 0&0=0;   0&1=0;    1&0=0;     1&1=1;
                    elem.add(nums[j]);
            result.add(elem);
        }

        return result;
    }
}
