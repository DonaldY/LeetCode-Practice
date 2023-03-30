package chapter9.topic1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author donald
 * @date 2023/03/30
 */
public class LeetCode_1637 {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int mx = 0;
        for (int i = 1; i < points.length; i++) {
            mx = Math.max(points[i][0] - points[i - 1][0], mx);
        }
        return mx;
    }
}
