package chapter9.topic4;

/**
 * @author donald
 * @date 2022/10/03
 *
 * 1784. 检查二进制字符串字段
 *
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 *
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 *
 * 如果 s 中 由连续若干个 '1' 组成的字段 数量不超过 1，返回 true​​​ 。否则，返回 false 。
 *
 *
 * 示例 1：
 * 输入：s = "1001"
 * 输出：false
 * 解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
 *
 * 示例 2：
 * 输入：s = "110"
 * 输出：true
 *
 *
 */
public class LeetCode_1784 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public boolean checkOnesSegment(String s) {
        if (null == s || s.length() == 0) return true;
        boolean flag = false;
        int cnt = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '1') ++cnt;
            if (s.charAt(i) == '1' && s.charAt(i - 1) != '1') flag = true;
        }
        if (cnt <= 1) return true;
        return !flag;
    }
}
