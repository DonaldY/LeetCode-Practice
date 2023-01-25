package chapter9.topic1;

/**
 * @author donald
 * @date 2023/01/26
 */
public class LeetCode_1663 {
    // Time: O(n), Space: O(1)
    public String getSmallestString(int n, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int lower = Math.max(1, k - (n - i) * 26);
            k -= lower;
            ans.append((char) ('a' + lower - 1));
        }
        return ans.toString();
    }
}
