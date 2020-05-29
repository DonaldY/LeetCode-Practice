package chapter1.topic1;

import java.util.*;

/**
 * @author donald
 * @date 2020/5/26
 *
 * 47. Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 题意：
 * 给一个可能有重复数字的数组，计算出其全排列
 *
 *
 * 思路：
 * 1. 在 leetcode_46 基础上，增加 hash，去掉重复数组
 *
 * 2.
 *
 */
public class LeetCode_47 {

    // Time: O(n * n), Space: O(n), Faster: 16.33%
    public List<List<Integer>> permuteUnique(int[] nums) {

        if (null == nums || nums.length == 0) return Collections.emptyList();

        Set<List<Integer>> result = new HashSet<>();

        List<Integer> list = new ArrayList<>();
        for (int num: nums) list.add(num);

        permuteRec(list, 0, result);

        return new ArrayList<>(result);
    }

    private void permuteRec(List<Integer> nums, int start, Set<List<Integer>> result) {

        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }

        for (int i = start; i < nums.size(); ++i) {
            Collections.swap(nums, i , start);
            permuteRec(nums, start + 1, result);
            Collections.swap(nums, i, start);
        }
    }
}
