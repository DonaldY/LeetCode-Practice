package chapter1.topic4;

/**
 * @author donald
 * @date 2022/08/20
 *
 * 171. Excel 表列序号
 *
 * 这个题目说的是，给你一个 Excel 表格的列标题，你要返回它对应的列编号。
 *
 * 注意，题目给出的列标题总是有效的。
 *
 * // Excel 表格中，列标题与列编号的对应关系
 *   A -> 1
 *   B -> 2
 *   ...
 *   Z -> 26
 *   AA -> 27
 *   AB -> 28
 *   ...
 *
 * 比如说，给你的列标题是 A，你要返回的对应编号是 1：
 *
 * A -> 1
 *
 * 再比如说，给你的列标题是 AB，你要返回的编号是 28：
 *
 * AB -> 28
 *
 * 输入: columnTitle = "ZY"
 * 输出: 701
 *
 * Z = 26 * 26
 * Y = 25
 */
public class LeetCode_171 {

    // Time: O(n), Space: O(1), Faster: 41.23%
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (char c : columnTitle.toCharArray()) {
            result = result * 26 + (c - 'A' + 1);
        }
        return result;
    }

    // Time: O(n), Space: O(1), Faster: 100.00%
    public int titleToNumberRight2Left(String s) {
        int base = 1, num = 0;
        for (int i = s.length()-1; i >= 0; --i) {
            num += (s.charAt(i) - 'A' + 1) * base;
            base *= 26;
        }
        return num;
    }
}
