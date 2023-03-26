package chapter12.topic4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author donald
 * @date 2023/03/26
 */
public class LeetCode_2395 {

    // 思路：哈希表
    // Time: O(n), Space: O(n), Faster: 100%
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n - 1; ++i) {
            int sum = nums[i] + nums[i + 1];
            if (!seen.add(sum)) {
                return true;
            }
        }
        return false;
    }
}
