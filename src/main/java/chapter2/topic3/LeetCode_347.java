package chapter2.topic3;

import java.util.*;

/**
 * @author donald
 * @date 2020/5/7
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 *
 * 题意：
 * 前K个高频数字，给你一个不为空的整数数组，你要返回前 K 个出现频率最高的数字
 *
 * 思路：
 * 1. 暴力法，hash保存，最大堆
 * 2. 快速选择法
 */
public class LeetCode_347 {

    // Time: O(n * log(n)), Space: (n), Faster: 70.80%
    public int[] topKFrequent(int[] nums, int k) {

        if (null == nums || nums.length == 0) {

            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {

            int freq = map.getOrDefault(num, 0);
            map.put(num, freq + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            queue.add(entry);

            if (queue.size() > k) {

                queue.poll();
            }
        }

        int [] result = new int[k];

        for (int i = 0; i < k; ++i) {

            result[i] = queue.poll().getKey();
        }

        return result;
    }
}
