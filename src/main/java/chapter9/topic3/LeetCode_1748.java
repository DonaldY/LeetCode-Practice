package chapter9.topic3;

import java.util.*;

/**
 * @author donald
 * @date 2022/02/07
 *
 * 1748. 唯一元素的和
 *
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 * 请你返回 nums 中唯一元素的 和 。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,2]
 * 输出：4
 * 解释：唯一元素为 [1,3] ，和为 4 。
 *
 *
 * 示例 2：
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：没有唯一元素，和为 0 。
 *
 *
 * 示例 3 ：
 * 输入：nums = [1,2,3,4,5]
 * 输出：15
 * 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
 *
 * 题意： 求元素是否存在，再求和
 *
 * 思路：
 * 1. 哈希表：用 HashSet 来判断元素是否存在
 * 2. 变种： Map 的value 表示：
 *    0：该元素尚未被访问；
 *    1：该元素被访问过一次；
 *    2：该元素被访问超过一次。
 * 3. 排序 + 双指针
 */
public class LeetCode_1748 {

    // 方法一：
    // Time: O(n), Space: O(n), Faster: 55.82%
    public int sumOfUnique(int[] nums) {
        if (null == nums || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int ans = 0;

        for (int num : nums) {

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() == 1) ans += entry.getKey();
        }

        return ans;
    }

    // 方法二：
    // Time: O(n), Space: O(n), Faster: 55.82%
    public int sumOfUnique2(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> state = new HashMap<>();
        for (int num : nums) {
            if (!state.containsKey(num)) {
                ans += num;
                state.put(num, 1);
            } else if (state.get(num) == 1) {
                ans -= num;
                state.put(num, 2);
            }
        }
        return ans;
    }

    // 方法三：
    // Time: O(nlogn), Space: O(nlogn), Faster: 57.76%
    public int sumOfUnique3(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && nums[j] == nums[i]) j++;
            if (j - i == 1) ans += nums[i];
            i = j;
        }
        return ans;
    }
}
