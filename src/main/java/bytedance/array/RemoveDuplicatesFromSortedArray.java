package bytedance.array;

/**
 * @author donald
 * @date 2020/11/24
 *
 * Leetcode 26. 删除排序数组中的重复项
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 思路：
 * 1. 双指针方式, slow 表示可填指针, fast 移动指针
 *              num 表示前一个存储的值
 *
 *    1     1    1    2    2
 *          ^^
 *          ||
 *          sf
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedArray remove = new RemoveDuplicatesFromSortedArray();

        int[] nums = new int[]{1, 1, 2};

        System.out.println(remove.removeDuplicates(nums));

        for (int i = 0; i < nums.length; ++i) System.out.println(nums[i]);
    }

    // Time: O(n), Space: O(1), Faster: 100.00%
    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int slow = 1, fast = 1, num = nums[0];

        for (; fast < nums.length; ++fast) {

            if (num == nums[fast]) continue;

            num = nums[fast];
            nums[slow] = nums[fast];
            ++slow;
        }

        return slow;
    }
}
