package chapter2.topic4;


/**
 * @author donald
 * @date 2022/08/01
 *
 * 394. 字符串解码
 *
 * 这个题目说的是，给你一个编码后的字符串 s，s 中只包含数字、字母以及方括号。其中，数字只能出现在方括号前面，表示方括号内字符串的重复次数。你要将 s 解码，并返回解码后的字符串。
 *
 * 注意，给你的字符串 s 一定可以进行有效解码，并且解码后的字符串只包含字母，不包含数字和方括号。
 *
 * 比如说，编码后的字符串 s 是：
 *
 * s = "d2[a2[b]]e"
 *
 * 其中，数字和方括号的作用是对子串进行重复。s 解码后的字符串是：
 *
 * "dabbabbe"
 *
 *
 * 思路：
 * 1. 栈 + 递归思想： 栈用来匹配 []
 *    - 匹配 [] ，可以提前记录下来
 */
public class LeetCode_394 {

    // Time: O(m), Space: O(m), Faster: 100.00%
    public String decodeStringWithIndexMap(String s) {
        int n = s.length();
        int[] stack = new int[n];
        int[] indexes = new int[n];
        int top = -1;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '[') {
                stack[++top] = i;
            } else if (s.charAt(i) == ']') {
                int idx = stack[top--];
                indexes[idx] = i;
            }
        }
        return decode(s, 0, n-1, indexes);
    }

    private String decode(String s, int low, int high, int[] indexes) {
        StringBuilder sb = new StringBuilder();
        int p = low;
        while (p <= high) {
            int q = p;
            while (Character.isDigit(s.charAt(q))) ++q;
            if (p != q) {
                int cnt = Integer.valueOf(s.substring(p, q));
                int right = indexes[q];
                String str = decode(s, q+1, right-1, indexes);
                for (int i = 0; i < cnt; ++i) sb.append(str);
                p = right + 1;
            } else {
                sb.append(s.charAt(p++));
            }
        }
        return sb.toString();
    }
}
