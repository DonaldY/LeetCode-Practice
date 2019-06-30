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
 *
 * 一个可以有效地转成数字的字符串包含以下特点：
 *
 * 1. 可以有前导空格或前导 0，但不能有其它前导字符
 * 2. 可能会有一个加号或减号表示正负，也可能没有，连续的多个加号或减号则视为不合法
 * 3. 紧接着是一段连续的数字，如果没有数字则示为不合法
 * 4. 数字后的其它字符都可以忽略
 * 5. 如果数字大于 int 的最大值或小于 int 的最小值，返回相应的极值即可
 * 6. 字符串如果不能合法地转为整数，则返回 0
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

    public int string2Integer(String str) {
        int start = 0, p = 0, n = str.length();
        boolean negative = false;
        while (p < n && str.charAt(p) == ' ') ++p;
        if (p == n) return 0;

        if (str.charAt(p) == '+') {
            ++p;
        } else if (str.charAt(p) == '-') {
            ++p;
            negative = true;
        }

        while (p < n && str.charAt(p) == '0') ++p;
        start = p;

        while (p < n && str.charAt(p) >= '0' && str.charAt(p) <= '9') ++p;
        if (p == start) return 0;

        if (p - start > 10) {
            if (negative) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }

        long num = 0;
        for (int i = start; i < p; ++i)
            num = num * 10 + (str.charAt(i) - '0');
        num = negative ? -num : num;

        if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else return (int)num;
    }
}
