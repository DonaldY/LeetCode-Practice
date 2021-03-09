package chapter6.topic1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author donald
 * @date 2021/03/09
 *
 * LeetCode 1047. 删除字符串中的所有相邻重复项
 *
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * ```
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * ```
 *
 * 题意： 删除重复字母
 *
 * 思路：
 * 1. 暴力法： 每次删除后，重新查找
 */
public class LeetCode_1047 {

    // Time: O(n), Space: O(1), Faster: 69.85%
    public String removeDuplicates(String S) {

        if (null == S || S.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        int n = S.length();
        int i = 0;
        while (i < n){
            if (i + 1 < n && S.charAt(i) == S.charAt(i+1)){
                i += 2;
            }else {
                int len = sb.length();
                if (len > 0 && S.charAt(i) == sb.charAt(len - 1)){
                    sb.deleteCharAt(len-1); // 数组频繁移动
                }else {
                    sb.append(S.charAt(i));
                }
                i++;
            }
        }
        return sb.toString();
    }

    // Time: O(n), Space: O(1), Faster: 73.62%
    public String removeDuplicatesWithStack(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }
}
