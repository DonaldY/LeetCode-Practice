package chapter1.topic2;

/**
 * 75. Sort Colors
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * 题意：
 * 相同颜色的放在一起，0 1 2 代表 红 白 蓝，排序按照这个排序
 *
 * 思路：
 * 1. 直接用库函数排序（升序）[但题目不允许]
 * 2. 模拟排序
 * 3. 遍历数组，统计个数，然后填充
 */
public class LeetCode_75 {

    // Time: o(n), Space: o(1), Faster: 100.00%
    public void sortColors(int[] nums) {

        if (nums == null || nums.length == 0) return;

        int redNum = 0, whiteNum = 0, blueNum = 0;

        for (int i = 0; i < nums.length; ++i) {

            if (nums[i] == 0) ++redNum;
            if (nums[i] == 1) ++whiteNum;
            if (nums[i] == 2) ++blueNum;
        }

        int index = 0;

        while (redNum-- > 0) {

            nums[index++] = 0;
        }

        while (whiteNum-- > 0) {

            nums[index++] = 1;
        }

        while (blueNum-- > 0) {

            nums[index++] = 2;
        }
    }
}
