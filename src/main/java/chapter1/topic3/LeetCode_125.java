package chapter1.topic3;

/**
 * Valid Palindrome
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Input: "race a car"
 * Output: false
 *
 * 题意：判断一个字符串是否是回文字符串。字符串里只考虑字母和数字，其它的字符可以无视。另外，对于字母，可以忽略大小写。
 *
 * 思路：
 * 1. 去除所有干扰条件后，再进行计算
 *
 * 2. 不去除直接计算
 */
public class LeetCode_125 {

    public static void main(String[] args) {

        LeetCode_125 leetcode = new LeetCode_125();

        System.out.println(leetcode.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(leetcode.isPalindrome("race a car")); // false
    }

    // Time o(n), Space o(1)
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        s = s.replaceAll(" ", "");

        for (int i = 0 , j = s.length() - 1; i < s.length() / 2 && j >= s.length() / 2; ){

            if (!isAlphanumeric(s.charAt(i))) {

                ++i;
                continue;
            }

            if (!isAlphanumeric(s.charAt(j))) {

                --j;
                continue;
            }

            if (s.charAt(i) != s.charAt(j)) {

                return false;
            }

            ++i;
            --j;
        }

        return true;
    }

    private boolean isAlphanumeric(char c) {

        return (c <= 'z' && c >= 'a') || (c >= '0' && c <= '9');

    }
}

// faster : 99.38%
class LeetCode_125_1 {

    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
                || (c >= '0' && c <= '9');
    }

    private boolean isEqualIgnoreCase(char a, char b) {
        if (a >= 'A' && a <= 'Z') a += 32;
        if (b >= 'A' && b <= 'Z') b += 32;
        return a == b;
    }

    // Time: O(n), Space: O(1)
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        int i = 0, j = s.length() - 1;
        for (; i < j; ++i, --j) {
            while (i < j && !isAlphanumeric(s.charAt(i))) ++i;
            while (i < j && !isAlphanumeric(s.charAt(j))) --j;
            if (i < j && !isEqualIgnoreCase(s.charAt(i), s.charAt(j))) return false;
        }
        return true;
    }
}