package chapter1.topic1;

/**
 * 31. Next Permutation
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 题意： 给你一个整数数组，每一个元素是一个 0 到 9 的整数，数组的排列形成了一个有效的数字。
 * 你要找到数组的下一个排列，使它形成的数字是大于当前排列的第一个数字。
 * 如果当前排列表示的已经是最大数字，则返回这个数组的最小排列。
 *
 * 思路：
 *
 */
public class LeetCode_31 {

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
        while (p >= 0 && nums[p] >= nums[p+1]) --p;

        if (p >= 0) {
            int i = n - 1;
            while (i > p && nums[i] <= nums[p]) --i;
            swap(nums, i, p);
        }
        for (int i = p+1, j = n-1; i < j; ++i, --j)
            swap(nums, i, j);
    }
}
