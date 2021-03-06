package chapter3.topic3;

/**
 * @author donald
 * @date 2021/03/06
 *
 * LeetCode 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 *
 * ```
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * ```
 *
 * 注意: 输入数组的长度不会超过 10000。
 *
 *
 * 题意： 找到第一个比当前数大的数，数组可循环
 *
 *
 * 思路：
 * 1. 暴力解法，模拟循环
 */
public class LeetCode_503 {

    // 1. 暴力法
    // Time: O(n ^ 2), Space: O(n), Faster: 5.20%
    public int[] nextGreaterElements(int[] nums) {

        if (null == nums || nums.length == 0) return new int[0];
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int nextMax = nums[i];
            for (int j = (i + 1) % nums.length, cnt = 0; cnt < nums.length; ++cnt) {
                if (nums[j] > nextMax) {
                    nextMax = nums[j];
                    break;
                }
                j = (j + 1) % nums.length;
            }
            result[i] = nextMax == nums[i] ? -1 : nextMax;
        }
        return result;
    }
}
