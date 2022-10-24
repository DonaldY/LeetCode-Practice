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
}
