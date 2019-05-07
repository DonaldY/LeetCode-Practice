package chapter1.topic3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 136. Single Number
 *
 * Input: [2,2,1]
 * Output: 1
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 * 题意：给一串数字，只出现过一次的数字为单身数字
 *
 * 思路：
 * 1. 用HashMap记录
 * 2. 不重复的数 X 乘以 2 ，再减去数组求和
 *    2X - Y
 * 3. 位运算
 *    相同的数异或为 0， 0 ^ 0 ^ 0 ^ y = y
 */
public class LeetCode_136 {

    public static void main(String[] args) {

        int [] arr1 = new int[] {2, 2, 1};
        int [] arr2 = new int[] {4, 1, 2, 1, 2};

        LeetCode_136 leetCode = new LeetCode_136();

        System.out.println(leetCode.singleNumber(arr1));
        System.out.println(leetCode.singleNumber(arr2));

        System.out.println(leetCode.getSingleNumberByHashMap(arr1));
        System.out.println(leetCode.getSingleNumberByHashMap(arr2));
    }

    public int singleNumber(int[] nums) {

        return 0;
    }

    // Time: o(n) Space o(n)
    public int getSingleNumberByHashMap(int[] nums) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length / 2 + 1);

        for (int num : nums) {

            if (map.containsKey(num)) {

                Integer count = map.get(num);
                count = 2;

                continue;
            }

            map.put(num, 1);
        }

        for (Integer key :map.keySet()) {

            if (1 == map.get(key)) {

                return key;
            }

        }

        return 0;
    }

    public int getSingleNumberWithSet(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();
        int sum = 0, uniqueSum = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                uniqueSum += sum;
                set.add(num);
            }
            sum += num;
        }
        return 2 * uniqueSum - sum;
    }

    // Time: o(n) Space: o(1) faster: 100%
    public int getSingleNumberWithXOR(int[] nums) {
        int result = 0;

        for (int num: nums) result ^= num;

        return result;
    }
}
