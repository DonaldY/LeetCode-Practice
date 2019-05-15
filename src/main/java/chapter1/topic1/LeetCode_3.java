package chapter1.topic1;

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
 *
 */

public class LeetCode_3 {

    public static void main(String[] args) {
        String  str = "pwwkew";

        LeetCode_3 longest = new LeetCode_3();

        System.out.println(longest.lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> charIndicesMap = new HashMap<Character, Integer>(s.length());

        int maxLength = 0;

        int length = 0;

        int startIndex = 0;

        char [] arr = s.toCharArray();

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
}
