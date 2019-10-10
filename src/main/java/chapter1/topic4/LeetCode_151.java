package chapter1.topic4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 151. Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However,
 * your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * 题意： 反转字符串里的单词
 *
 * 思路：
 * 1. 按空格分割，过滤空格，逆序输出
 * 2. 翻转
 *    1. 去空格
 *    2. 单词内部反转
 *    3. 整个字符串翻转
 */
public class LeetCode_151 {

    // Time: O(n), Space: O(n), Faster: 5.22%
    public String reverseWords(String s) {

        if (s == null || s.length() == 0) return "";

        List<String> words = Arrays.asList(s.split("\\s+"));

        words = words.stream().filter(word -> word != null && word.length() != 0).collect(Collectors.toList());

        StringBuffer stringBuffer = new StringBuffer("");

        for (int i = words.size() - 1; i >= 0; --i) {

            stringBuffer.append(words.get(i));

            if (i > 0) {

                stringBuffer.append(" ");
            }
        }

        return stringBuffer.toString();
    }

    // Time:O(n), Space:O(n), Faster: 35.49%
    public String reverseWords2(String s) {

        String[] words = s.trim().split(" +");

        Collections.reverse(Arrays.asList(words));

        return String.join(" ", words);
    }

    // Time:O(n), Space:O(n), Faster: 99.86%
    public String reversWords3(String s) {
        if (s == null || s.length() == 0) return s;

        char [] str = s.toCharArray();

        int p = 0, q = 0, end = str.length - 1;

        while (end >= 0 && str[end] == ' ') --end;
        while (q <= end) {
            int start = p;
            while (q <= end && str[q] == ' ') ++q;
            while (q <= end && str[q] != ' ') str[p++] = str[q++];
            reverse(str, start, p - 1);
            if (q <= end) str[p++] = ' ';
        }
        reverse(str, 0, p - 1);
        return new String(str, 0, p);
    }

    private void reverse(char[] str, int i, int j) {

        for (; i < j; ++i, --j) {

            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
    }
}
