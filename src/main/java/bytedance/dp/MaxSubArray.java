package bytedance.dp;

/**
 * 动态规划或贪心 - 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 题意: 找到最连续子序列最大和
 *
 * 思路:
 * 1. 两层for循环
 * 2. DP
 *    如果前面累加的数 <= 0, 则对后面的数没有贡献
 *    1. 若前面的值累加 <= 0, 则下标从当前开始
 *    2. 判断每次求最大值
 */
public class MaxSubArray {

    // Time: o(n ^ 2), Space: o(1)
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; ++i) {

            int temp = nums[i];

            max = Math.max(max, temp);

            for (int j = i + 1; j < nums.length; ++j) {

                temp += nums[j];

                max = Math.max(max, temp);
            }
        }

        return max;
    }

    // Time: o(n), Space: o(1)
    public int maxSubOfArray(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int max = nums[0], temp = 0;

        for (int i = 0; i < nums.length; ++i) {

            temp += nums[i];

            if (temp < 0) {

                max = Math.max(max, temp);
                temp = 0;
                continue;
            }

            max = Math.max(max, temp);
        }

        return max;
    }

    // Time: o(n), Space: o(1)
    public int maxSubOfArray2(int [] nums) {

        int max = Integer.MIN_VALUE, cur = 0;

        for (int i = 0; i < nums.length; ++i) {
            cur = cur <= 0 ? nums[i] : (cur + nums[i]);
            max = Math.max(max, cur);
        }

        return max;
    }
}