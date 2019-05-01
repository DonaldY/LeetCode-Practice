package chapter1.topic1;

/**
 *  Regular Expression Matching
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 *
 * means：p=".."
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 * Input:
 * s = "sssss"
 * p = "ss*s"
 * Output: false
 *
 * Input:
 * s = "ssssss"
 * p = "ss*s.*"
 * Output: false
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 */
public class LeetCode_10 {

    public boolean isMatch(String s, String p) {

        for (int i = 0; i < s.length(); ++i) {

            // 若 s 字符串 大于 p 字符串
            if (i >= p.length()) {

                return false;
            }

            char pChar = p.charAt(i);

            if (pChar == '.') {

                continue;
            }

            // 如何判断是否需要 *, 0 or more
            if (pChar == '*') {

                if (i > 0) {

                    s.charAt(i);
                }

            }
        }

        return true;
    }
}
