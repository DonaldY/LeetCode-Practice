package chapter1.topic1;

import java.util.Arrays;

/**
 * 31. Next Permutation
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 题意： 给你一个整数数组，每一个元素是一个 0 到 9 的整数，数组的排列形成了一个有效的数字。
 * 你要找到数组的下一个排列，使它形成的数字是大于当前排列的第一个数字。
 * 如果当前排列表示的已经是最大数字，则返回这个数组的最小排列。
 * <p>
 * 思路：
 * 直接查找
 * 1. 从前往后查找，先找到第一个比比他下一个值小的数 num[p]
 * 2. 从后往前查找，找到比 num[p] 大的数 i
 * 3. 再对 i ~ p 进行升序
 */
public class LeetCode_31 {

    public static void main(String[] args) {

        int[] nums = new int[]{4, 2, 1};

        LeetCode_31 leetCode_31 = new LeetCode_31();
        leetCode_31.nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // Time: O(n), Space: O(1), Faster: 89.92%
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int n = nums.length;
        int p = n - 2;
        while (p >= 0 && nums[p] >= nums[p + 1]) --p;

        if (p >= 0) {
            int i = n - 1;
            while (i > p && nums[i] <= nums[p]) --i;
            swap(nums, i, p);
        }
        for (int i = p + 1, j = n - 1; i < j; ++i, --j)
            swap(nums, i, j);
    }
}
