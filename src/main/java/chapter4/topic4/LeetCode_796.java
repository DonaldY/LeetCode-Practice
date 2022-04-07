package chapter4.topic4;

/**
 * @author donald
 * @date 2022/04/07
 *
 * 796. 旋转字符串
 *
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。 
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 *  
 *
 * 提示:
 * - 1 <= s.length, goal.length <= 100
 * - s 和 goal 由小写英文字母组成
 *
 *
 */
public class LeetCode_796 {

    // Time: O(1), Space: O(1), Faster: 100.00%
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
