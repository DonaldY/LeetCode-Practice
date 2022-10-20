package chapter1.topic1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author donald
 * @date 2022/10/20
 *
 * 思路： 类似上一题 39
 * 回溯 + 去重
 */
public class LeetCode_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // 1. 排序
        Arrays.sort(candidates);

        // 2. 递归 回溯
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
            combSum(nums, target - nums[i], i + 1, elem, result);
            // 撤销选择
            elem.remove(elem.size() - 1); // T: O(1)
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) ++i;  // 重点：去掉重复的数
        }
    }
}
