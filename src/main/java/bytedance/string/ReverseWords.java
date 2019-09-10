package bytedance.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 挑战字符串 - 翻转字符串里的单词
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 题意: 字反转
 *
 * 思路:
 * 1. 已空格分割, 生成的数组, 从后往前读
 *
 */
public class ReverseWords {

    // Time: o(n), Space: o(n)
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

    public String reverseWords2(String s) {

        String[] words = s.trim().split(" +");

        Collections.reverse(Arrays.asList(words));

        return String.join(" ", words);
    }
}
