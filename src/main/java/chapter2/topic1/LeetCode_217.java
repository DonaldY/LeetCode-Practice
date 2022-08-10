package chapter2.topic1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author donald
 * @date 2022/08/10
 *
 * 数组中是否包含重复元素
 *
 * 这个题目说的是，给你一个整数数组，你要判断数组中是否包含重复元素。如果数组中包含重复元素就返回 true，否则返回 false。
 *
 * 比如说，给你的数组是：
 *
 * 1, 2, 4, 2
 *
 * 这个数组中有两个 2，包含重复元素，返回 true。
 *
 * 再比如说，给你的数组是：
 *
 * 4, 1, 2
 *
 * 在这个数组中，每个数字都只出现了一次，不存在重复元素，因此返回 false。
 *
 * 思路：
 * 1. 暴力法： 2层for
 * 2. 排序：再比较
 * 3. 哈希表： hashset
 */
public class LeetCode_217 {
    // 方法一： 暴力法
    // Time: O(n ^ 2), Space: O(1), Faster: 5.46%
    public boolean containsDuplicate(int[] nums) {
        if (null == nums || nums.length == 0) return false;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    // 方法二： 排序
    // Time: O(nlog(n)), Space: O(1), Faster: 42.95%
    public boolean containsDuplicateSort(int[] nums) {
        if (null == nums || nums.length == 0) return false;
        Arrays.sort(nums);
        for (int i = 0, j = 1; j < nums.length; ++i, ++j) {
            if (nums[i] == nums[j]) return true;
        }
        return false;
    }

    // 方法三： 哈希表
    // Time: O(n), Space: O(n), Faster: 74.14%
    public boolean containsDuplicateHash(int[] nums) {
        if (null == nums || nums.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            else set.add(num);
        }
        return false;
    }
}
