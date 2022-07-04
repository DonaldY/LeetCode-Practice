package chapter1.topic4;

/**
 * 169. Majority Element
 *
 * Input: [3,2,3]
 * Output: 3
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * 题意：找到主要元素，这个元素出现的次数超过全数的一半以上
 *
 * 思路：
 * 1. 记录每个数出现次数，然后遍历查询
 * 2. 排序后，找中位数
 * 3. 摩尔投票算法
 *    用一个计数器来表示
 */
public class LeetCode_169 {

    public static void main(String[] args) {

        LeetCode_169 leetCode = new LeetCode_169();

        System.out.println(leetCode.majorityElement(new int[]{3, 2, 3}));
        System.out.println(leetCode.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    // Time: o(n) , Space: o(1), Faster: 99.96%
    public int majorityElement(int[] nums) {

        int num = 0, count = 0;

        for (int i = 0; i < nums.length; ++i) {

            if (num == nums[i]) ++count;
            else --count;

            if (count <= 0) {
                num = nums[i];
                count = 1;
            }
        }

        return num;
    }
}
