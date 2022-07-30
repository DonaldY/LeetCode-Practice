package chapter4.topic3;

import java.util.Stack;

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
 * 2. 栈方法： 辅助栈
 * 3. 跳跃法： 步长计算
 */
public class LeetCode_739 {

    // Time: O(n ^ 2), Space: O(1), Faster: 6.67%
    public int[] dailyTemperatures(int[] temperatures) {
        if (null == temperatures || temperatures.length == 0) return new int[0];
        int[] result = new int[temperatures.length];
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

    // 方法二：辅助栈
    // Time: O(n), Space: O(n), Faster: 44.57%
    public int[] dailyTemperaturesStack(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!st.empty() && temperatures[st.peek()] < temperatures[i]) {
                int idx = st.pop();
                result[idx] = i - idx;
            }
            st.push(i);
        }
        // while (!st.empty()) result[st.pop()] = 0;
        return result;
    }

    // 方法三：跳跃法
    // Time: O(n), Space: O(1), Faster: 99.98%
    public int[] dailyTemperaturesSkip(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            int j = i + 1;
            while (temperatures[j] <= temperatures[i] && result[j] != 0) j += result[j];
            if (temperatures[j] > temperatures[i]) result[i] = j - i;
            // else result[i] = 0;
        }
        return result;
    }
}
