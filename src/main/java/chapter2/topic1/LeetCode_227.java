package chapter2.topic1;

/**
 * @author donald
 * @date 2020/6/3
 *
 * 227. Basic Calculator II
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 *
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 *
 *
 * 题意：
 * 给你一个字符串表达式，你要实现一个简易计算器，对它进行求值。
 *
 * 表达式中只包含非负整数， +、-、*、/ 运算符以及空格。表达式中的除法使用整数除法，即两数相除只取整数部分。
 *
 * 注意，给出的表达式总是有效的，并且不允许使用内置的字符串求值函数。
 *
 * 思路：
 *
 * 需要做以下三件事：
 * - 把字符串形式的数字转成整数
 * - 根据运算符进行整数运算
 * - 跳过（忽略）空格
 *
 * 1. 数字栈：用于存放数字; 操作符栈：用于存放操作符。
 *    高操作符的先运算
 *
 * 2. 把和分为两部分， sum  和 part
 */
public class LeetCode_227 {

    // Time: O(n), Space: O(1), Faster: 96.37%
    public int calculate(String s) {

        int p = 0, n = s.length();
        int sum = 0, part = 0;
        char op = '+';

        while (p < n) {
            while (s.charAt(p) == ' ') ++p;
            int num = 0;
            while (p < n && s.charAt(p) >= '0' && s.charAt(p) <= '9') {
                num = num * 10 + s.charAt(p) - '0';
                ++p;
            }

            if (op == '+') {
                sum += part;
                part = num;
            } else if (op == '-') {
                sum += part;
                part = -num;
            } else if (op == '*') {
                part *= num;
            } else {
                part /= num;
            }
            while (p < n && s.charAt(p) == ' ') ++p;
            if (p < n) op = s.charAt(p++);
        }
        return sum + part;
    }

}
