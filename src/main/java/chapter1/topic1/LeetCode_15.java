package chapter1.topic1;

import java.util.*;

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
 *    需要解决的问题：
 *    1. 选三个点的问题
 *    2. 三个点的组合不能有重复
 *
 *    解决：
 *    排序后
 *    1. 主节点：从后往前选， 其他从节点从两边开始选举
 *    2. 每完成一组后，从节点 i j 自动跳过相似的节点
 */
public class LeetCode_15 {

    public List<List<Integer>> threeSum(int[] nums) {

        return Collections.emptyList();
    }

    // Time: O(n^3), Space: O(n), Faster: 超时
    public List<List<Integer>> threeNumSumToZeroOn3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();  // 用于去重
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i+1; j < nums.length; ++j) {
                for (int k = j+1; k < nums.length; ++k)
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> elem = Arrays.asList(nums[i], nums[j], nums[k]);
                        if (set.contains(elem)) continue;
                        set.add(elem);
                        result.add(elem);
                    }
            }
        }

        return result;
    }

    // Time: o(n ^ 2), Space: o(1), Faster: 99.78%
    public List<List<Integer>> threeNumSumToZeroOn2(int [] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = nums.length - 1; k >= 2; --k) {
            if (nums[k] < 0) break;  // 剪枝
            int target = -nums[k], i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (i < j && nums[i + 1] == nums[i]) ++i; // 跳过相同的数
                    while (i < j && nums[j - 1] == nums[j]) --j; // 跳过相同的数
                    ++i; --j;
                } else if (nums[i] + nums[j] < target) {
                    ++i;
                } else {
                    --j;
                }
            }
            while (k >= 2 && nums[k - 1] == nums[k]) --k; // 跳过相同的数
        }

        return result;
    }
}
