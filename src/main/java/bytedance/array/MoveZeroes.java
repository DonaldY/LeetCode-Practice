package bytedance.array;

/**
 * @author donald
 * @date 2020/11/18
 *
 * Leetcode 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 思路：
 * 1. 暴力法：额外数组
 * 2. 双指针
 */
public class MoveZeroes {

    // 双指针 Time: 0(n), Space: 0(1), Faster: 16.64%
    public void moveZeroes(int[] nums) {

        int slow = 0, faster = 0;

        for (; faster < nums.length && slow < nums.length; ++faster) {

            if (nums[slow] != 0) {

                ++slow;
                continue;
            }

            if (nums[faster] == 0) continue;

            if (slow < faster && nums[slow] == 0 && nums[faster] != 0) {

                int tmp = nums[faster];
                nums[faster] = nums[slow];
                nums[slow] = tmp;
                ++slow;
            }
        }
    }
}
