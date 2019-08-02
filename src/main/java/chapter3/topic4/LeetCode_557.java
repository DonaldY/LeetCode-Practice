package chapter3.topic4;

import java.util.Arrays;

/**
 * 557. Reverse Words in a String III
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * 题意： 反转字符串中单词，空格不反转
 *
 * 思路：
 * 1. 双指针，注意空格
 *
 */
public class LeetCode_557 {

    // Time: o(n), Space: o(n), Faster: 98.86%
    public String reverseWords(String s) {

        if (s == null || s.length() == 0) return s;

        char[] c = s.toCharArray();

        int start = 0, end = 0;

        while (start < c.length) {

            while (end < c.length && c[end] != ' ') ++end;

            for (int i = start, j = end - 1; i < j; ++i, --j) {

                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
            }

            start = end + 1;
            end = start;
        }

        return new String(c);
    }
}
