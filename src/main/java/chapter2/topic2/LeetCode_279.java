package chapter2.topic2;

/**
 * @author donald
 * @date 2020/5/1
 *
 * 279. Perfect Squares
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 */
public class LeetCode_279 {

    // Time: O(n ^ 3/2), Space: O(n)
    public int numSquaresDP(int n) {
        int[] d = new int[n+1];
        d[0] = 0;
        for (int i = 1; i <= n; ++i) {
            d[i] = i;
            for (int j = 1; j*j <= i; ++j)
                d[i] = Math.min(d[i], d[i - j*j] + 1);
        }
        return d[n];
    }
}
