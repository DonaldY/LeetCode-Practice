package chapter10.topic1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2023/01/17
 */
public class LeetCode_1814 {
    // 暴力法： 哈希表
    // Time: O(n×logC), Space: O(n), Faster: 90.99%
    public int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        int res = 0;
        Map<Integer, Integer> h = new HashMap<>();
        for (int i : nums) {
            int temp = i, j = 0;
            while (temp > 0) {
                j = j * 10 + temp % 10;
                temp /= 10;
            }
            res = (res + h.getOrDefault(i - j, 0)) % MOD;
            h.put(i - j, h.getOrDefault(i - j, 0) + 1);
        }
        return res;
    }
}
