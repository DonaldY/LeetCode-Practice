package chapter12.topic3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2023/02/16
 */
public class LeetCode_2341 {

    // Time: O(n), Space: O(n), Faster: 54.37%
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Boolean> cnt = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, !cnt.getOrDefault(num, false));
            if (!cnt.get(num)) {
                res++;
            }
        }
        return new int[]{res, nums.length - 2 * res};
    }
}
