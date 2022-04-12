package chapter5.topic1;

/**
 * @author donald
 * @date 2022/04/12
 *
 * 806. 写字符串需要的行数
 *
 * 我们要把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为100个单位，如果我们在写某个字母的时候会使这行超过了100 个单位，
 * 那么我们应该把这个字母写到下一行。我们给定了一个数组 widths ，这个数组 widths[0] 代表 'a' 需要的单位，
 *  widths[1] 代表 'b' 需要的单位，...， widths[25] 代表 'z' 需要的单位。
 *
 * 现在回答两个问题：至少多少行能放下S，以及最后一行使用的宽度是多少个单位？将你的答案作为长度为2的整数列表返回。
 *
 * 示例 1:
 * 输入:
 * widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "abcdefghijklmnopqrstuvwxyz"
 * 输出: [3, 60]
 * 解释:
 * 所有的字符拥有相同的占用单位10。所以书写所有的26个字母，
 * 我们需要2个整行和占用60个单位的一行。
 *
 * 题意： 输出行数
 *
 * 思路：
 * 1. 暴力法： 遍历每个字母
 *    line 表示当前多少行
 *    res  表示当前光标所在的位置
 */
public class LeetCode_806 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public int[] numberOfLines(int[] widths, String s) {

        int line = 1, res = 0;

        for (char c : s.toCharArray()) {

            int num = widths[c - 'a'];
            if (res + num > 100) {
                ++line;
                res = num;
            } else {
                res += num;
            }
        }

        return new int[] {line, res};
    }
}
