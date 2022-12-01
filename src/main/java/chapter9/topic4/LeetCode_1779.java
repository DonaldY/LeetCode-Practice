package chapter9.topic4;

/**
 * @author donald
 * @date 2022/12/01
 */
public class LeetCode_1779 {

    // Time: O(n), Space: O(1), Faster: 100%
    public int nearestValidPoint(int x, int y, int[][] points) {
        if (null == points) return -1;
        int ans = -1, min = Integer.MAX_VALUE;
        for (int i = 0 ; i < points.length; ++i) {
            if (points[i][0] == x) {
                int dist = Math.abs(y - points[i][1]);
                if (dist < min) {
                    min = dist;
                    ans = i;
                }
            } else if (points[i][1] == y) {
                int dist = Math.abs(x - points[i][0]);
                if (dist < min) {
                    min = dist;
                    ans = i;
                }
            }
        }
        return ans;
    }
}
