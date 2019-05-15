package chapter1.topic1;

/**
 * 11. Container With Most Water
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49 = 7 * 7
 *
 * 题意：求矩形的面积，得最大的面
 *
 * 思路：
 * 1.
 */
public class LeetCode_11 {

    public int maxArea(int[] height) {

        int max = 0;

        for (int i = 0; i < height.length; ++i) {

            for (int j = i + 1; j < height.length; ++j) {

                int area = (j - i) * Math.min(height[i], height[j]);

                if (area > max) max = area;
            }
        }

        return max;
    }
}
