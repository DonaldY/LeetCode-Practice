package chapter1.topic1;

/**
 * String to Integer (atoi)
 *
 * Input: "42"
 * Output: 42
 *
 * Input: "words and 987"
 * Output: 0
 *
 * Input: "-91283472332"
 * Output: -2147483648
 *
 * 思路：
 * 1. 去空白
 * 2. 判断第一个字符
 * 3. 求得整数
 */
public class LeetCode_8 {

    private int MAX = Integer.MAX_VALUE;
    private int MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {

        LeetCode_8 leetCode_8 = new LeetCode_8();

        System.out.println(leetCode_8.myAtoi("42"));

        System.out.println(leetCode_8.myAtoi("words and 987"));

        System.out.println(leetCode_8.myAtoi("-91283472332"));

        System.out.println(leetCode_8.myAtoi(" "));
        System.out.println(leetCode_8.myAtoi(" -42")); // -42
        System.out.println(leetCode_8.myAtoi("   +0 123")); // 0
        System.out.println(leetCode_8.myAtoi("+1")); // 1
    }

    public int myAtoi(String str) {

        if (null == str || str.isEmpty()) {

            return 0;
        }

        int index = trimFrontWhitespace(str);

        if (index >= str.length()) {

            return 0;
        }

        char firstChar = str.charAt(index);

        if (firstChar != '-' && firstChar != '+' && firstChar < '0' || firstChar > '9' ) {

            return 0;
        }

        int result = 0;

        int flag = 1; // 用于判断正负

        if (firstChar == '-') {

            flag = -1;
            ++index;
        } else if (firstChar == '+') {
            ++index;
        }

        for (int i = index; i < str.length(); ++i ) {

            char c = str.charAt(i);

            if (c < '0' || c > '9') {

                break;
            }

            long temp = (long)result * 10 + (c - '0') * flag;

            if (temp >= MAX) {

                return MAX;
            } else if (temp <= MIN) {

                return MIN;
            }

            result = (int)temp;
        }

        return result;
    }

    private int trimFrontWhitespace(String str) {

        int len = str.length();

        for(int i = 0; i < len; ++i) {
            char c = str.charAt(i);
            if (c != ' ') {
                return i;
            }
        }

        return len - 1;
    }
}
