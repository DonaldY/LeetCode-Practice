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
 * 2. 统计二进制位: 举个栗子 3 3 2 3 2 6 2
 *    统计每个位上 1 出现的个数, 则对应位就是： 3k => 0, 3k + 1 => 1
 *    数字 二进制
 *    3：   11            bit
 *    3：   11    3k   => 0
 *    2：   10    3k+1 => 1
 *    3：   11
 *    2:    10
 *    6:   110
 *    2:    10
 * 统计后： 173   => 取模 3  得 a: 110 = 6
 *
 * 3. 方法三： 方法二上的优化
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

    // 方法二： 统计二进制位
    // Time: O(n), Space: O(1), Faster: 90.17%
    public int singleNumberSum(int[] nums) {
        int result = 0;
        for (int bit = 0; bit < 32; ++bit) {
            int sum = 0;
            for (int num: nums) {
                sum += (num >> bit) & 1;
            }
            if (sum % 3 == 1) result |= (1 << bit);
        }
        return result;
    }

    // 方法三：
    // Time: O(n), Space: O(1)
    public int singleNumberBit(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int num: nums) {
            twos |= ones & num;
            ones ^= num;
            threes = ones & twos;
            ones -= threes; // ones &= ~threes;
            twos -= threes; // twos &= ~threes;
        }
        return ones;
    }
}
