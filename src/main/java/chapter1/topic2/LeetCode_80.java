package chapter1.topic2;

/**
 * @author donald
 * @date 2021/04/06
 *
 * LeetCode 80. 删除有序数组中的重复项 II
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 * 说明：
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * ```
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * ```
 *
 * 示例 1：
 * ```
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 * ```
 *
 * 题意： 去除重复的元素（重复2个以上的）
 *
 * 思路：
 * 1. 标记重复元素，移动元素
 * 2. 双指针 : 定义两个指针 slow 和 fast 分别为慢指针和快指针，其中慢指针表示处理出的数组的长度，快指针表示已经检查过的数组的长度。
 * 3. 逐个赋值
 */
public class LeetCode_80 {

    // 方法二： 双指针
    // Time: O(n), Space: O(1), Faster: 100.00%
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    // 方法三： 逐个赋值
    public int removeDuplicates3(int[] nums) {
        int index = 0;      //下一个填写的位置
        int cnt = 0;        //当前数字计数长度
        int n = nums.length;
        for(int i = 0; i < n; i++){
            cnt = (i == 0 || nums[i - 1] != nums[i]) ? 1 : cnt + 1;
            if(cnt <= 2)
                nums[index++] = nums[i];
        }
        return index;
    }
}
