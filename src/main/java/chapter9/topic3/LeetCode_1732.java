package chapter9.topic3;

/**
 * @author donald
 * @date 2022/11/19
 */
public class LeetCode_1732 {
    // Time: O(n), Space: O(1), Faster: 100.00%
    public int largestAltitude(int[] gain) {
        int ans = 0, cur = 0;
        for (int i = 0; i < gain.length; ++i) {
            cur += gain[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
