package interview;

/**
 * @author donald
 * @date 2022/09/27
 *
 * 面试题 01.02. 判定是否互为字符重排
 *
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 * 示例 2：
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 *
 * 思路：
 * 1. 暴力法： hashmap 记录字母出现的次数
 */
public class Interview01 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public boolean CheckPermutation(String s1, String s2) {
        if (null == s1 || s1.length() == 0) return false;
        if (null == s2 || s2.length() == 0) return false;
        int[] map = new int[26];
        for (char c : s1.toCharArray()) {
            ++map[c - 'a'];
        }
        for (char c : s2.toCharArray()) {
            --map[c - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if (map[i] != 0) return false;
        }
        return true;
    }
}
