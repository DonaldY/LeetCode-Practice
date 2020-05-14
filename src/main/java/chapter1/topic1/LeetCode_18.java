package chapter1.topic1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author donald
 * @date 2020/5/14
 *
 * 18. 4Sum
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c,
 * and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 题意：
 * 给你一个整数数组和一个目标值，你要找到数组中四个数相加等于目标值的所有可能组合。
 * 返回的答案里，每个组合都是唯一的，不能重复
 *
 * 思路：
 * 1. 暴力法： O(n ^ 4)
 *    1. 全排列
 *    2. 找到求和等于target所有组合
 *    3. 通过hash去重
 *
 * 2. 双指针
 *    需要解决的问题：
 *    1. 选四个点的问题
 *    2. 四个点的组合不能有重复
 *
 *    解决：
 *    排序后
 *    1. 主节点 k 和次节点 p：从后往前选， 其他从节点从两边开始选举
 *    2. 每完成一组后，从节点 i j 自动跳过相似的节点
 *
 *    -2 -1 0 0 1 2
 *
 */
public class LeetCode_18 {

    // Time: O(n ^ 3), Space: O(1), Faster:  61.27%
    public List<List<Integer>> fourSum(int[] nums, int target) {

        if (null == nums || nums.length < 4) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int k = nums.length - 1; k >=3; --k) {

            if (k != nums.length - 1 && nums[k] == nums[k + 1]) continue;

            for (int p = k - 1; p >= 2; --p) {

                if (p != k -1 && nums[p] == nums[p + 1]) {
                    continue;
                }

                int i = 0, j = p - 1;

                while (i < j) {

                    int sum = nums[k] + nums[p] + nums[i] + nums[j];

                    if (sum == target) {

                        result.add(Arrays.asList(nums[i], nums[j], nums[p], nums[k]));

                        while (i < j && nums[i+1] == nums[i]) ++i;
                        while (i < j && nums[j-1] == nums[j]) --j;
                        ++i; --j;
                    } else if (sum < target) ++i;
                    else --j;
                }
            }
        }

        return result;
    }

    // Time: O(n^3), Space: O(1), Faster: 90.26%
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);

        for (int p = nums.length-1; p >= 3; --p) {
            if (4*nums[p] < target) break;
            for (int k = p-1; k >= 2; --k) {
                if (3*nums[k]+nums[p] < target) break;
                int newTarget = target - nums[k] - nums[p];
                int i = 0, j = k-1;
                while (i < j) {
                    if (nums[i] + nums[j] == newTarget) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[p]));
                        while (i < j && nums[i+1] == nums[i]) ++i;
                        while (i < j && nums[j-1] == nums[j]) --j;
                        ++i; --j;
                    } else if (nums[i] + nums[j] < newTarget) {
                        ++i;
                    } else {
                        --j;
                    }
                }
                while (k >= 2 && nums[k-1] == nums[k]) --k;
            }
            while (p >= 3 && nums[p-1] == nums[p]) --p;
        }
        return result;
    }

}
