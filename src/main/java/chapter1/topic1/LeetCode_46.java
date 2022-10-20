package chapter1.topic1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 46. Permutations
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 题意： 给一个数组（数组的数均唯一），求所有组合
 *
 * 思路：
 * 1. 递归计算: 每个字母交换
 * - 根据首字母全排序
 */
public class LeetCode_46 {

    public static void main(String[] args) {

        int [] arr = new int[] {1, 2, 3};

        System.out.println(new LeetCode_46().permute(arr).toString());

    }

    // Time: O(n*n!), Space: O(n), Faster: 80.69%
    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int num: nums) list.add(num);

        permuteRec(list, 0, result);
        return result;
    }

    private void permuteRec(List<Integer> list, int start, List<List<Integer>> result) {

        // 结束条件：最后节点了
        if (start == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 选择列表
        for (int i = start; i < list.size(); ++i) {
            Collections.swap(list, i , start);        // 选择
            permuteRec(list, start + 1, result); // 调用
            Collections.swap(list, start, i);         // 撤销选择
        }
    }

    // Time: O(n*n!), Space: O(n), Faster: 75.02%
    public List<List<Integer>> permuteN(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[] flag = new boolean[nums.length]; // 标记

        dfs(nums, new ArrayList<>(), result, flag);

        return result;
    }

    private void dfs(int[] nums, List<Integer> elem,
                     List<List<Integer>> result, boolean[] flag) {

        if (elem.size() == nums.length) {
            result.add(new ArrayList<>(elem));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (flag[i]) continue;
            // 标记
            flag[i] = true;
            elem.add(nums[i]);

            dfs(nums, elem, result, flag);

            // 撤回
            elem.remove(elem.size() - 1);
            flag[i] = false;
        }
    }

    // 排序 + 回溯： 2022.10.20
    // Time: O(n*n!), Space: O(n), Faster: 100.00%
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 1. 排序
        Arrays.sort(nums);

        // 2. 回溯
        boolean[] flag = new boolean[nums.length]; // 标记
        dfsMy(nums, new ArrayList<>(), result, flag);

        return result;
    }

    private void dfsMy(int[] nums, List<Integer> elem,
                     List<List<Integer>> result, boolean[] flag) {

        if (elem.size() == nums.length) {
            result.add(new ArrayList<>(elem));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (flag[i]) continue;
            // 标记
            flag[i] = true;
            elem.add(nums[i]);

            dfsMy(nums, elem, result, flag);

            // 撤回
            elem.remove(elem.size() - 1);
            flag[i] = false;

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) ++i;
        }
    }
}
