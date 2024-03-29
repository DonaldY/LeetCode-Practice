package chapter3.topic1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 *
 * 题意： 找到数组中没有出现过的数字 [1, n], n is size of array.
 * 希望 Time:O(n)
 *
 * 思路：
 * 1. 用数组保存已经存在的数字
 * 2. 复用原数组
 *    1. 因为数组的数字全为正，那么把出现过的数字标记为其相反数
 *
 *    0  1  2  3  4  5  6  7
 *    4  3  2  7  8  2  3  1
 *            -7
 *    有4这个元素，对应的 num[3] = -7
 *    之后计算，用绝对值
 */
public class LeetCode_448 {

    // Time: O(n), Space: O(n), Faster: 99.99%
    public List<Integer> findDisappearedNumbers(int[] nums) {

        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<Integer> result = new ArrayList<>(nums.length);

        int [] arr = new int[nums.length + 1];

        for (int i = 0; i < nums.length; ++i) {

            arr[nums[i]] = 1;
        }

        for (int i = 1; i <= nums.length; ++i) {

            if (arr[i] == 0) result.add(i);
        }

        return result;
    }

    // Time: O(n), Space: O(1), Faster: 78.62%
    public List<Integer> findDisappearedNumbersO1(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) nums[idx] = -nums[idx];
        }
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] > 0)
                result.add(i+1);
        return result;
    }

}
