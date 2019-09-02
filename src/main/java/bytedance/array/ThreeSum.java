package bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 数组与排序 - 三数之和
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 题意： 求三数相加为零的数组
 *
 * 思路： 查看LeetCode15
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length == 0) return Collections.emptyList();

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int k = nums.length - 1; k >= 2; --k) {

            int i = 0, j = k - 1;

            int target = -nums[k];

            while (i < j) {

                if (nums[i] + nums[j] == target) {

                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // 剔除两个移动指针重复元素
                    while (i < j && nums[i] == nums[i + 1]) ++i;
                    while (i < j && nums[j] == nums[j - 1]) --j;

                    ++i;
                    --j;

                } else if (nums[i] + nums[j] > target) {

                    --j;
                } else if (nums[i] + nums[j] < target) {

                    ++i;
                }
            }

            // k 代表的数去重
            while (k >= 2 && nums[k] == nums[k - 1]) --k;
        }

        return result;
    }
}
