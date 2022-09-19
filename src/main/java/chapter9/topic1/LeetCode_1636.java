package chapter9.topic1;

import java.util.*;

/**
 * @author donald
 * @date 2022/09/19
 *
 * 1636. 按照频率将数组升序排序
 *
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * 请你返回排序后的数组。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 *
 *
 * 思路： 简单题， 先统计次数，再排序，最后输出
 */
public class LeetCode_1636 {

    class Num {
        private Integer num;
        private Integer frequency;

        public Num(Integer num, Integer frequency) {
            this.num = num;
            this.frequency = frequency;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Num num1 = (Num) o;
            return Objects.equals(num, num1.num);
        }

        @Override
        public int hashCode() {
            return Objects.hash(num);
        }
    }

    // Time: O(nlogn), Space: O(n), Faster: 63.87%
    public int[] frequencySort(int[] nums) {
        if (null == nums || nums.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int n = map.getOrDefault(num, 0);
            map.put(num, n + 1);
        }
        List<Num> list = new ArrayList<>(map.size());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new Num(entry.getKey(), entry.getValue()));
        }
        list.sort((a, b) -> {
            // 频率相等，按降序
            if (a.frequency == b.frequency) {
                return b.num - a.num;
            }
            return a.frequency - b.frequency;
        });
        int[] result = new int[nums.length];
        int index = 0;
        for (Num num : list) {
            for (int i = 0; i < num.frequency; ++i) result[index++] = num.num;
        }
        // 输出 int[]: numsList.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
