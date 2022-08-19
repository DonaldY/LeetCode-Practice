package chapter4.topic3;

/**
 * @author donald
 * @date 2022/08/19
 *
 * 这个题目说的是，给你一个整数数组，你要找到这个数组的平衡点并返回它的下标。
 *
 * 数组的平衡点定义为这样一个元素，它左边子数组的元素之和等于它右边子数组的元素之和。如果数组中存在多个平衡点，则返回最左侧平衡点的下标；而如果数组中不存在平衡点，则返回 -1。
 *
 * 比如说，给你的数组是：
 *
 * 1, 4, 2, 8, 1, 6
 *
 * 这个数组的平衡点是数字 8，它左边的元素之和与右边的元素之和都等于 7。因此，你要返回数字 8 对应的下标，也就是 3。
 *
 * 再比如说，给你的数组是：
 *
 * 1, -3, 3
 *
 * 这个数组的平衡点是数字 1。1 左边没有元素，因此把求和结果看作 0。1 右边的两个元素相加也等于 0。因此，你要返回数字 1 对应的下标，也就是 0。
 *
 *
 * 思路：
 * 1. 两个数组： 1个求左边和、1个求右边个
 */
public class LeetCode_724 {

    // 方法一：
    // Time: O(n), Space: O(n), Faster: 67.66%
    public int pivotIndex(int[] nums) {
        if (null == nums || nums.length == 0) return -1;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0, sum = 0; i < nums.length; ++i) {
            left[i] = sum;
            sum += nums[i];
        }
        for (int i = nums.length - 1, sum = 0; i >= 0; --i) {
            right[i] = sum;
            sum += nums[i];
        }
        for (int i = 0, sum = 0; i < nums.length; ++i) {
            if (left[i] == right[i]) return i;
        }
        return -1;
    }
}
