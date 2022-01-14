package chapter4.topic3;

/**
 * @author donald
 * @date 2022/01/13
 *
 * 747. 至少是其他数字两倍的最大数
 *
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 *
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 *
 * 示例 1：
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 *
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 *
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 * 解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
 *
 *
 * 题意： 找数
 *
 * 思路：
 * 1. 暴力法： 遍历2次
 * 2. 一次遍历： 只需存最大值和次最大值，比较这两个值即可
 */
public class LeetCode_747 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public int dominantIndex(int[] nums) {

        if (null == nums || nums.length == 0) return -1;

        int max = 0;
        for (int i = 1; i < nums.length; ++i) {

            if (nums[max] < nums[i]) max = i;
        }

        for (int i = 0; i < nums.length; ++i) {

            if (i == max) continue;

            if (nums[i] != 0 && nums[i] * 2 > nums[max]) return -1;
        }

        return max;
    }

    // Time: O(n), Space: O(1), Faster: 100.00%
    public int dominantIndex2(int[] nums) {
        int m1 = -1, m2 = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > m1) {
                m2 = m1;
                m1 = nums[i];
                index = i;
            } else if (nums[i] > m2) {
                m2 = nums[i];
            }
        }
        return m1 >= m2 * 2 ? index : -1;
    }
}
