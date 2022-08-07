package chapter1.topic1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3 LongestSubstringWithoutRepeatingCharacters
 *
 * Given a string, find the length of the longest substring without repeating characters
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * 题意：最长子串
 *
 * 思路：
 * 1. 暴力解决
 * 2. 滑动窗口
 *    即双指针： i, j（i 表示起始，j 表示移动）
 *
 *    当j 遇到 重复数字时候， i ++， j + 1
 *
 *    优化：
 *    i = index[首个重复数字下标] 开始， j = j + 1
 */

public class LeetCode_3 {

    public static void main(String[] args) {
        String str = "abcade";

        LeetCode_3 longest = new LeetCode_3();

        System.out.println(longest.lengthOfLongestSubstring2N(str));
    }

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> charIndicesMap = new HashMap<Character, Integer>(s.length());

        int maxLength = 0;

        int length = 0;

        int startIndex = 0;

        char[] arr = s.toCharArray();

        for (int j = 0; j < arr.length; ++j) {

            if (charIndicesMap.containsKey(arr[j])) {

                int index = charIndicesMap.get(arr[j]);

                if (startIndex <= index) {

                    if (maxLength < length) {
                        maxLength = length;
                    }

                    startIndex = index + 1;

                    length = j - index;
                    charIndicesMap.put(arr[j], j);

                    continue;
                }

            }

            charIndicesMap.put(arr[j], j);

            ++length;
        }

        if (maxLength < length) {
            maxLength = length;
        }

        return maxLength;
    }

    // Time: O(n), Space: O(m), m 是字符集大小, Faster:
    public int lengthOfLongestSubstring2N(String s) {
        int[] counts = new int[256];
        int i = 0, j = 0, maxLen = 0;
        for (; i < s.length(); ++i) {
            for (; j < s.length(); ++j) {
                if (counts[s.charAt(j)] != 0) break;
                counts[s.charAt(j)] += 1;
            }
            maxLen = Math.max(maxLen, j - i); // j - i is current length
            counts[s.charAt(i)] -= 1;
        }
        return maxLen;
    }

    // Time: O(n), Space: O(m)，m 是字符集大小
    public int lengthOfLongestSubstring1N(String s) {
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int maxLen = 0;
        for (int i = 0, j = 0; j < s.length(); ++j) {
            i = Math.max(index[s.charAt(j)] + 1, i);
            maxLen = Math.max(maxLen, j - i + 1);
            index[s.charAt(j)] = j;
        }
        return maxLen;
    }

}
