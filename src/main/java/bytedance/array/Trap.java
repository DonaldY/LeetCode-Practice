package bytedance.array;

/**
 * 数组与排序 - 接雨水
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 题意： 求可容纳多少水
 *
 * 思路：
 * 1. 观察
 *    I.  先找到最高点
 *    II. 在从左往右找，求值
 *    III.在从右往左找，求值
 */
public class Trap {

    public int trap(int[] height) {

        int result = 0;

        int maxIndex = 0, max = 0;

        for (int i = 0; i < height.length; ++i) {

            if (max < height[i]) {

                max = height[i];
                maxIndex = i;
            }
        }

        int currHeight = 0;
        for (int i = 0; i < maxIndex; ++i) {

            if (currHeight <= height[i]) currHeight = height[i];
            else result += currHeight - height[i];
        }

        currHeight = 0;
        for (int i = height.length - 1; i > maxIndex; --i) {

            if (currHeight <= height[i]) currHeight = height[i];
            else result += currHeight - height[i];
        }

        return result;
    }
}
