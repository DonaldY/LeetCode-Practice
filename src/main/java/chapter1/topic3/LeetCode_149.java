package chapter1.topic3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2021/03/11
 */
public class LeetCode_149 {

    // Time: O(n^3), Space: O(1)
    public int maxPointsBruteForce(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int max = 1;
        for (int i = 0; i < points.length; ++i) {
            long ax = points[i][0], ay = points[i][1];
            int samep = 0;
            for (int j = i+1; j < points.length; ++j) {
                long bx = points[j][0], by = points[j][1];
                if (ax == bx && ay == by) {
                    ++samep;
                    continue;
                }
                int cur = 2;
                for (int k = j+1; k < points.length; ++k) {
                    long cx = points[k][0], cy = points[k][1];
                    if ((by-ay) * (cx-ax) - (bx-ax) * (cy-ay) == 0)
                        ++cur;
                }
                max = Math.max(max, cur + samep);
            }
            max = Math.max(max, samep + 1);
        }
        return max;
    }

    private long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    // Time: O(n^2), Space: O(n)
    public int maxPointsHashMap(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int max = 1;
        for (int i = 0; i < points.length; ++i) {
            Map<Long, Integer> map = new HashMap<>();
            long ax = points[i][0], ay = points[i][1];
            int samep = 0;
            int lineMax = 0;
            for (int j = i+1; j < points.length; ++j) {
                long bx = points[j][0], by = points[j][1];
                long x = bx - ax, y = by - ay;
                if (x == 0 && y == 0) {
                    ++samep;
                    continue;
                }
                long g = gcd(x, y);
                x /= g;
                y /= g;
                long key = (x << 32) + y;
                int count = map.getOrDefault(key, 0);
                ++count;
                map.put(key, count);
                lineMax = Math.max(lineMax, count);
            }
            max = Math.max(max, lineMax + samep + 1);
        }
        return max;
    }
}
