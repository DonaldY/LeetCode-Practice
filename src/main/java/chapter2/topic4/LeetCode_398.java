package chapter2.topic4;

import java.util.*;

/**
 * @author donald
 * @date 2022/04/25
 *
 * 398. 随机数索引
 *
 * 给你一个可能含有 重复元素 的整数数组 nums ，请你随机输出给定的目标数字 target 的索引。你可以假设给定的数字一定存在于数组中。
 *
 * 实现 Solution 类：
 *
 * Solution(int[] nums) 用数组 nums 初始化对象。
 * int pick(int target) 从 nums 中选出一个满足 nums[i] == target 的随机索引 i 。如果存在多个有效的索引，则每个索引的返回概率应当相等。
 *
 * 示例：
 *
 * 输入
 * ["Solution", "pick", "pick", "pick"]
 * [[[1, 2, 3, 3, 3]], [3], [1], [3]]
 * 输出
 * [null, 4, 0, 2]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3, 3, 3]);
 * solution.pick(3); // 随机返回索引 2, 3 或者 4 之一。每个索引的返回概率应该相等。
 * solution.pick(1); // 返回 0 。因为只有 nums[0] 等于 1 。
 * solution.pick(3); // 随机返回索引 2, 3 或者 4 之一。每个索引的返回概率应该相等。
 *
 *
 */
public class LeetCode_398 {

    class Solution {
        Random random = new Random();
        Map<Integer, List<Integer>> map = new HashMap<>();
        public Solution(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
                list.add(i);
                map.put(nums[i], list);
            }
        }
        public int pick(int target) {
            List<Integer> list = map.get(target);
            return list.get(random.nextInt(list.size()));
        }

    }
}
