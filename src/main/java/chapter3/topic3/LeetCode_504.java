package chapter3.topic3;

/**
 * @author donald
 * @date 2022/03/07
 *
 * 504. 七进制数
 *
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 * 示例 1:
 * 输入: num = 100
 * 输出: "202"
 *
 * 示例 2:
 * 输入: num = -7
 * 输出: "-10"
 *
 * 题意： 进制转换
 *
 * 思路： 十进制转换为 7 进制
 *
 */
public class LeetCode_504 {

    // Time：O(log∣num∣), Space: O(1), Faster: 76.60%
    public String convertToBase7(int num) {

        if (num == 0) {
            return "0";
        }
        boolean negative = num < 0;
        num = Math.abs(num);
        StringBuffer digits = new StringBuffer();
        while (num > 0) {
            digits.append(num % 7);
            num /= 7;
        }
        if (negative) {
            digits.append('-');
        }
        return digits.reverse().toString();
    }
}
