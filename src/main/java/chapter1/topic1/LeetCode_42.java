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
 *
 * 2. 从左到右扫描，再从右到左扫描，min(leftMax, rightMax) - originalNum
 *    原数据： 0 2 0 4 0 1 2
 *    左边扫： 0 2 2 4 4 4 4 取最大值
 *    右边扫： 4 4 4 4 2 2 2 取最大值
 *    最小减： 0 0 2 0 2 1 0 min(leftMax, rightMax) - originalNum
 *
 * 3. 简化 2， 空间复杂度
 *    记录左右两边指针，向中间扫
 *    公式： min(leftMax, rightMax) - originalNum
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

    // Time: O(n), Space: O(n)
    public int waterCanBeTrap(int[] height) {

        if (height == null || height.length == 0) return 0;

        int n = height.length, leftMax = -1, rightMax = -1, water = 0;

        int[] d = new int[n];

        for (int i = 0; i < n; ++i) {

            leftMax = Math.max(leftMax, height[i]);
            d[i] = leftMax;
        }

        for (int i = n-1; i >= 0; --i) {

            rightMax = Math.max(rightMax, height[i]);
            d[i] = Math.min(d[i], rightMax);
            water += (d[i] - height[i]);
        }

        return water;
    }

    // Time: O(n), Space: O(1), Faster: 98.20%
    public int waterCanBeTrapO1(int[] height) {

        if (height == null || height.length == 0) return 0;

        int leftMax = -1, rightMax = -1, water = 0;

        int i = 0, j = height.length - 1;

        while (i <= j) {

            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) water += (leftMax - height[i++]);
            else water += (rightMax - height[j--]);
        }

        return water;
    }
}
