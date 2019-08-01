package chapter2.topic3;

/**
 * 344. Reverse String
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * 题意： 反转字符串，不能使用额外空间
 *
 * 思路：
 * 双指针
 *
 */
public class LeetCode_344 {

    // Time: o(n), Space: o(1), Faster: 100.00%
    public void reverseString(char[] s) {

        if (s == null || s.length == 0) return;

        for (int i = 0, j = s.length - 1; i < s.length / 2; ) {

            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            ++i;
            --j;
        }
    }
}
