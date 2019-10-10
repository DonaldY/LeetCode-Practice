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
 *
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
}
