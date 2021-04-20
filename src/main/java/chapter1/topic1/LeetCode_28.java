package chapter1.topic1;

/**
 * 28. Implement strStr()
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * 题意：找到匹配字串的下表
 *
 * 思路：
 * 1. 使用API
 * 2. 2层 for
 * 3. 双指针
 */
public class LeetCode_28 {

    // 方法三： 双指针
    // Time: o(n * m), Space: o(1), Faster: 100.00%
    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) return  -1;

        return haystack.indexOf(needle);
    }

    // Time: O((n-m+1)*m), Space: O(1), Faster: 100.00%
    public int strStr2(String haystack, String needle) {

        if (haystack == null || needle == null) return -1;
        if (needle.length() == 0) return 0;
        int n = haystack.length(), m = needle.length();

        if (n == m) {

            if (haystack.equals(needle)) return 0;
            else return -1;
        }

        for (int i = 0; i <= n - m; ++i) {
            int j = 0, k = i;
            for (; j < m && k < n && needle.charAt(j) == haystack.charAt(k); ++j, ++k);
            if (j == needle.length()) return i;
        }

        return -1;
    }
}
