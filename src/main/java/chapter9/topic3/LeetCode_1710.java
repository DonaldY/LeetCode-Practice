package chapter9.topic3;

import java.util.Arrays;

/**
 * @author donald
 * @date 2022/11/15
 */
public class LeetCode_1710 {

    public int maximumUnits(int[][] bs, int k) {
        int n = bs.length, ans = 0;
        Arrays.sort(bs, (a, b)->b[1]-a[1]);
        for (int i = 0, cnt = 0; i < n && cnt < k; i++) {
            int a = bs[i][0], b = bs[i][1], c = Math.min(a, k - cnt);
            cnt += c; ans += c * b;
        }
        return ans;
    }
}
