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
 *
 * 暴力解法 -> 备忘录解法 -> 双指针解法
 * 1. 暴力解法： 两次循环
 * 2. 在暴力解法之上，把左右边的最值都存储起来
 * 3. 双指针解法：边走边计算
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

    // 双指针法： Time: O(n), Space: O(1), Faster: 98.20%
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

    // 暴力解法： Time: O(N ^ 2), Space: O(1), Faster: 12.92%
    public int trap1(int [] height) {

        int n = height.length, sum = 0;

        for (int i = 1; i < n - 1; ++i) {

            int leftMax = 0, rightMax = 0;
            // 找到右边最高的柱子
            for (int j = i; j < n; ++j) {
                rightMax = Math.max(rightMax, height[j]);
            }
            // 找到左边最高的柱子
            for (int j = i; j >= 0; --j) {
                leftMax = Math.max(leftMax, height[j]);
            }
            sum += Math.min(rightMax, leftMax) - height[i];
        }

        return sum;
    }

    // 备忘录解法： Time: O(N), Space: O(N), Faster: 99.94%
    public int trap2(int [] height) {

        int[] leftHeight = new int[height.length];
        int[] rightHeight = new int[height.length];

        leftHeight[0] = height[0];
        rightHeight[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length; ++i) {

            leftHeight[i] = Math.max(leftHeight[i - 1], height[i]);
        }

        for (int i = height.length - 2; i >= 0; --i) {

            rightHeight[i] = Math.max(height[i], rightHeight[i + 1]);
        }

        int n = height.length, sum = 0;

        for (int i = 1; i < n - 1; ++i) {

            sum += Math.min(leftHeight[i], rightHeight[i]) - height[i];
        }

        return sum;
    }
}
