package chapter1.topic1;

/**
 * 12. Integer to Roman
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
 * Input: 3
 * Output: "III"
 * Example 2:
 *
 * Input: 4
 * Output: "IV"
 * Example 3:
 *
 * Input: 9
 * Output: "IX"
 * Example 4:
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * 题意： 用罗马数字来表示阿拉伯数字
 *
 * 思路： 看限制有（1 ～ 3999），可直接判断
 */
public class LeetCode_12 {

    // Time: o(n), Space: o(1), Faster: 67.31%
    public String intToRoman(int num) {

        if (num == 0) return "";

        StringBuilder result = new StringBuilder();

        if (num / 1000 > 0) {

            int n = num / 1000;

            while (n-- > 0) result.append("M");
        }

        num = num % 1000;

        if (num / 100 > 0) {

            int n = num / 100;

            if (n == 9) {

                // 900
                result.append("CM");

            } else if (n >= 5) {

                n -= 5;

                result.append("D");

                while (n-- > 0) result.append("C");

            } else if (n == 4){

                result.append("CD");
            } else {

                while (n-- > 0) result.append("C");
            }
        }

        num = num % 100;

        if (num / 10 > 0) {

            int n = num / 10;

            if (n == 9) {

                result.append("XC");
            } else if (n >= 5) {

                n -= 5;

                result.append("L");

                while (n-- > 0) result.append("X");
            } else if (n == 4) {

                result.append("XL");
            } else {

                while (n-- > 0) result.append("X");
            }
        }

        num = num % 10;

        if (num > 0) {

            int n = num % 10;

            if (n == 9) {

                result.append("IX");
            } else if (n >= 5) {

                n -= 5;

                result.append("V");

                while (n-- > 0) result.append("I");
            } else if (n == 4) {

                result.append("IV");
            } else {

                while (n-- > 0) result.append("I");
            }
        }

        return result.toString();
    }
}
