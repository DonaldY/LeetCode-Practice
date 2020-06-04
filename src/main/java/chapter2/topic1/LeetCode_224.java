package chapter2.topic1;

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
 * 使用堆栈进行操作
 *
 */
public class LeetCode_224 {

    public int calculate(String s) {

        if (null == s || s.length() == 0) return 0;

        return 0;
    }
}
