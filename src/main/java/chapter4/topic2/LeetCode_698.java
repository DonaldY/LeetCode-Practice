package chapter4.topic2;

import java.util.Arrays;

/**
 * @author donald
 * @date 2022/09/20
 *
 * 698. 划分为k个相等的子集
 *
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 *  
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 * 示例 2:
 *
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 *
 *
 * 思路： 没有思路时候，就是使用暴力法 回溯
 * 主要分两步：
 * 1. 求子集的和
 * 2. 每个子集划分成桶，找是否满足题意
 */
public class LeetCode_698 {

    // Faster: 22.28%
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (null == nums || nums.length == 0) return false;
        if (nums.length < k) return false;

        // 1. 求子集的和
        int sum = 0;
        for (int num : nums) sum += num;
        // 判断能否划分为 k 个子集
        if (sum % k != 0) return false;

        Arrays.sort(nums);
        int subSum = sum / k; // 子集的和

        boolean[] isVisited = new boolean[nums.length];
        // 2. 回溯
        return backtrack(nums, nums.length - 1, 0, subSum, k, isVisited);
    }

    private boolean backtrack(int[] nums, int idx, int bucket, int target, int k,
                              boolean[] isVisited) {

        if (k == 0) {  // 所有桶被装满了
            return true;
        }

        if (bucket == target) { // 当前桶装满了，装下一个桶
            return backtrack(nums, nums.length - 1, 0, target, k - 1, isVisited);
        }

        if (idx == -1) return false;

        for (int i = idx; i >= 0; i--) {
            if (isVisited[i]) continue;
            if (nums[i] + bucket > target) continue;

            isVisited[i] = true;
            if (backtrack(nums, i - 1, nums[i] + bucket, target, k, isVisited)) {
                return true;
            }
            isVisited[i] = false;
        }

        return false;
    }
}
