package chapter1.topic3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2022/08/22
 *
 * 只出现一次的数字
 *
 * 这个题目说的是，给你一个不为空的整数数组，这个数组中有一个整数只出现了一次，其它的整数都出现了三次，你要找出这个只出现一次的整数。
 * 注意，这个题目要求你的解法是线性时间复杂度以及常量空间复杂度。
 *
 * 比如说，给你的整数数组是：
 *
 * 3, 3, 2, 3, 2, 6, 2
 *
 * 在这个数组中，3 和 2 都出现了三次，而 6 只出现一次，因此你要返回 6。
 *
 *
 * 思路：
 * 1. 哈希表记录
 */
public class LeetCode_137 {

    // 方法一： 哈希表
    // Time: O(n), Space: O(n), Faster: 33.23%
    public int singleNumberHash(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            int cnt = map.getOrDefault(num, 0);
            map.put(num, cnt + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }
}
