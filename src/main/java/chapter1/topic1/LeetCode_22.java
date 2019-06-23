package chapter1.topic1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 题意：合法括号排列数有几个？
 *
 * 思路：
 * 1. 先写入( ,在写入 )
 * 卡特兰数
 *
 * 2. 动态规划
 */
public class LeetCode_22 {

    public List<String> generateParenthesis(int n) {

        return Collections.emptyList();
    }

    void generate(List<String> result, String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
        } else {
            if (left > 0) generate(result, str + '(', left - 1, right);
            if (right > left) generate(result, str + '(', left, right - 1);
        }
    }

    public List<String> generateParentheses(int n) {

        if (n < 0) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        generate(result, "", n, n);
        return result;
    }

    public List<String> generateParenthesesDP(int n) {

        if (n < 0) return new ArrayList<>();
        List<List<String>> d = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; ++i) d.add(new ArrayList<>());
        d.get(0).add("");
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 0; j < i; ++j) {
                for (String left: d.get(j)) {
                    for (String right: d.get(i - j - 1)) {
                        d.get(i).add('(' + left + ')' + right);
                    }
                }
            }
        }
        return d.get(n);
    }
}
