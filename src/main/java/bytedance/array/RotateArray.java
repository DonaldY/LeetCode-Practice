package bytedance.array;

/**
 * @author donald
 * @date 2020/11/24
 *
 * Leetcode 189. 旋转数组
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 思路：
 * 向右移动 k % nums.len
 *
 * 1. 将溢出的数，放到另一个数组，最后拼接起来
 * 2. 反转
 *    I 整体反转
 *   II 左边反转
 *  III 右边反转
 *
 *    I: [1,2,3,4,5,6,7] -> [7,6,5,4,3,2,1]
 *   II: [7,6,5,4,3,2,1] -> [5,6,7,4,3,2,1]
 *  III: [5,6,7,4,3,2,1] -> [5,6,7,1,2,3,4]
 */
public class RotateArray {

    // 方法 2： Time: O(n), Space: O(1), Faster:
    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0) return;

        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {

        for (; i < j; ++i, --j) {

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
