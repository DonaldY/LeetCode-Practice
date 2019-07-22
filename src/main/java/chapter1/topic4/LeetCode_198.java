package chapter1.topic4;

/**
 * 198. House Robber
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 *
 * 题意： 多个位置间隔不小1的数，求和的最大值
 *
 * 思路：
 * 1. 两层循环查找
 * 2. 动态规划
 *
 * 定义：状态 d(i) 表示抢 0～i 号房子的最大获利
 *
 * 状态转移方程： d(i) = max(d(i-1), d(i-2) + nums(i))
 * d(0) = nums(0)
 * d(1) = max(num(0), nums(1))
 */
public class LeetCode_198 {

    public static void main(String[] args) {

        LeetCode_198 leetCode_198 = new LeetCode_198();

        System.out.println(leetCode_198.rob(new int[] {1, 2, 3, 1}));
    }

    // Time: o(n), Space: o(n), Faster: 100.00%
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int [] d = new int[nums.length];

        d[0] = nums[0];

        if (nums.length == 1) return d[0];

        d[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; ++i) {

            d[i] = Math.max(d[i - 2] + nums[i], d[i - 1]);
        }

        return d[nums.length - 1];
    }

    // Time: o(n), Space: o(1), Faster: 100.00%
    public int rob2(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int d1 = 0, d2 = 0;

        d1 = nums[0];

        if (nums.length == 1) return d1;

        d2 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; ++i) {

            int temp = d2;

            d2 = Math.max(d1 + nums[i], d2);

            d1 = temp;
        }

        return d2;
    }


}
