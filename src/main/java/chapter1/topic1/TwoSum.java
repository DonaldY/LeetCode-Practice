package chapter1.topic1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1
 *
 * indices: 索引
 *
 * eg.1
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * eg.2
 * Given nums = [3, 2, 4], target = 6,
 *
 * return [1, 2].
 *
 * eg.3
 * Given nums = [3, 3], target = 6,
 *
 * return [0, 1].
 *
 * 解题思路：
 * 1. 两重for循环
 *     时间o(n^2)，空间 o(1)
 *
 * 2. 保存索引
 *    若遇到重复的则更新索引
 *    时间 o(n), 空间 o(n)
 */
public class TwoSum {

    public static void main(String[] args) {

        int [] nums = new int[] {3, 2, 4};

        System.out.println(Arrays.toString(twoSum(nums, 6)));

    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numberIndicesMap = new HashMap<Integer, Integer>(nums.length);

        for (int i = 0; i < nums.length; ++i) {

            int needNum = target - nums[i];

            if (numberIndicesMap.containsKey(needNum)) {

                return new int[] {numberIndicesMap.get(needNum), i};
            }

            numberIndicesMap.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
