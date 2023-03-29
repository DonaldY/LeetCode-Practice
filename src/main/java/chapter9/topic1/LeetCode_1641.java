package chapter9.topic1;

import java.util.Arrays;

/**
 * @author donald
 * @date 2023/03/29
 */
public class LeetCode_1641 {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return Arrays.stream(dp).sum();
    }
}
