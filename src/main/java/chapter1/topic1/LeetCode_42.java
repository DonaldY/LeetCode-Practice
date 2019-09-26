package chapter1.topic1;

/**
 * 42. Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
 * 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * 题意：接雨水
 *
 * 思路：
 * 1. 先找到最大值，
 *    从左开始计算, 若比当前最大值小，则减，直至到最大值
 *    从右开始计算, 若比当前最大值小，则减，直至到最大值
 */
public class LeetCode_42 {

    // Time: o(n), Space: o(1), Faster: 98.20%
    public int trap(int[] height) {

        if (height == null || height.length == 0) return 0;

        int index = 0, sum = 0;

        for (int i = 1; i < height.length; ++i) {

            if (height[i] > height[index]) index = i;
        }

        for (int i = 0, curHeight = 0; i < index; ++i) {

            if (curHeight < height[i]) curHeight = height[i];
            else sum += curHeight - height[i];
        }

        for (int i = height.length - 1, curHeight = 0; i > index; --i) {

            if (curHeight < height[i]) curHeight = height[i];
            else sum += curHeight - height[i];
        }

        return sum;
    }
}
