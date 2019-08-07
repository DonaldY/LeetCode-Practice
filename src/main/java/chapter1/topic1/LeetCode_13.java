package chapter1.topic1;

/**
 * 13. Roman to Integer
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * Example 1:
 *
 * Input: "III"
 * Output: 3
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 * Example 4:
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * 题意： roman 数字转换为 整型
 *
 * 思路：
 *
 *
 */
public class LeetCode_13 {

    public static void main(String[] args) {

        String s = "MCMXCIV";

        LeetCode_13 leetCode_13 = new LeetCode_13();

        System.out.println(leetCode_13.romanToInt(s));
    }

    // Time: o(n), Space: o(1), Faster: 100.00%
    public int romanToInt(String s) {

        if (s == null || s.length() == 0) return 0;

        int result = 0;

        for (int i = 0; i < s.length(); ++i) {

            char c = s.charAt(i);

            if (c == 'I') {

                if (i <= s.length() - 2 && s.charAt(i + 1) == 'V') {

                    result += 4;

                    ++i;

                    continue;
                }

                if (i <= s.length() - 2 && s.charAt(i + 1) == 'X') {

                    result += 9;

                    ++i;

                    continue;
                }

                result += 1;
            }
            else if (c == 'V') {

                result += 5;
            }
            else if (c == 'X') {

                if (i <= s.length() - 2 && s.charAt(i + 1) == 'L') {

                    result += 40;

                    ++i;

                    continue;
                }

                if (i <= s.length() - 2 && s.charAt(i + 1) == 'C') {

                    result += 90;

                    ++i;

                    continue;
                }

                result += 10;
            }
            else if (c == 'L') {

                result += 50;
            }
            else if (c == 'C') {

                if (i <= s.length() - 2 && s.charAt(i + 1) == 'D') {

                    result += 400;

                    ++i;

                    continue;
                }

                if (i <= s.length() - 2 && s.charAt(i + 1) == 'M') {

                    result += 900;

                    ++i;

                    continue;
                }

                result += 100;
            }
            else if (c == 'D') {

                result += 500;
            }
            else if (c == 'M')  {

                result += 1000;
            }
        }

        return result;
    }
}
