package bytedance.string;

/**
 * 挑战字符串 - 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 题意: 找到公共前缀子串
 *
 * 思路: 直接匹配查找
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        String str = "12344";

        System.out.println(str.substring(0, 2));
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        int index = 0;

        for (index = 0; index < strs[0].length() ; ++index) {

            for (int i = 1; i < strs.length; ++i) {

                if (index >= strs[i].length() || strs[i].charAt(index) != strs[0].charAt(index)) {

                    return strs[0].substring(0, index);
                }
            }
        }

        return strs[0].substring(0, index);
    }
}
