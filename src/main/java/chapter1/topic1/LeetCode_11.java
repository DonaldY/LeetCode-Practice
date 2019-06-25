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
 * 1. 求每一个组合的面积
 * 2. DP
 */
public class LeetCode_11 {

    public static void main(String[] args) {

        LeetCode_11 leetCode = new LeetCode_11();
        System.out.println(leetCode.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    // Time: o(n^2) Space: o(1) faster: 17.95%
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

    // Time:o(n), Space:o(1), Faster: 94.74%
    public int maxWater(int [] height) {
        int max = 0;
        int i = 0, j = height.length - 1;

        while (i < j) {
            int cur = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, cur);
            if (height[i] < height[j]) ++i;
            else --j;
        }

        return max;
    }
}
