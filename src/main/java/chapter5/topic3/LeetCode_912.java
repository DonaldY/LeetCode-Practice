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
}
