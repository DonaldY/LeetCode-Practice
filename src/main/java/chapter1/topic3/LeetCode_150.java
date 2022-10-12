package chapter1.topic3;

import java.util.Stack;

/**
 * @author donald
 * @date 2022/10/12
 *
 * 思路： 用栈
 */
public class LeetCode_150 {

    // Time: O(n), Space: O(n), Faster: 5.28%
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            try {
                int num = Integer.valueOf(token);
                stack.push(num);
            } catch (NumberFormatException e) {
                int a2 = stack.pop();
                int a1 = stack.pop();
                if ("+".equals(token)) {
                    stack.push(a1 + a2);
                } else if ("-".equals(token)) {
                    stack.push(a1 - a2);
                } else if ("*".equals(token)) {
                    stack.push(a1 * a2);
                } else if ("/".equals(token)) {
                    stack.push(a1 / a2);
                }
            }
        }
        return stack.pop();
    }
}
