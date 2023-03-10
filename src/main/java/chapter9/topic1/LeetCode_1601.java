package chapter9.topic1;

/**
 * @author donald
 * @date 2022/02/28
 */
public class LeetCode_1601 {

    // Faster: 56.70%
    int[][] rs;
    public int maximumRequests(int n, int[][] requests) {
        rs = requests;
        int m = rs.length, ans = 0;
        for (int i = 0; i < (1 << m); i++) {
            int cnt = getCnt(i);
            if (cnt <= ans) continue;
            if (check(i)) ans = cnt;
        }
        return ans;
    }
    boolean check(int s) {
        int[] cnt = new int[20];
        int sum = 0;
        for (int i = 0; i < 16; i++) {
            if (((s >> i) & 1) == 1) {
                int a = rs[i][0], b = rs[i][1];
                if (++cnt[a] == 1) sum++;
                if (--cnt[b] == 0) sum--;
            }
        }
        return sum == 0;
    }
    int getCnt(int s) {
        int ans = 0;
        for (int i = s; i > 0; i -= (i & -i)) ans++;
        return ans;
    }
}
