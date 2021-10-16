package chapter2.topic2;

/**
 * @author donald
 * @date 2021/10/16
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 282. Expression Add Operators
 *
 * Given a string num that contains only digits and an integer target,
 * return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num
 * so that the resultant expression evaluates to the target value.
 *
 * Note that operands in the returned expressions should not contain leading zeros.
 *
 * ```
 * Example 1:
 *
 * Input: num = "123", target = 6
 * Output: ["1*2*3","1+2+3"]
 * Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
 *
 *
 * Example 2:
 *
 * Input: num = "232", target = 8
 * Output: ["2*3+2","2+3*2"]
 * Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
 *
 *
 * Example 3:
 *
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * Explanation: Both "1*0+5" and "10-5" evaluate to 5.
 * Note that "1-05" is not a valid expression because the 5 has a leading zero.
 *
 *
 * Example 4:
 *
 * Input: num = "00", target = 0
 * Output: ["0*0","0+0","0-0"]
 * Explanation: "0*0", "0+0", and "0-0" all evaluate to 0.
 * Note that "00" is not a valid expression because the 0 has a leading zero.
 *
 *
 * Example 5:
 *
 * Input: num = "3456237490", target = 9191
 * Output: []
 * Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
 * ```
 *
 * 思路：
 * 1. 方法一：回溯
 *    「回溯法」来模拟这个过程
 *    定义递归函数 backtrack(expr,i,res,mul)，其中：
 *    - expr 为当前构建出的表达式
 *    - i 表示当前的枚举到了 num 的第 i 个数字；
 *    - res 为当前表达式的计算结果；
 *    - mul 为表达式最后一个连乘串的计算结果
 * 该递归函数分为两种情况：
 *    - 如果 i=n，说明表达式已经构造完成，若此时有 res=target ，则找到了一个可行解，我们将 expr 放入答案数组中，递归结束；
 *    - 如果 i<n，需要枚举当前表达式末尾要添加的符号 ( +号、- 号或 * 号)，以及该符号之后需要截取多少位数字。
 *      设该符号之后的数字为 val，按符号分类讨论：
 *      - 若添加 + 号，则 res 增加 val，且 val 单独组成表达式最后一个连乘串；
 *      - 若添加 - 号，则 res 减少 val，且 −val 单独组成表达式最后一个连乘串；
 *      - 若添加 * 号，由于乘法运算优先级高于加法和减法运算，我们需要对 res 撤销之前 mul 的计算结果，
 *      并添加新的连乘结果 mul∗val，也就是将 res 减少 mul 并增加 mul∗val。
 *
 */
public class LeetCode_282 {

    int n;
    String num;
    int target;
    List<String> ans;

    // Time: O(4^n), Space: O(n), Faster:
    public List<String> addOperators(String num, int target) {
        this.n = num.length();
        this.num = num;
        this.target = target;
        this.ans = new ArrayList<String>();
        StringBuffer expr = new StringBuffer();
        backtrack(expr, 0, 0, 0);
        return ans;
    }

    public void backtrack(StringBuffer expr, int i, long res, long mul) {
        if (i == n) {
            if (res == target) {
                ans.add(expr.toString());
            }
            return;
        }
        int signIndex = expr.length();
        if (i > 0) {
            expr.append(0); // 占位，下面填充符号
        }
        long val = 0;
        // 枚举截取的数字长度（取多少位），注意数字可以是单个 0 但不能有前导零
        for (int j = i; j < n && (j == i || num.charAt(i) != '0'); ++j) {
            val = val * 10 + num.charAt(j) - '0';
            expr.append(num.charAt(j));
            if (i == 0) { // 表达式开头不能添加符号
                backtrack(expr, j + 1, val, val);
            } else { // 枚举符号
                expr.setCharAt(signIndex, '+');
                backtrack(expr, j + 1, res + val, val);
                expr.setCharAt(signIndex, '-');
                backtrack(expr, j + 1, res - val, -val);
                expr.setCharAt(signIndex, '*');
                backtrack(expr, j + 1, res - mul + mul * val, mul * val);
            }
        }
        expr.setLength(signIndex);
    }
}
