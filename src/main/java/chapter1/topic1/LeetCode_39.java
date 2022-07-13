package chapter1.topic1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 题意： 给定一组数和目标值，求用数组的值达到目标值
 *
 * 思路：
 * 1. 递归，选自身或者选下一个
 * 2. 在一基础上， 排序，减枝
 *
 * 排列组合题
 */
public class LeetCode_39 {

    // Time: O(n ^ (target / min)), Space: O(target / min), Faster: 93.23%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) return null;

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        combSum(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void combSum(int [] nums, int target, int start, List<Integer> elem,
                         List<List<Integer>> result) {
        // 结束条件：最后节点了
        if (target == 0) {
            result.add(new ArrayList<>(elem));
            return;
        }

        // 结束条件：超出目标值
        if (target < 0) return;
        for (int i = start; i < nums.length; ++i) {
            if (nums[i] > target) break; // 剪枝叶：超出目标值
            // 选择
            elem.add(nums[i]);
            // 调用
            combSum(nums, target - nums[i], i, elem, result);
            // 撤销选择
            elem.remove(elem.size() - 1); // T: O(1)
        }
    }

}
