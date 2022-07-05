package chapter1.topic1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * 题意： 电话号码
 *
 * 思路：
 * 1. 直接匹配查询: dfs
 */
public class LeetCode_17 {

    List<String> number = Arrays.asList("abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz");

    // Time: O(4 ^ n), Space: O(n), Faster: 15.69%
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) return Collections.emptyList();

        List<String> result = new ArrayList<>();

        generate(result, digits, 0, "");

        return result;
    }

    private void generate(List<String> result, String digits, int index, String str) {
        if (index == digits.length()) {
            result.add(str);
            return;
        }
        String chars = number.get(digits.charAt(index) - '2');
        for (int i = 0; i < chars.length(); ++i) {
            generate(result, digits, index + 1, str + chars.charAt(i));
        }
    }

}
