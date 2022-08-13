package chapter5.topic3;

import java.util.Arrays;

/**
 * @author donald
 * @date 2022/08/13
 *
 * 排序数组
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 *
 *
 */
public class LeetCode_912 {

    // Faster: 98.95%
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    // 计数排序
    // Time: O(n + k), Space: O(n + k), Faster: 99.97%
    public int[] sortArrayCounting(int[] nums) {
        // 1. 找最大值和最小值
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 2. 定义计数数组并统计
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            ++counts[num - min]; // 落到数组上
        }
        // 3. 遍历输出结果
        int[] result = new int[nums.length];
        for (int i = 0, j = 0; i < max - min + 1; ++i) {
            while (counts[i]-- > 0) {
                result[j++] = i + min;
            }
        }
        return result;
    }
}
