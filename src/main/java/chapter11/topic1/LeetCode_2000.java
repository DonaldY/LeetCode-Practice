package chapter11.topic1;

/**
 * @author donald
 * @date 2022/02/02
 *
 * 2000. 反转单词前缀
 *
 * 给你一个下标从 0 开始的字符串 word 和一个字符 ch 。找出 ch 第一次出现的下标 i ，
 * 反转 word 中从下标 0 开始、直到下标 i 结束（含下标 i ）的那段字符。
 * 如果 word 中不存在字符 ch ，则无需进行任何操作。
 *
 * 例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、直到下标 3 结束（含下标 3 ）。
 * 结果字符串将会是 "dcbaefd" 。
 * 返回 结果字符串 。
 *
 * 示例 1：
 * 输入：word = "abcdefd", ch = "d"
 * 输出："dcbaefd"
 * 解释："d" 第一次出现在下标 3 。
 * 反转从下标 0 到下标 3（含下标 3）的这段字符，结果字符串是 "dcbaefd" 。
 *
 *
 * 示例 2：
 * 输入：word = "xyxzxe", ch = "z"
 * 输出："zxyxxe"
 * 解释："z" 第一次也是唯一一次出现是在下标 3 。
 * 反转从下标 0 到下标 3（含下标 3）的这段字符，结果字符串是 "zxyxxe" 。
 *
 *
 * 示例 3：
 * 输入：word = "abcd", ch = "z"
 * 输出："abcd"
 * 解释："z" 不存在于 word 中。
 * 无需执行反转操作，结果字符串是 "abcd" 。
 *
 *
 * 题意： 反转字符串
 *
 * 思路： 双指针反转
 */
public class LeetCode_2000 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index <= 0) return word;

        char[] words = word.toCharArray();
        for (int i = 0, j = index; i < j; ++i, --j) {

            char tmp = word.charAt(j);
            words[j] = words[i];
            words[i] = tmp;
        }

        word = new String(words);
        return word;
    }
}
