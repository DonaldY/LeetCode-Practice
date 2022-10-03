package chapter5.topic3;

/**
 * @author donald
 * @date 2022/10/04
 *
 * 921. 使括号有效的最少添加
 *
 * 只有满足下面几点之一，括号字符串才是有效的：
 *
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串 s ，移动N次，你就可以在字符串的任何位置插入一个括号。
 *
 * 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
 * 返回 为使结果字符串 s 有效而必须添加的最少括号数。
 *
 * 示例 1：
 * 输入：s = "())"
 * 输出：1
 *
 * 示例 2：
 * 输入：s = "((("
 * 输出：3
 *
 *
 * 思路：
 * 1. 括号匹配
 *
 * 注意：特殊用例： ()))(( , 需要 4 个
 */
public class LeetCode_921 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public int minAddToMakeValid(String s) {
        if (null == s || s.length() == 0) return 0;
        int cnt = 0, idx = 0, ans = 0;
        for (; idx < s.length(); ++idx) {
            if (s.charAt(idx) == '(') ++cnt;
            else {
                if (cnt == 0) ++ans;
                else --cnt;
            }
        }
        return ans + cnt;
    }
}
