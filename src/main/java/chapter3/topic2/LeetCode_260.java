package chapter3.topic2;

import java.util.HashMap;
import java.util.Map;

/**
 * 260. Single Number III
 *
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *
 * 题意： 给一个数组，里面有两个数字只出现一次，其他均出现两次，找到只出现过一次的数字
 *
 * 思路：
 * 1. 统计所有数的出现次数，然后过滤只有1个次数
 * 2. 位运算。（ 1 ^ 1 = 0 异或 ）
 *    分组 （为了拆分 1 ^ 8）
 *    1. 先遍历一遍都异或，找出值
 *    2. 再遍历一遍，
 *
 */
public class LeetCode_260 {

    // Time: O(n), Space: O(n), Faster: 36.55%
    public int[] singleNumber(int[] nums) {

        if (nums == null || nums.length < 2) return new int[0];

        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, 2);
            } else {
                map.put(num, 1);
            }
        }

        int [] result = new int[2];

        int i = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() == 1) result[i++] = entry.getKey();

            if (i >= 2) return result;
        }

        return result;
    }

    // Time: O(n), Space: O(1), Faster: 99.62%
    public int[] singleNumberXOR(int [] nums) {
        int xor = 0, mask = 1;
        for (int num : nums) xor ^= num;
        while ((xor & mask) == 0) mask <<= 1;
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & mask) == 0) x ^= num;
            else y ^= num;
        }
        return new int[]{x, y};
    }

    // Time: O(n), Space: O(1), Faster: 99.62%
    public int[] singleNumberXOR2(int [] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;
        int mask = xor & (-xor);
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & mask) == 0) x ^= num;
            else y ^= num;
        }
        return new int[]{x, y};
    }
}
