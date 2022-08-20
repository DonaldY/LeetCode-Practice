package chapter1.topic4;

/**
 * @author donald
 * @date 2022/08/20
 *
 * 168. Excel表列名称
 *
 * 这个题目说的是，给你一个正整数，你要将它转换成 Excel 表格中的列标题。
 *
 * // Excel 表格中，列编号与列标题的对应关系
 *   1 -> A
 *   2 -> B
 *   ...
 *   26 -> Z
 *   27 -> AA
 *   28 -> AB
 *   ...
 *
 * 比如说，给你的正整数是 1，你要返回的列标题是字符串 A：
 *
 * 1 -> A
 *
 * 再比如说，给你的正整数是 28，你要返回的列标题是字符串 AB：
 *
 * 28 -> AB
 *
 *
 */
public class LeetCode_168 {

    public static void main(String[] args) {
        System.out.println((char)( 'A' + 1));
    }

    // Time: O(log_26(n)), Space: O(1), Faster: 100.00%
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber -= 1;
            char c = (char)(columnNumber % 26 + 'A');
            sb.append(c);
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
