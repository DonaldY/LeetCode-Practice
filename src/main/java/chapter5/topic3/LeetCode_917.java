package chapter5.topic3;

/**
 * @author donald
 * @date 2022/02/23
 *
 * 917. 仅仅反转字母
 *
 * 给你一个字符串 s ，根据下述规则反转字符串：
 *
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 *
 * 示例 1：
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 *
 * 示例 2：
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 *
 * 示例 3：
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 * 题意： 反转字符串
 *
 * 思路：
 * 1. 记录非字符的位置
 * 2. 双指针
 */
public class LeetCode_917 {

    // Time: O(n), Space: O(n), Faster: 44.62%
    public String reverseOnlyLetters(String s) {

        if (null == s || s.length() == 0) return "";

        StringBuilder tmp = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            if ((s.charAt(i) <= 'Z' && s.charAt(i) >= 'A')
                    || (s.charAt(i) <= 'z' && s.charAt(i) >= 'a')) {
                tmp.append(s.charAt(i));
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0, j = 0; i < s.length(); ++i) {

            if ((s.charAt(i) <= 'Z' && s.charAt(i) >= 'A')
                    || (s.charAt(i) <= 'z' && s.charAt(i) >= 'a')) {
                ans.append(tmp.charAt(tmp.length() - j - 1));
                ++j;
            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}
