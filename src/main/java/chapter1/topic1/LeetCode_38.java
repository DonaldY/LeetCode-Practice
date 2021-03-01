package chapter1.topic1;

/**
 * @author donald
 * @date 2021/03/02
 *
 * LeetCode 38. Count and Say
 *
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1),
 * which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of groups
 * so that each group is a contiguous section all of the same character. Then for each group,
 * say the number of characters, then say the character.
 * To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
 *
 * For example, the saying and conversion for digit string "3322251":
 *
 * ```
 * Example 1:
 *
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 *
 *
 * Example 2:
 *
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 * ```
 *
 * 题意：
 * 定义一种数据变换方式，将连续相同的一段数字，用它的数量和这个数字组合起来表示。
 * 比如对于字符串 "111221"，它是由 3 个连续的 1，2 个连续的 2，以及 1 个 1 组成，因此它变换出来的下一个字符串就是 "312211"。
 * 从字符串 "1" 开始，使用这种方式不断向后变换，就可以得到一个字符串序列：
 * "1", "11", "21", "1211", "111221", ...
 *
 * 现在给你一个整数 n，你要返回这个序列中的第 n 项。
 *
 * 注意，n 从 1 开始算起，也就是说在这个序列中，第 1 项是字符串 "1"。
 *
 * 思路：
 * 1. 字符串的转换
 */
public class LeetCode_38 {

    // Time: O(1.3^n), Space: O(1.3^n)
    // Time: O(2^n), Space: O(2^n), Faster:  50.34%
    public String countAndSay(int n) {
        if (n < 1) return null;
        String s = "1";
        for (int i = 1; i < n; ++i) {
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            for (int p = 0; p < s.length(); ++p) {
                if (p+1 < s.length() && s.charAt(p) == s.charAt(p+1)) {
                    ++cnt;
                } else {
                    sb.append(cnt).append(s.charAt(p));
                    cnt = 1;
                }
            }
            s = sb.toString();
        }
        return s;
    }
}
