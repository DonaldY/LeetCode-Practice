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
 * 当 * 后面没有字符，但 s 还有字母， 则 * 模仿前面一个字母并与对应字母比对
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * . 都跳过，遇到 *
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
 * Output: true
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * 思路：
 * 1. 把所有可能都列举出来，然后匹配
 * 2. 逐字匹配，遇到 * 联系上下文
 *
 * 实际解决:
 * 1.
 *
 * https://www.cnblogs.com/grandyang/p/4461713.html
 */
public class LeetCode_10 {

    public static void main(String[] args) {

        LeetCode_10 leetCode = new LeetCode_10();

        System.out.println(leetCode.isMatch("aa", "a")); // false
        System.out.println(leetCode.isMatch("aa", "a*")); // true
        System.out.println(leetCode.isMatch("aa", ".*")); // true
        System.out.println(leetCode.isMatch("mississippi", "mis*is*p*.")); // false
    }

    public boolean isMatch(String s, String p) {

        if (p.isEmpty()) {

            return s.isEmpty();
        }

        if (p.length() == 1) {

            return (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        }

        if (p.charAt(1) != '*') {

            if (s.isEmpty()) {

                return false;
            }

            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }

        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {

            if (isMatch(s, p.substring(2))) {
                return true;
            }

            s = s.substring(1);
        }

        return isMatch(s, p.substring(2));
    }
}
