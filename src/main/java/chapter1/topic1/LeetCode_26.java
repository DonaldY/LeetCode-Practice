package chapter1.topic1;

/**
 * @author donald
 * @date 2020/5/19
 *
 *  26. Remove Duplicates from Sorted Array
 *
 *  Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 题意：
 *
 * 思路：
 * 1. 双指针方式, slow 表示可填指针, fast 移动指针
 *              num 表示前一个存储的值
 *
 *    1     1    1    2    2
 *          ^^
 *          ||
 *          sf
 *
 * 2. 数组完成排序后，我们可以放置两个指针 i 和 j，其中 ii 是慢指针，而 j 是快指针。只要 nums[i] = nums[j]，我们就增加 j 以跳过重复项。
 * 当我们遇到 nums[j] != nums[j] 时，跳过重复项的运行已经结束，
 * 因此我们必须把它（nums[j]）的值复制到 nums[i+1]。然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
 */
public class LeetCode_26 {

    // Time: O(), Space: O(1), Faster: 22.10%
    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int result = 1, p = 1;

        for (int i = 1; i < nums.length; ++i) {

            if (nums[i] == nums[i - 1]) continue;

            nums[p++] = nums[i];
            ++result;
        }

        return result;
    }

    // Time: O(n), Space: O(1), Faster: 100.00%
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 1;
        for (int q = 1; q < nums.length; ++q)
            if (nums[q] != nums[q-1])
                nums[p++] = nums[q];
        return p;
    }
}
