package chapter2.topic1;

import java.util.Stack;

/**
 * @author donald
 * @date 2020/6/4
 *
 * 224. Basic Calculator
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 *
 * 题意：
 * 给你一个字符串表达式，你要实现一个简易计算器，对它进行求值。
 *
 * 表达式中只包含非负整数、(、)、+、- 运算符以及空格。
 *
 * 注意，给出的表达式总是有效的，并且不允许使用内置的字符串求值函数。
 *
 * 思路：
 * 1. 使用两个栈进行操作， 一个数字栈，一个操作符栈
 *
 */
public class LeetCode_224 {

    public int calculate(String s) {

        int n = s.length();
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        ops.push('(');

        for (int i = 0; i <= n; ++i) {
            if (i == n || s.charAt(i) == ')') {
                int sum = 0, num = nums.pop();
                while (ops.peek() != '(') {
                    if (ops.pop() == '-') num = -num;
                    sum += num;
                    num = nums.pop();
                }
                sum += num;
                nums.push(sum);
                ops.pop();
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int num = s.charAt(i) - '0';
                while (i+1 < n && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') {
                    num = num * 10 + s.charAt(i+1) - '0';
                    ++i;
                }
                nums.push(num);
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(') {
                ops.push(s.charAt(i));
            }
        }
        return nums.peek();
    }
}
