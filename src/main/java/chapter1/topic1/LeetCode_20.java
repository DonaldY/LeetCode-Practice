package chapter1.topic1;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 *
 * 题意：有效的括号，括号成对出现
 *
 * 思路：
 * 1. 遇见左括号就进栈，遇见右括号就出栈
 */
public class LeetCode_20 {

    // Time: o(n), Space: o(n), Faster: 98.34%
    public boolean isValid(String s) {

        if (s == null || s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {

            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
                continue;
            }

            if (stack.isEmpty()) return false;

            char c2 = stack.pop();

            switch (c) {
                case ')' :
                    if (c2 == '(') break;
                    return false;
                case ']' :
                    if (c2 == '[') break;
                    return false;
                case '}' :
                    if (c2 == '{') break;
                    return false;
            }
        }

        return stack.isEmpty();

    }

    // Time: O(n), Space: O(n), Faster: 98.96%
    public boolean isValidBracketsShort(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') stack.push(')');
            else if (s.charAt(i) == '[') stack.push(']');
            else if (s.charAt(i) == '{') stack.push('}');
            else if (stack.isEmpty() || s.charAt(i) != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
