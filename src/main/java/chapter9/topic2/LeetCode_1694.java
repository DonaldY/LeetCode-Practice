package chapter9.topic2;

import chapter1.topic1.LeetCode_1;

/**
 * @author donald
 * @date 2022/10/01
 *
 * 1694. 重新格式化电话号码
 *
 * 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
 *
 * 请你按下述方式重新格式化电话号码。
 *
 * 首先，删除 所有的空格和破折号。
 * 其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 * 2 个数字：单个含 2 个数字的块。
 * 3 个数字：单个含 3 个数字的块。
 * 4 个数字：两个分别含 2 个数字的块。
 * 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
 *
 * 返回格式化后的电话号码。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：number = "1-23-45 6"
 * 输出："123-456"
 * 解释：数字是 "123456"
 * 步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * 步骤 2：剩下 3 个数字，将它们放入单个含 3 个数字的块。第 2 个块是 "456" 。
 * 连接这些块后得到 "123-456" 。
 * 示例 2：
 *
 * 输入：number = "123 4-567"
 * 输出："123-45-67"
 * 解释：数字是 "1234567".
 * 步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * 步骤 2：剩下 4 个数字，所以将它们分成两个含 2 个数字的块。这 2 块分别是 "45" 和 "67" 。
 * 连接这些块后得到 "123-45-67" 。
 *
 *
 * 思路： 模拟题
 */
public class LeetCode_1694 {

    public static void main(String[] args) {

        LeetCode_1694 leetCode_1694 = new LeetCode_1694();
        System.out.println(leetCode_1694.reformatNumber("1-23-45 6"));
        System.out.println("123456".substring(0, 3));
    }

    // Time: O(n), Space: O(1), Faster: 97.83%
    public String reformatNumber(String number) {
        if (null == number || number.length() == 0) return "";
        number = number.replace("-", "");
        number = number.replace(" ", "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length();) {
            int num = number.length() - i;
            if (num == 4) {
                sb.append(number.substring(i, i + 2));
                i += 2;
                sb.append("-");
                sb.append(number.substring(i, i + 2));
                i = number.length();
            } else if (num >= 3) {
                sb.append(number.substring(i, i + 3));
                i += 3;
            } else {
                sb.append(number.substring(i, number.length()));
                i = number.length();
            }
            sb.append("-");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
