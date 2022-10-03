package chapter2.topic3;

/**
 * @author donald
 * @date 2022/10/03
 *
 * 剑指 Offer II 005. 单词长度的最大乘积
 *
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。
 * 如果没有不包含相同字符的一对字符串，返回 0。
 *
 *  
 *
 * 示例 1:
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 *
 * 示例 2:
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 *
 * 示例 3:
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 *
 * 思路：
 * 1. 暴力法： 遍历每个字符串， 用 hash表存储来
 */
public class LeetCode_318 {

    // 方法一：暴力法
    // Time: O(n^2 * m), Space: O(1), Faster: 22.83%
    public int maxProduct(String[] words) {
        if (null == words || words.length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < words.length; ++i) {
            int[] map = new int[26];
            for (char c : words[i].toCharArray()) map[c - 'a'] = 1;
            for (int j = i + 1; j < words.length; ++j) {
                boolean flag = true;
                for (char c : words[j].toCharArray()) {
                    if (map[c - 'a'] == 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
