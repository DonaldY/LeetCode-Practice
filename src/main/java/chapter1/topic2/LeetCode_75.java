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
 * 4. 双指针交换
 * 5. 3次遍历交换
 */
public class LeetCode_75 {

    // 方法三：统计
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

    // 方法四：双指针交换
    // Time: O(n), Space: O(1), Faster: 100.00%
    public void sortThreeColorsSwap(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0, mid = 0, right = nums.length - 1;
        while (mid <= right) {
            // 遇到0 就交换，放最左边
            if (nums[mid] == 0) swap(nums, left++, mid++);
            // 遇到1 增加指针
            else if (nums[mid] == 1) ++mid;
            // 遇到2 就交换，放最右边
            else swap(nums, mid, right--);
        }
    }

    private void swap(int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //方法五：遍历
    // Time: O(n), Space: O(1), Faster: 100.00%
    public void sortColors3(int[] nums) {
        if (null == nums || nums.length == 0) return;

        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] == 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                ++i;
            }
        }

        for (int j = i; j < nums.length; ++j) {
            if (nums[j] == 1) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                ++i;
            }
        }

        for (int j = i; j < nums.length; ++j) {
            if (nums[j] == 2) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                ++i;
            }
        }
    }
}
