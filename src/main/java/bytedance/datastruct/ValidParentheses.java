package bytedance.datastruct;

import java.util.Stack;

/**
 * @author donald
 * @date 2020/11/25
 *
 * Leetcode 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 思路：
 * 1. 用栈， [ ( { 就进栈，其他出栈，并配对
 */
public class ValidParentheses {

    // Time : O(n), Space: O(n), Faster: 75.96%
    public boolean isValid(String s) {

        if (null == s || s.length() == 0) return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {

            char ss = s.charAt(i);

            if (ss == '(' || ss == '[' || ss == '{') stack.push(ss);
            else {

                if (stack.isEmpty()) return false;

                char pop = stack.pop();

                if (ss == ')' && pop != '(') return false;
                else if (ss == ']' && pop != '[') return false;
                else if (ss == '}' && pop != '{') return false;
             }
        }

        return stack.isEmpty();
    }
}
