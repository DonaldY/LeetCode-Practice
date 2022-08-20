package chapter1.topic2;

/**
 * @author donald
 * @date 2022/08/19
 *
 * 二进制字符串求和
 * 这个题目说的是，给你两个用字符串表示的二进制数字，你要返回它们的和，并且和的形式同样为二进制字符串。
 *
 * 其中，给你的两个字符串都不为空，并且只包含 0/1 字符。
 *
 * 比如说，给你的两个字符串是：
 *
 * "1101"
 *  "111"
 *
 * 它们求和后的二进制字符串是 "10100"。
 *
 *
 *
 */
public class LeetCode_67 {

    // Time: O(max(m, n)), Space: O(max(m, n)), Faster: 99.96%
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }

    // Time: O(max(m, n)), Space: O(max(m, n)), Faster: 99.96%
    public String addBinaryOpt(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum & 1);
            carry = sum >> 1;
        }
        return sb.reverse().toString();
    }
}
