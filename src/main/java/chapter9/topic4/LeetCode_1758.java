package chapter9.topic4;

/**
 * @author donald
 * @date 2022/11/29
 */
public class LeetCode_1758 {

    // Time: O(n), Space: O(1), Faster: 94.22%
    public int minOperations(String s) {
        int n = s.length(), cnt = 0;

        for (int i = 0; i < n; i++) cnt += (s.charAt(i) - '0') ^ (i & 1);

        return Math.min(cnt, n - cnt);
    }
}
