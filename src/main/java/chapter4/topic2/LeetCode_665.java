package chapter4.topic2;

/**
 * @author donald
 * @date 2022/08/19
 *
 * 非减数组
 *
 * 这个题目说的是，给你一个整数数组，在最多允许修改数组中一个元素的情况下，你要判断是否可以将这个数组变成非减数组。
 *
 * 非减数组的特征是，对于数组中任意相邻的两个元素，左边的元素一定小于等于右边的元素。
 *
 * 比如说，给你的数组为：
 *
 * 4, 3, 4
 *
 * 你只需要把第一个 4 修改成小于等于 3 的数字，就可以把这个数组变成非减数组，因此返回 true。
 *
 * 再比如说，给你的数组为：
 *
 * 4, 3, 4, 1, 6
 *
 * 对于这个数组，你至少需要修改两个元素，才能将它变成非减数组，因此返回 false。
 *
 *
 *
 */
public class LeetCode_665 {

    // Time: O(n), Space: O(1), Faster:
    public boolean checkPossibility(int[] nums) {
        if (null == nums || nums.length == 0) return true;

        int flag = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                if (flag == 1) return false;
                flag = 1;
            }
        }
        return true;
    }
}
