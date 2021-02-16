package chapter1.topic1;

/**
 * LeetCode 5 LongestPalindromicSubstring
 *
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * 题意：最长回文子串
 *
 * 思路：
 * 1. 暴力求解
 * 2. 动态规划
 *
 * s(i, j)
 * i == j ,
 * i + 1 == j: s(i) == s(j)
 * else : s(i) == s(j) && s(i + 1, j - 1) ?
 *
 * 3. 以中心为节点，向外扩展（注意奇 偶）
 *
 * 4. manacher
 */
public class LeetCode_5 {

    public static void main(String[] args) {

        LeetCode_5 longestPalindromicSubstring = new LeetCode_5();

        System.out.println(longestPalindromicSubstring.longestPalindrome(""));

        /*char [] arr = "bccb".toCharArray();

        System.out.println(longestPalindromicSubstring.isPalindromic(arr, 0 ,3));*/
    }

    public String longestPalindrome(String s) {

        if (s.length() == 0) {

            return "";
        }

        char [] arr = s.toCharArray();

        int length = 0;
        int start = 0;
        int end = 0;

        for (int i = 0 ; i < arr.length - 1; ++i) {

            for (int j = arr.length - 1; j > 0; --j) {

                if (isPalindromic(arr, i, j)) {

                    if (length < (j - i + 1)) {

                        length = j - i + 1;
                        start = i;
                        end = j;
                    }
                }

            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start; i <= end; ++i) {

            stringBuilder.append(arr[i]);
        }

        return stringBuilder.toString();
    }

    private boolean isPalindromic(char[] arr, int start, int end) {

        int len = (end - start + 1) / 2;

        for (int i = start, j = end; i < start + len && j > end - len; ++i, --j) {

            if (arr[i] != arr[j]) {

                return false;
            }
        }

        return true;
    }

    public String longestPalindromeDP(String s) {

        if (s == null || s.length() == 0) return "";
        int n = s.length(), start = 0, maxLen = 0;
        boolean[][] d = new boolean[n][n];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; i < n; ++j) {
                if (i == j) d[i][j] = true;
                else if (i + 1 == j) d[i][j] = s.charAt(i) == s.charAt(j);
                else d[i][j] = s.charAt(i) == s.charAt(j) && d[i + 1][j - 1];

                if (d[i][j] && (j - i + 1) > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    int expand(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left; ++right;
        }

        return right - left - 1;
    }

    // Time: o(n ^ 2), Space: o(1), Faster: 86.79%
    public String longestPalindromeExpand(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); ++i) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                start = i - (len - 1) / 2;
                maxLen = len;
            }
        }

        return s.substring(start, start + maxLen);
    }
}
