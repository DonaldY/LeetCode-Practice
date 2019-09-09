package bytedance.array;

/**
 * 数组与排序 - 最长连续递增序列
 *
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 注意：数组长度不会超过10000。
 *
 * 题意: 找出最长连续子序列的长度
 *
 * 思路:
 * 1. 两层 for 循环
 * 2. 指针判断
 */
public class FindLengthOfLCIS {

    // Time: o(n ^ 2), Space: o(1)
    public int findLengthOfLCIS(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int result = 1;

        for (int i = 0; i < nums.length; ++i) {

            int len = 1;

            for (int j = i + 1; j < nums.length; ++j) {

                if (nums[j] <= nums[j - 1]) break;
                ++len;
            }

            if (len > result) result = len;
        }

        return result;
    }

    // Time: o(n), Space: o(1)
    public int findLengthOfLCIS2(int [] nums) {

        if (nums == null || nums.length == 0) return 0;

        int result = 1;

        int len = 1;

        for (int i = 1; i < nums.length; ++i) {

            if (nums[i] <= nums[i - 1]) {

                len = 1;
                continue;
            }

            ++len;

            result = Math.max(len, result);
        }

        return result;
    }
}
