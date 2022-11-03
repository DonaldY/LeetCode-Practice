package chapter9.topic2;

/**
 * @author donald
 * @date 2022/11/03
 *
 * 1668. 最大重复子字符串
 */
public class LeetCode_1668 {

    // Time: O(n*m), Space: O(1), Faster: 100%
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(), m = word.length(), ans = 0;
        int[] f = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            if (i - m < 0) continue;
            if (sequence.substring(i - m, i).equals(word)) f[i] = f[i - m] + 1;
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
