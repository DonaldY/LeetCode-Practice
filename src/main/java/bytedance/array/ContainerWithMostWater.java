package bytedance.array;

/**
 * @author donald
 * @date 2020/11/18
 *
 * LeetCode 11
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 * 思路：
 * 矩阵的乘积
 * 1. 穷举
 * 2. 剪枝 - 双指针
 *    先以距离为最大开始，然后移动，查找更高的高度，比大小
 *    移动高度小的指针
 */
public class ContainerWithMostWater {

    // 穷举  Time: 0(n^2), Space: 0(1), Faster:
    public int maxArea(int[] height) {

        int maxArea = 0;

        for (int i = 0; i < height.length; ++i) {

            for (int j = i + 1; j < height.length; ++j) {

                int tmpArea = Math.min(height[i], height[j]) * (j - i);

                if (tmpArea > maxArea) maxArea = tmpArea;
            }
        }

        return maxArea;
    }

    // 双指针 Time: 0(n), Space: 0(1), Faster: 92.87%
    public int maxWater(int[] height) {

        int i = 0, j = height.length - 1, maxArea = 0;

        while (i < j) {

            int tmpArea = Math.min(height[i], height[j]) * (j - i);
            if (tmpArea > maxArea) {
                maxArea = tmpArea;
            }
            if (height[i] < height[j]) ++i;
            else --j;
        }

        return maxArea;
    }
}
