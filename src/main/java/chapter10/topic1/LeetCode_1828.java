package chapter10.topic1;

/**
 * @author donald
 * @date 2023/01/24
 */
public class LeetCode_1828 {

    // 暴力法： 枚举每个点是否在每个圆中
    // Time: O(mn), Space: O(1), Faster: 95.24%
    public int[] countPoints(int[][] points, int[][] queries) {
        int m = points.length, n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int cx = queries[i][0], cy = queries[i][1], cr = queries[i][2];
            for (int j = 0; j < m; ++j) {
                int px = points[j][0], py = points[j][1];
                if ((cx - px) * (cx - px) + (cy - py) * (cy - py) <= cr * cr) {
                    ++ans[i];
                }
            }
        }
        return ans;
    }
}
