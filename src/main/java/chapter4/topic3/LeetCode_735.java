package chapter4.topic3;

import java.util.Stack;

/**
 * @author donald
 * @date 2022/10/13
 *
 * 题意： + 向右， - 向左。
 *       只有同时有 向右 和 向左 才会相撞。
 *
 * 思路： 栈
 */
public class LeetCode_735 {
    // Time: O(n), Space: O(n), Faster: 5.29%
    public int[] asteroidCollision(int[] asteroids) {
        // 1. 计算
        Stack<Integer> stack = new Stack<>();
        for (int num : asteroids) {
            if (stack.isEmpty()) {
                stack.push(num);
                continue;
            }
            stack.push(num);
            while (!stack.isEmpty() && stack.size() >= 2) {
                int cur = stack.pop();
                int pre = stack.pop();

                // 只有同时有 向右 和 向左 才会相撞。
                if (pre > 0 && cur < 0) {
                    if (pre > Math.abs(cur)) {
                        stack.push(pre);
                    } else if (pre == Math.abs(cur)) { // 相等，两数就抵消了
                        break;
                    } else {
                        stack.push(cur);
                    }
                } else {  // 没有需要计算的
                    stack.push(pre);
                    stack.push(cur);
                    break;
                }
            }
        }
        // 2. 构建结果
        int n = stack.size();
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; --i) result[i] = stack.pop();
        return result;
    }
}
