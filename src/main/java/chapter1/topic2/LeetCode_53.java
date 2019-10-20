package chapter1.topic2;

import java.util.Arrays;

/**
 * 53. Maximum Subarray
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * 思路：
 * 1. 暴力求法，两层for循环
 * 2. 遍历一遍，负数 + 负数没有任何意义
 *    前面累加值为负数，则对后面没有正向的贡献， 所以可以直接舍弃前面这段子序列的和
 *
 */
public class LeetCode_53 {

    public static void main(String[] args) {

        LeetCode_53 leetCode = new LeetCode_53();

        // [-2,1,-3,4,-1,2,1,-5,4]
        System.out.println(Arrays.toString(leetCode.maxSumOfSubArray3(new int[]{4, -1, 2, 1, -5, 4})));
    }

    // Time: O(n ^ 2), Space: O(1), Faster: 5.05%
    public int maxSumOfSubArray2(int [] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int sum = nums[i];
            max = Math.max(max, sum);
            for(int j = i + 1; j < nums.length; ++j) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    // Time: O(n), Space: O(1), Faster: 95.05%
    public int maxSumOfSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, cur = 0;

        for (int i = 0; i < nums.length; ++i) {
            cur = cur <= 0 ? nums[i] : (cur + nums[i]);
            max = Math.max(max, cur);
        }

        return max;
    }

    // [4,-1,2,1,-5,4]
public int[] maxSumOfSubArray3(int [] nums) {
    if (nums == null || nums.length == 0) return new int[]{-1, -1};

    // 1. 更新最大值时，需记录开始下标
    int max = Integer.MIN_VALUE, start = 0 , end = 0, cur = 0;
    for (int i = 0, j = 0; i < nums.length; ++i) {
        if (cur <= 0) {
            cur = nums[i];
            j = i;
        } else {
            cur += nums[i];
        }

        if (cur > max) {
            max = cur;
            start = j;
            end = i;
        }
    }
    return new int[]{start, end};
}
}















