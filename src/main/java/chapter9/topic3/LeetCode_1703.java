package chapter9.topic3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2022/12/18
 */
public class LeetCode_1703 {

    // 贪心：
    // Time: O(n), Space: O(n), Faster:
    public int minMoves(int[] nums, int k) {
        List<Integer> g = new ArrayList<>();
        List<Integer> preSum = new ArrayList<>();
        preSum.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                g.add(i - g.size());
                preSum.add(preSum.get(preSum.size() - 1) + g.get(g.size() - 1));
            }
        }
        int m = g.size(), res = Integer.MAX_VALUE;
        for (int i = 0; i <= m - k; i++) {
            int mid = i + k / 2;
            int r = g.get(mid);
            res = Math.min(res, (1 - k % 2) * r + (preSum.get(i + k) - preSum.get(mid + 1)) - (preSum.get(mid) - preSum.get(i)));
        }
        return res;
    }
}
