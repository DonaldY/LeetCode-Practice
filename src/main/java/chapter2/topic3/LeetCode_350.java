package chapter2.topic3;

import java.util.*;

/**
 * 350. Intersection of Two Arrays II
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * 题意： 求两个数组的交集
 *
 * 思路：
 * 1. 用 HashMap 来存储一个数组的元素
 */
public class LeetCode_350 {

    // Time: O(n), Space: O(n), Faster: 92.85%
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0
                || nums2 == null || nums2.length == 0) return new int[]{};

        Map<Integer, Integer> map = new HashMap<>(nums1.length);

        List<Integer> list = new ArrayList<>(nums1.length);

        for (int value : nums1) {
            int tmp = map.getOrDefault(value, 0);
            map.put(value, ++tmp);
        }

        for (int value : nums2) {
            Integer tmp = map.get(value);
            if (tmp == null) continue;
            list.add(value);
            if (--tmp <= 0) map.remove(value);
            else map.put(value, tmp);
        }

        int [] result = new int[list.size()];

        for (int i = 0; i < list.size(); ++i) result[i] = list.get(i);

        return result;
    }
}
