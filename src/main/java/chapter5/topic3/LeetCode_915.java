package chapter5.topic3;

import java.util.Arrays;

/**
 * @author donald
 * @date 2022/10/24
 *
 *
 * 思路：
 * 1. 开 2个 数组： 左边最大数组、右边最小数组
 *    栗子： 5 0 3 8 6
 *    left: 0 0 3 6 6
 *   right: 5 5 5 8 8
 *                ^
 *                |
 *               找到
 *
 * 2. 遍历一次：
 */
public class LeetCode_915 {

    public static void main(String[] args) {

        LeetCode_915 leetCode_915 = new LeetCode_915();
        leetCode_915.partitionDisjoint(new int[] {1,1,1,0,6,12});
    }

    // 方法一： 开数组
    // Time: O(n), Space: O(n), Faster: 30.77%
    public int partitionDisjoint(int[] nums) {
        if (null == nums || nums.length == 0) return -1;
        int n = nums.length;
        int[] minArr = new int[n]; // 从右到左: 最小
        int[] maxArr = new int[n]; // 从左到右: 最大
        minArr[n - 1] = nums[n - 1];
        maxArr[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            minArr[n - i - 1] = Math.min(minArr[n - i], nums[n - i - 1]);
            maxArr[i] = Math.max(nums[i], maxArr[i - 1]);
        }
        for (int i = 1; i < n; ++i) {
            if (minArr[i] >= maxArr[i - 1]) return i;
        }
        return -1;
    }

    // 方法二： 遍历一次
    // Time: O(n), Space: O(1), Faster: 92.81%
    public int partitionDisjoint2(int[] nums) {
        // 记左区间的最大值为leftMax
        int left = 0, leftMax = nums[0], rightMax = leftMax;
        for (int i = 1; i < nums.length; i++) {
            if (leftMax > nums[i]) { // 如果数字nums[i]要小于leftMax那么很明显左区间是要往右移到i的
                left = i;
                leftMax = rightMax;
            } else { // 如果数字nums[i]大于等于leftMax，那么左区间暂时不要往右移到i，
                     // 因为后续可能会遇到小于leftMax的数字，所以暂时要将其最大值记录下来，记为rightMax，
                     // 后续再遇到小于leftMax的数字时，将leftMax 置位rightMax
                rightMax = Math.max(rightMax, nums[i]);
            }
        }
        return left + 1;
    }
}
