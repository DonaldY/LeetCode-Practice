package chapter4.topic3;

/**
 * @author donald
 * @date 2022/08/01
 *
 * 739. 每日温度
 *
 * 这个题目说的是，给你一个不为空的整数数组，数组中的元素表示每天的温度。你要计算出，对于每一天来说，温度升高需要等待的天数。如果对于某一天，未来不存在比它更高的温度，就把它对应的等待天数设置为 0。
 *
 * 比如说，给你的温度数组是：
 *
 * 1, 3, 1, 3, 2, 6
 *
 * 对于每一天来说，温度升高需要等待的天数是：
 *
 * 1, 4, 1, 2, 1, 0
 *
 *
 * 思路：
 * 1. 暴力法： 2层 for 循环
 */
public class LeetCode_739 {

    // Time: O(n ^ 2), Space: O(1), Faster: 6.67%
    public int[] dailyTemperatures(int[] temperatures) {
        if (null == temperatures || temperatures.length == 0) return new int[0];
        int [] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length - 1; ++i) {
            int ans = 0;
            for (int j = i + 1; j < temperatures.length; ++j) {
                if (temperatures[j] > temperatures[i]) {
                    ans = j - i;
                    break;
                }
            }
            result[i] = ans;
        }
        return result;
    }
}
