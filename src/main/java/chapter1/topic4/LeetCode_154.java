package chapter1.topic4;

/**
 * @author donald
 * @date 2021/04/09
 *
 * 154. 寻找旋转排序数组中的最小值 II
 *
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * ```
 * 示例 1：
 *
 * 输入：nums = [1,3,5]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 * ```
 *
 * 题意： 找最小数
 *
 *
 * 思路：
 * 1. 直接遍历查找
 * 2. 二分查找
 */
public class LeetCode_154 {

    // Time: O(log(n)), Space: O(1), Faster: 100.00%
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }
}
